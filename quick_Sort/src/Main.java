import java.util.Random;

public class Main {
    static int[] intArray = new int[10];
    public static void main(String[] args) {
        for (int index = 0; index < intArray.length; index++) {            //sets all the values in the position list to a random value from 1 to 100 because it doesn't really matter
            Random rand = new Random();
            int rand_int = rand.nextInt(99) + 1;
            intArray[index] = rand_int;
        }
        intArray[4] = 20;
        intArray[9] = 3;
        for(int num:intArray){
            if(num != intArray[intArray.length - 1])
                System.out.printf("%s, ",num);
            else{
                System.out.print(num);
            }
        }
        System.out.println();

        quickSort(intArray, 0, intArray.length - 1);
        printArray(intArray);
        System.out.println();

    }

    public static int partition(int[] arr, int low, int high){
        int middle = (low + high) / 2;
        swap(arr, middle, high);
        for(int index_low = 0; index_low < middle; index_low++){
            printArray(arr);
            System.out.println(arr[index_low] + " " + arr[high]);
            if(arr[index_low] > arr[high]){
                int index_high = high - 1;
                System.out.println(index_high);
                for(int x = 0; index_high > middle; index_high--) {
                    System.out.println(arr[index_low] + " " + arr[high] + " " + arr[index_high]);
                    if (arr[high] > arr[index_high]) {
                        swap(arr, index_low, index_high);
                        printArray(arr);
                        index_high = 0;
                    }
                }
                System.out.println(index_high);
                if(index_high == middle){
                    int[] intArray = new int[10];
                    int indexTwo = 0;
                    for(int index = 0; index < intArray.length - 1; index ++){
                        if(index_low == indexTwo){
                            indexTwo++;
                        }
                        intArray[index] = arr[indexTwo];
                        indexTwo++;
                    }
                    intArray[high - 1] = arr[index_low];
                    intArray[high] = arr[high];
                    arr = intArray;
                    index_low--;
                    middle--;
                    System.out.println(middle);
                }
            }
            printArray(arr);
        }
        while(arr[middle] < arr[high]){
            middle++;
        }
        swap(arr, middle, high);
        printArray(arr);
        intArray = arr;
        return middle;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int low, int high){
        System.out.println((high - low));
        if((high - low) > 1){
            int middle = partition(arr, low, high);
//            quickSort(arr, middle + 1, high);
//            quickSort(arr, low, middle - 1);
        }
    }

    public static void printArray(int[] arr){
        for(int num:arr) {
            System.out.printf("%s, ", num);
        }
        System.out.println();
    }
}
