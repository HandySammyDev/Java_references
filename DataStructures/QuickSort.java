package Learning;

public class QuickSort {

    // Quick Sort = moves smaller elements to left of a pivot.
    //              recursively divide array in 2 partitions

    // Run-time complexity = Best case O(n log(n))
    //                       Average case O(n log(n))
    //                       Worst case O(n^2) if already sorted

    // Space complexity    = O(log(n)) due to recursive

    public static void main(String[] args){
        int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};

        quickSort(array, 0, array.length - 1);

        for(int i : array){
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] array, int start, int end){
        if(end <= start) return; //base case, eventually we won't be able to divide our array so it will stop

        //All elements to the left will be smaller and all elements to the right will be larger than the pivot
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1); //left partition
        quickSort(array, pivot + 1,  end); //right partition
    }

    private static int partition(int[] array, int start, int end){

        int pivot = array[end]; // The pivot will always be at the end to begin with
        int i = start - 1; // = -1

        for(int j = start; j <= end - 1; j++){
            if(array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
}
