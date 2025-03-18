import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int fifty = 50;
        while (fifty > 0){
            int[] intArray = new int[10];
            for (int index = 0; index < intArray.length; index++) {            //sets all the values in the position list to a random value from 1 to 100 because it doesn't really matter
                Random rand = new Random();
                int rand_int = rand.nextInt(99) + 1;
                intArray[index] = rand_int;
            }
            for (int num : intArray) {
                if (num != intArray[intArray.length - 1])
                    System.out.printf("%s, ", num);
                else {
                    System.out.print(num);
                }
            }
            System.out.println();

            quickSort(intArray, 0, intArray.length - 1);
            printArray(intArray);
            System.out.println();
            fifty--;
        }
    }

    public static int partition(int[] arr, int low, int high){
        int middle = (low + high) / 2;
        swap(arr, middle, high);
        for(int index_low = 0; index_low < middle; index_low++){
            //printArray(arr);
            if(arr[index_low] > arr[high]){
                int index_high;
                for(index_high = high - 1; index_high > middle; index_high--) {
                    if (arr[high] > arr[index_high]) {
                        swap(arr, index_low, index_high);
                        //printArray(arr);
                        index_high = 0;
                    }
                }
                if(index_high == middle){
                    for(int outer_loop = index_low; outer_loop < high - 1; outer_loop++){
                        swap(arr, outer_loop, outer_loop + 1);
                    }
                    index_low--;
                    middle--;
                }
            }
        }
        while(arr[middle] < arr[high]){
            middle++;
        }
        swap(arr, middle, high);
        return middle;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int low, int high){
        if((high - low) > 0){
            int middle = partition(arr, low, high);
            quickSort(arr, middle + 1, high);
            quickSort(arr, low, middle - 1);
        }
    }

    public static void printArray(int[] arr){
        for(int num:arr) {
            System.out.printf("%s, ", num);
        }
        System.out.println();
    }
}
