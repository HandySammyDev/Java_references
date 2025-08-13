package Learning;

public class MergeSort {
    // Merge sort = recursively divide array in 2, sort, re-combine
    // Run-time complexity = O(n Log n)
    // Space complexity    = O(n)

    public static void main(String[] args){
        int[] array = {8, 2, 5, 3, 4, 7,6, 1};

        //System.out.println(array.length);
        mergeSort(array);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    private static void mergeSort(int[] array){
        int length = array.length; // length = 8
        if(length <= 1) return; //Base case

        int middle = length / 2; // 8/2 = 4
        int[] leftArray = new int[middle]; // = 4
        int[] rightArray = new int[length - middle]; // = 4

        int i = 0; // left array
        int j = 0; // right array

        for(; i < length; i++){ //length = 8
            if(i < middle){ // i < 4
                leftArray[i] = array[i];
            }
            else{
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }
    private static void merge(int[] leftArray, int[] rightArray, int[] array){

        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;
        int  i = 0, l = 0, r = 0;

        // Check the conditions for merging
        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
