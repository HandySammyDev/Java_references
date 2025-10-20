package string_split;

public class StringSplitExamples {
    public static void main(String[] args){
        split_example1();
        split_example2();
        split_example3();
        split_example4();
        split_example5();
    }
    // Splits on a single space
    public static void split_example1() {
        System.out.println("split_example1()");
        String s1 = "43.85 66.239 8.223";
        String[] vals = s1.split("\\s");
        printArray(s1, "\\\\s", vals);
    }

    // There are two spaces between the first and second numbers.
    // Thus, one of the tokens is an empty string, "".
    public static void split_example2() {
        System.out.println("\nsplit_example2()");
        String s1 = "43.85  66.239 8.223";
        String[] vals = s1.split("\\s");
        printArray(s1, "\\\\s", vals);
    }

    // Splits on one or more spaces
    public static void split_example3() {
        System.out.println("\nsplit_example3()");
        String s1 = "43.85  66.239 8.223";
        String[] vals = s1.split("[\\s]+");
        printArray(s1, "[\\\\s]+", vals);
    }

    // Splits on or more commas or spaces
    public static void split_example4() {
        System.out.println("\nsplit_example4()");
        String s1 = "4,3  5,  ,,2, 8";
        String[] vals = s1.split("[,\\s]+");
        printArray(s1, "[,\\\\s]+", vals);
    }

    // Splits on common punctuation
    public static void split_example5() {
        System.out.println("\nsplit_example5()");
        String s1 = "This. Is,,, \nfunny; \t\tyes: why?   now!";
        String[] vals = s1.split("[.,;:?!\\s]+");
        printArray(s1, "[.,;:?!\\\\s]+", vals);
    }

    public static void printArray(String str, String delimeter, String[] vals) {
        String msg = "\"" + str + "\".split(\"" + delimeter + "\")=\n";
        int i=1;
        for(String s : vals) {
            msg += (i++) + ". \"" + s + "\"\n";
        }
        System.out.println(msg);
    }

}
