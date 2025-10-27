package hashset_examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SpeedComparison {
    static final int[] INITIAL_LIST_SIZE = {50000, 100000, 150000, 200000};
    static final int NUM_REMOVES = 25000;

    public static void main(String[] args) {
        for( int listSize : INITIAL_LIST_SIZE) {
            // Create ArrayList
            ArrayList<Integer> aryList = generateArrayList(listSize);
            // Create values to remove
            ArrayList<Integer> valsToRemove = generateRemovesList(NUM_REMOVES,aryList);
            // Create LinkedList from ArrayList
            List<Integer> lnkList = new LinkedList<>(aryList);
            // Create HashSet from ArrayList
            Set<Integer> hashSet = new HashSet<>(aryList);

            doExperiment(lnkList, valsToRemove);
            doExperiment(aryList, valsToRemove);
            doExperiment(hashSet, valsToRemove);
        }
    }

    public static ArrayList<Integer> generateArrayList(int numValues) {
        ArrayList<Integer> ints = new ArrayList<>();

        int numAdded = 0;
        while( numAdded < numValues ) {
            // Generate an integer between 0 and max int
            int val = (int)(Math.random()*Integer.MAX_VALUE);

            if( !ints.contains(val)) {
                // If value is not in set, then add it to set and list
                ints.add(val);
                numAdded++;
            }
        }
        return ints;
    }

    public static ArrayList<Integer> generateRemovesList(int numValues, ArrayList<Integer> vals) {
        // Build set of indices
        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<vals.size(); i++) {
            indices.add(i);
        }
        // So that random order is achieved
        Collections.shuffle(indices);

        // Build removes list
        ArrayList<Integer> removes = new ArrayList<>();
        for(int i=0; i<numValues; i++) {
            removes.add(vals.get(indices.get(i)));
        }
        return removes;
    }

    public static void doExperiment(Collection<Integer> list, Collection<Integer> vals) {
        // Use for output
        int initialSize = list.size();
        String className = list.getClass().getName();
        int locPeriod = className.lastIndexOf(".");
        className = className.substring(locPeriod+1);
        String msg = String.format("%s size: %d, time to remove %d vals: ", className, list.size(), vals.size());

        // Begin timing
        long begTime = System.currentTimeMillis();

        for(int x : vals) {
            list.remove(x);
        }
        // Stop timing
        long endTime = System.currentTimeMillis();
        // Calculate total time in seconds.
        double totTime = (endTime-begTime)/1000.0;
        msg += String.format("%.3f sec", totTime);
        System.out.println(msg);
    }
}