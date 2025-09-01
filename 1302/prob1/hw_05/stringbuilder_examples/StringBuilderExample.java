package stringbuilder_examples;

public class StringBuilderExample {

    public static void main(String[] args) {
        testStringBuilder();
        testStringBuilderEfficiency();
    }

    public static void testStringBuilder() {
        String[] pets = {"Chaps", "Moco", "Zoro", "Ace"};

        StringBuilder sb = new StringBuilder("My Pets:\n");

        for (int i = 0; i < pets.length; i++) {
            sb.append((i + 1) + ". " + pets[i] + "\n");
        }
        sb.append("There are " + pets.length + " in total");
        System.out.println(sb.toString());
    }

    public static void testStringBuilderEfficiency() {
        int size = 30000;
        double[] vals = buildRandomDoubleArray(size);
        String doubleString1 = testStringConcat(vals);
        String doubleString2 = testStringBuilderConcat(vals);
    }

    public static double[] buildRandomDoubleArray(int size) {
        double[] vals = new double[size];
        for( int i=0; i<vals.length; i++ ) {
            vals[i] = Math.random()*1000.0;
        }
        return vals;
    }

    public static String testStringConcat(double[] vals) {
        System.out.println("testStringConcat()");
        long begTime = System.currentTimeMillis();
        String doublesString = "";
        for(double d : vals) {
            doublesString += d + ", ";
        }
        long endTime = System.currentTimeMillis();
        double totTime = (endTime-begTime)/1000.0;
        String msg = String.format("  Concatenate %,d doubles = %.3f sec", vals.length, totTime);
        System.out.println(msg);
        return doublesString;
    }

    public static String testStringBuilderConcat(double[] vals) {
        System.out.println("testStringBuilderConcat()");
        long begTime = System.currentTimeMillis();
        StringBuilder doublesString = new StringBuilder();
        for(double d : vals) {
            doublesString.append(d + ", ");
        }
        long endTime = System.currentTimeMillis();
        double totTime = (endTime-begTime)/1000.0;
        String msg = String.format("  Concatenate %,d doubles = %.3f sec", vals.length, totTime);
        System.out.println(msg);
        return doublesString.toString();
    }
}