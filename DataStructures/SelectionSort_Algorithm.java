package PracticeBroCode;

public class SelectionSort_Algorithm {
    // selection sort = search through an array and keep track of the minimum value during
    //                  each iteration. At the end of each iteration, we swap variables.

    //                  Quadratic time O(n^2)
    //                  small data set = okay (more than bubble sort)
    //                  large data set = BAD

    public static void main(String[] args){
        int[] array = {1,6,3,8,9,10,23,41,2};

        selectionSort(array);

        for(int i : array){
            System.out.println(i);
        }
    }

    private static void selectionSort(int[] array){
        for(int i = 0; i<array.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[min] > array[j]){
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
