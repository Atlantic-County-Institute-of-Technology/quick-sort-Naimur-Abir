import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        for (int index = 0; index < intArray.length; index++) {            //sets all the values in the position list to a random value from 1 to 100 because it doesn't really matter
            Random rand = new Random();
            int rand_int = rand.nextInt(99) + 1;
            intArray[index] = rand_int;
        }
        intArray[4] = 1;
        for(int num:intArray){
            if(num != intArray[intArray.length - 1])
                System.out.printf("%s, ",num);
            else{
                System.out.print(num);
            }
        }
        System.out.println();

        quickSort(intArray, 0, intArray.length - 1);
        for(int num:intArray) {
            if (num != intArray[intArray.length - 1])
                System.out.printf("%s, ", num);
            else {
                System.out.print(num);
            }
        }
        System.out.println();

    }

    public static int partition(int[] arr, int low, int high){
        int middle = (low + high) / 2;
        swap(arr, middle, high);
        return middle;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        for(int index_low = 0; index_low < i; index_low++){
            printArray(arr);
            System.out.println(arr[index_low] + " " + arr[j]);
            if(arr[index_low] > arr[j]){
                int index_high = j - 1;
                for(int x = 0; index_high > 0; index_high--) {
                    System.out.println(arr[index_low] + " " + arr[j] + " " + arr[index_high]);
                    if (arr[j] > arr[index_high]) {
                        temp = arr[index_low];
                        arr[index_low] = arr[index_high];
                        arr[index_high] = temp;
                        printArray(arr);
                        index_high = 0;
                    }
                }
                if(index_high == 0){
                    int[] intArray = new int[10];
                    int indexTwo = 0;
                    for(int index = 0; index < intArray.length - 2; index ++){
                        if(index_low == indexTwo){
                            indexTwo++;
                        }
                        intArray[index] = arr[indexTwo];
                        indexTwo++;
                    }
                    intArray[intArray.length - 2] = arr[index_low];
                    intArray[intArray.length - 1] = arr[intArray.length - 1];
                    arr = intArray;
                }
            }
            printArray(arr);
        }
        int index = i;
        temp = arr[index];
        while(temp == arr[index]){
            if(arr[index] > arr[j]){
                arr[index] = arr[j];
                arr[j] = temp;
                temp = -1;
            }
            else{
                index++;
            }
        }

    }

    static void quickSort(int[] arr, int low, int high){
        System.out.println((high - low));
        if((high - low) > 0){
            int middle = partition(arr, low, high);
        }
    }

    public static void printArray(int[] arr){
        for(int num:arr) {
            System.out.printf("%s, ", num);
        }
        System.out.println();
    }
}
