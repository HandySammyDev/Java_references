package Learning;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args){
        // Binary search = Search algorithm that finds the position
        //                 of a target value within a sorted array.
        //                 Half of array is eliminated during each "step"



        int[] array = new int[100];
        int target = 5;

        for(int i=0; i<array.length; i++){
            array[i] = i;
        }

        int index = binarySearch(array, target);

        if(index==-1){
            System.out.println(target + " not found");
        }
        else{
            System.out.println("Element found at: " + index);
        }
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while(low<=high){
            int middle = low + (high-low) /2;
            int value = array[middle];

            System.out.println("Middle: " + value);

            if(value < target){
                low = middle +1;
            }
            else if(value > target){
                high = middle - 1;
            }
            else{
                return middle;
            }
        }

        return -1;
    }

    //                                  Summary:
    // Grabs the middle element and sees if its greater or less than the middle number.
    // Then it goes for the next middle element and continues until the number is found
    // This takes fewer steps like a for loop which goes from 1-100
    // This goes: Target = 5; Array[100]; 49 => 24 => 11 => 5 Only 4 steps. (Efficient for large data sets)
}
