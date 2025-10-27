package comparator_examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SpeedComparison {
    static final int[] INITIAL_LIST_SIZE = {1000, 10000, 100000, 200000};
    static final int[] NUM_SEARCHES = {100, 1000, 10000, 20000};
    static final EmployeeSSNComparator ssnComp = new EmployeeSSNComparator();

    public static void main(String[] args) {
        // Lambda expressions
        SearchInterface indexOfSearch = (emps,key,comp) -> emps.indexOf(key);
        SearchInterface binarySearch = (emps,key,comp) -> Collections.binarySearch(emps,key,comp);

        int i=0;
        for(int listSize : INITIAL_LIST_SIZE) {
            // Create list of employees
            ArrayList<Employee> emps = createListOfRandomEmployees(listSize);
            // Create list of SSN's to search for (all will be found)
            ArrayList<Integer> ssnsToSearchFor = createListOfSSNToSearchFor(emps, NUM_SEARCHES[i++]);

            doExperiment(emps, ssnsToSearchFor, binarySearch, " Binary Search");
            doExperiment(emps, ssnsToSearchFor, indexOfSearch, "indexOf Search");
        }
    }

    public static void doExperiment(List<Employee> emps, List<Integer> keys,
                                    SearchInterface searchOperation, String title) {

        String msg = buildHeader(emps, keys, title);

        // Begin timing
        long begTime = System.currentTimeMillis();
        // Sort list if doing binary search
        if(title.equals(" Binary Search")) {
            Collections.sort(emps, ssnComp);
        }
        // Search for keys
        for(int key : keys) {
            Employee eKey = new Employee("?", key, 0.0);
            int pos = searchOperation.search(emps, eKey, ssnComp);
        }
        // Stop timing
        long endTime = System.currentTimeMillis();

        msg = buildFooter(msg, begTime, endTime);
        System.out.println(msg);
    }


    private static String buildFooter(String msg, long begTime, long endTime) {
        // Calculate total time in seconds.
        double totTime = (endTime-begTime)/1000.0;
        msg += String.format("%7.3f sec", totTime);
        return msg;
    }

    private static String buildHeader(List<Employee> emps, List<Integer> keys, String title) {
        String className = emps.getClass().getName();
        int locPeriod = className.lastIndexOf(".");
        className = className.substring(locPeriod+1);
        String msg = String.format(title + " : %s size: %,7d, time to search for %,7d vals: ",
                className, emps.size(), keys.size());
        return msg;
    }

    public static ArrayList<Integer> createListOfSSNToSearchFor(ArrayList<Employee> emps, int numValues) {
        ArrayList<Integer> ssns = new ArrayList<>();
        int size = emps.size();
        for(int i=0; i<numValues; i++) {
            // Get location
            int loc = (int)(size*Math.random());
            // Get Employee
            Employee e = emps.get(loc);
            ssns.add(e.getSSNum());
        }
        return ssns;
    }

    public static ArrayList<Employee> createListOfRandomEmployees(int numValues) {
        ArrayList<Employee> emps = new ArrayList<>();
        for(int i=0; i<numValues; i++) {
            Employee e = createRandomEmployee();
            emps.add(e);
        }
        return emps;
    }

    private static Employee createRandomEmployee() {
        return new Employee(
                createRandomName(),
                createRandomSSN(),
                createRandomSalary());
    }

    private static String createRandomName() {
        String name = "";
        for(int i=0; i<3; i++) {
            int val = (int)(1+26*Math.random());
            char c = (char)val;
            name += c;
        }
        return name;
    }

    private static int createRandomSSN() {
        String strSSN = "";
        // No 0's in SSN for simplicity, since SSN is int
        for(int i=0; i<9; i++) {
            int val = (int)(1+9*Math.random());
            strSSN += val;
        }
        int ssn = Integer.parseInt(strSSN);
        return ssn;
    }

    private static double createRandomSalary() {
        double val = 8+50*Math.random();
        String strSal = String.format("%.2f", val);
        double salary = Double.parseDouble(strSal);
        return salary;
    }

}

