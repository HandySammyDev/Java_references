package Learning;

public class Interpolation_Search {
    public static void main(String[] args){
        // Interpolation search = improvement over binary search best used for "uniformly" distributed data
        //                        "guesses" where a value might be based on calculated probe results
        //                        if probe is incorrect, search area is narrowed, and a new probe is calculated

        //                        Average case: O(log(log(n)))
        //                        Worst case: O(n) [values increase exponentially]

        //int[] array = {1,2,3,4,5,6,7,8,9}; // This is very easy to search so it gets it first try.
        int[] array = {1,2,4,8,16,32,64,128,256,512,1024};

        int index = interpolationSearch(array, 256);

        if(index != -1){
            System.out.println("Element found at index: " + index);
        }
        else{
            System.out.println("Element not found");
        }
    }

    private static int interpolationSearch(int[] array, int value) {
        int high = array.length-1;
        int low = 0;

        while(value >= array[low] && value <= array[high] && low <= high){
            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);
            System.out.println("Probe: " + probe);

            if(array[probe] == value){
                 return probe;
            }
            else if(array[probe] < value){
                low = probe + 1;
            }
            else{
                high = probe - 1;
            }
        }
        return -1;
    }

    //                                    Summary:
    // It's an algorithm that works like a binary search but better for uniformly data sets like 1-10.
    // Does not work with random data sets.
}
