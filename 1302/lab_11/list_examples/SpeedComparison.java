package list_examples;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpeedComparison {

    static final int[] INITIAL_LIST_SIZE = {100000, 200000, 300000, 400000, 500000};
    static final int NUM_INSERTIONS = 100000;

    public static void main(String[] args) {

        for( int listSize : INITIAL_LIST_SIZE) {
            // Create values to insert
            ArrayList<Integer> valsToInsert = generateArrayList(NUM_INSERTIONS);
            // Create ArrayList
            ArrayList<Integer> aryList = generateArrayList(listSize);
            // Create LinkedList from ArrayList
            List<Integer> lnkList = new LinkedList<>(aryList);

            doExperiment(aryList, valsToInsert);
            doExperiment(lnkList, valsToInsert);
        }
    }

    public static ArrayList<Integer> generateArrayList(int numValues) {
        ArrayList<Integer> ints = new ArrayList<>();
        for(int i=0; i<numValues; i++) {
            // Generate an integer between 0 and max int
            int val = (int)(Math.random()*Integer.MAX_VALUE);
            ints.add(val);
        }
        return ints;
    }

    public static void doExperiment(List<Integer> list, List<Integer> vals) {
        // Use for output
        String className = list.getClass().getName();
        int locPeriod = className.lastIndexOf(".");
        className = className.substring(locPeriod+1);
        String msg = String.format("%s size: %d, time to add %d vals: ", className, list.size(), vals.size());

        // Begin timing
        long begTime = System.currentTimeMillis();

        for(int x : vals) {
            list.add(0,x);
        }
        // Stop timing
        long endTime = System.currentTimeMillis();
        // Calculate total time in seconds.
        double totTime = (endTime-begTime)/1000.0;
        msg += String.format("%.3f sec", totTime);
        System.out.println(msg);
    }
}

