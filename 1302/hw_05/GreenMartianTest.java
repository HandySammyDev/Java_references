package prob1;

public class GreenMartianTest {

    public static void main(String[] args){
        testSpeakAndTeleportAndToString();
        testEquals_Success();
        testEquals_Fail();
        testEquals_RedAndGreen_Success();
        testCompareTo_RedAndGreenPositive();
        testPower();
    }

    public static void testSpeakAndTeleportAndToString(){
        System.out.println("\n-->testSpeakAndTeleportAndToString");

        Martian m = new GreenMartian(2, 3);
        System.out.println("Expected speak= id=2, Grobldy Grock");
        System.out.println("Actual speak= " + m.speak() + "\n");
        System.out.println("Expected teleport= id=2 teleporting to China");
        Teleporter t = (Teleporter)m;
        System.out.println("Actual teleport= " + t.teleport("China") + "\n");
        System.out.println("Expected toString= Green Martian - id=2, vol=3");
        System.out.println("Actual toString= " + m);
    }

    public static void testEquals_Success(){
        System.out.println("\n-->testEquals_Success");

        Martian m1 = new GreenMartian(1, 3);
        Martian m2 = new GreenMartian(1, 2);
        boolean equals = m1.equals(m2);
        System.out.println("Expected= true");
        System.out.println("Actual= " + equals);

    }

    public static void testEquals_Fail(){
        System.out.println("\n-->testEquals_Fail");

        Martian m1 = new GreenMartian(1, 3);
        Martian m2 = new GreenMartian(2, 2);
        boolean equals = m1.equals(m2);
        System.out.println("Expected= false");
        System.out.println("Actual= " + equals);
    }

    public static void testEquals_RedAndGreen_Success(){
        System.out.println("\n-->testEquals_RedAndGreen_Success");

        Martian m1 = new GreenMartian(2, 3);
        Martian m2 = new RedMartian(2, 2);
        boolean equals = m1.equals(m2);
        System.out.println("Expected= true");
        System.out.println("Actual= " + equals);
    }

    public static void testCompareTo_RedAndGreenPositive(){
        System.out.println("\n-->testCompareTo_RedAndGreenPositive");

        Martian m1 = new GreenMartian(2, 3);
        Martian m2 = new RedMartian(1, 2, 3);
        int compareTo = m1.compareTo(m2);
        System.out.println("Expected= 1");
        System.out.println("Actual= " + compareTo);
    }

    public static void testPower(){
        System.out.println("\n-->testPower");

        Martian m1 = new GreenMartian(2, 3);
        int power = m1.power();
        System.out.println("Expected= 9");
        System.out.println("Actual= " + power);
    }
}
