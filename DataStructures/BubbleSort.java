package PracticeBroCode;

public class BubbleSort {
    // Bubble sort = pairs of adjacent elements are compared,
    //               swapped if they are not in order.

    //               Quadratic time O(n^2)
    //               small data set = okay-ish
    //               large data set = BAD (plz don't use)

    public static void main(String[] args){
        int[] array = {4,2,1,6,7,9,8,10,3};

        bubbleSort(array);

        for(int i : array){
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] array){
        for(int i = 0; i<array.length-1; i++){
            for(int j=0; j<array.length - i - 1; j++){
                if(array[j] < array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
