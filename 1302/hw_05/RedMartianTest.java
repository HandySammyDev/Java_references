package prob1;

public class RedMartianTest {

    public static void main(String[] args){
        testSpeakAndToString();
        testEquals_Success();
        testEquals_Fail();
        testCompareTo_Negative();
        testCompareTo_Positive();
        testCompareTo_Zero();
        testPower();
        testPower_changeVolume();
    }

    public static void testSpeakAndToString(){
        System.out.println("\n-->testSpeakAndToString");

        Martian m = new RedMartian(2, 3, 4);
        System.out.println("Expected= id=2, Rubldy Rock");
        System.out.println("Actual= " + m.speak() + "\n");
        System.out.println("Expected= Red Martian - id=2, vol=3, ten=4");
        System.out.println("Actual= " + m);
    }

    public static void testEquals_Success(){
        System.out.println("\n-->testEquals_Success");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(1, 2, 3);
        boolean equals = m1.equals(m2);
        System.out.println("Expected= true");
        System.out.println("Actual= " + equals);
    }

    public static void testEquals_Fail(){
        System.out.println("\n-->testEquals_Fail");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 2, 3);
        boolean equals = m1.equals(m2);
        System.out.println("Expected= false");
        System.out.println("Actual= " + equals);
    }

    public static void testCompareTo_Negative(){
        System.out.println("\n-->testCompareTo_Negative");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 2, 3);
        int compareTo = m1.compareTo(m2);
        System.out.println("Expected= -1");
        System.out.println("Actual= " + compareTo);
    }

    public static void testCompareTo_Positive(){
        System.out.println("\n-->testCompareTo_Positive");

        Martian m1 = new RedMartian(2, 3, 4);
        Martian m2 = new RedMartian(1, 2, 3);
        int compareTo = m1.compareTo(m2);
        System.out.println("Expected= 1");
        System.out.println("Actual= " + compareTo);
    }

    public static void testCompareTo_Zero(){
        System.out.println("\n-->testCompareTo_Zero");

        Martian m1 = new RedMartian(2, 3, 4);
        Martian m2 = new RedMartian(2, 2, 3);
        int compareTo = m1.compareTo(m2);
        System.out.println("Expected= 0");
        System.out.println("Actual= " + compareTo);
    }

    public static void testPower(){
        System.out.println("\n-->testPower");

        Martian m1 = new RedMartian(2, 3, 4);
        int power = m1.power();
        System.out.println("Expected= 10");
        System.out.println("Actual= " + power);
    }

    public static void testPower_changeVolume(){
        System.out.println("\n-->testPower_changeVolume");

        Martian m1 = new RedMartian(2, 3, 4);
        m1.setVolume(1);
        int power = m1.power();
        System.out.println("Expected= 6");
        System.out.println("Actual= " + power);
    }
}
