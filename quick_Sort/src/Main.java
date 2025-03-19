//Naimur Abir
//Quick Sort
//3-13-2025
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        int running = = intInput.nextInt();                //takes the input as an int
        while (running > 0){                               //runs while running is greater than 0
            int[] intArray = new int[10];                  //reserves a space in memory for an array of 10 length
            for (int index = 0; index < intArray.length; index++) {            //Sets all the values in the array to random ints from 1 to 100
                Random rand = new Random();
                int rand_int = rand.nextInt(99) + 1;
                intArray[index] = rand_int;
            }
            printArray(intArray);                          //prints the array
            System.out.println();

            quickSort(intArray, 0, intArray.length - 1);   //calls the quick sort function
            
            printArray(intArray);
            System.out.println();
            running--;
        }
    }

    public static int partition(int[] arr, int low, int high){
        int middle = (low + high) / 2;                     //sets the piviot point to the middle index
        swap(arr, middle, high);                           //swaps the piviot point to the end of our current scope so it is in a position that we can keep track of
        for(int index_low = 0; index_low < middle; index_low++){        //runs untill the index_low reaches the index of the piviot point
            if(arr[index_low] > arr[high]){                //searches for any value before it that is greater than the piviot point
                int index_high;
                for(index_high = high - 1; index_high > middle; index_high--) {        //runs until index_high reaches the piviot point
                    if (arr[high] > arr[index_high]) {    //runs if there is a vaue to the right of the piviot point that is less than the piviot point
                        swap(arr, index_low, index_high); //calls the swap function
                        index_high = 0;                   //if there is a successful swap then it sets the index_high to zero and the for loop sets it to -1
                    }
                }
                if(index_high == middle){                //if index_high reaches the piviot point and no swap has occurd it means that there are no values less than the piviot point to the right of the piviot point
                    for(int outer_loop = index_low; outer_loop < high - 1; outer_loop++){    //Runs untill the current index, index_low, reaches high - 1 because high is where the piviot point is being stored
                        swap(arr, outer_loop, outer_loop + 1);                         //swaps index_low with the next index until it reaches high - 1
                    }
                    index_low--;    //when this is finsihed it sets the piviot index and index_low since the order of the list changed and the index of the piviot point changed
                    middle--;
                }
            }
        }
        while(arr[middle] < arr[high]){    //checks if the piviot number at index high is less than the previous index of the pivot number
            middle++;    //if the value of the previous index of the pivot point is less than the index of the high where the pivot number is it adds one to index of the pivoit index, or the middle variable
        }
        swap(arr, middle, high);           //swaps the pivoit number to it's index, or the "middle" index
        return middle;   //returns the current index of the pivoit number
    }

    public static void swap(int[] arr, int i, int j){    //swaps to values in the list based on their index
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int low, int high){    
        if((high - low) > 0){    //if our scope is greater than zero than it runs
            int middle = partition(arr, low, high);    //calls the partition function and sets the returned value to the index of the pivot point
            quickSort(arr, middle + 1, high);    //calls it self again until the values to the left of the middle index are sorted
            quickSort(arr, low, middle - 1);     //calls it self agaib until the values to the right od the middle index are sorted
        }
    }

    public static void printArray(int[] arr){    // just a function to print arrays
        for(int num:arr) {
            System.out.printf("%s, ", num);
        }
        System.out.println();
    }
}
