import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        for (int index = 0; index < intArray.length; index++) {            //sets all the values in the position list to a random value from 1 to 100 because it doesn't really matter
            Random rand = new Random();
            int rand_int = rand.nextInt(99) + 1;
            intArray[index] = rand_int;
        }
        for(int num:intArray){
            if(num != intArray[intArray.length - 1])
                System.out.printf("%s, ",num);
            else{
                System.out.print(num);
            }
        }
        System.out.println("\n" + partition(intArray, 0, intArray.length - 1));
        for(int num:intArray) {
            if (num != intArray[intArray.length - 1])
                System.out.printf("%s, ", num);
            else {
                System.out.print(num);
            }
        }
    }

    public static int partition(int[] arr, int low, int high){
        int middle = (low + high) / 2;
        swap(arr, middle, high);
        return middle;
    }

    public static void swap(int[] arr, int i, int j){
        if(arr[i] < arr[j]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
