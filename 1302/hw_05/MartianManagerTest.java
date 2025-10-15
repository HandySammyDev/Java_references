package prob1;

import java.util.ArrayList;
import java.util.List;

public class MartianManagerTest {

    public static void main(String[] args){
        testAddMartian_Red_Success();
        testAddMartian_Green_Success();
        testAddMartian_RGGR_Success();
        testAddMartian_RGGR_Failure();
        testToString();
        testGetMartianAt_ValidIndex();
        testGetMartianAt_InvalidIndex_Low();
        testGetMartianAt_InvalidIndex_High();
        testGetTeleporterAt_ValidIndex();
        testGetTeleporterAt_InvalidIndex_Low();
        testGetTeleporterAt_InvalidIndex_High();
        testGetMartianWithId_Success();
        testGetMartianWithId_Failure();
        testContains_Success();
        testContains_Failure();
        testGroupSpeak();
        testGroupTeleport();
        testRemoveMartianAt_Success_Red();
        testRemoveMartianAt_Success_Green();
        testRemoveMartianAt_Failure();
        testRemoveMartianWithId_Success_Red();
        testRemoveMartianWithId_Success_Green();
        testRemoveMartianWithId_Failure();
        testGetMartianClosestTo_Index_LowerMatch1();
        testGetMartianClosestTo_Index_LowerMatch2();
        testGetMartianClosestTo_Martian_LowerMatch();
        testGetSortedMartians();
        testAbsorbColony();
        testObliterateTeleporters_One();
        testObliterateTeleporters_Many();
        testBattle_One_on_One_One_Kill();
        testBattle_One_on_One_No_Kill();
        testBattle_Four_on_Two_One_Kill();
        testBattle_Five_on_Three_Two_Kills();
        testCaptureInvaders_Five_on_Three_Two_Captures();
    }

    public static void testAddMartian_Red_Success (){
        System.out.println("\n-->testAddMartian_Red_Success");

        Martian m1 = new RedMartian(2, 3, 4);
        MartianManager mm = new MartianManager();
        boolean b = mm.addMartian(m1);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= martians=1 teleporters=0 return=true");
        System.out.printf("Actual= martians=%d, teleporters=%d, return=%b%n",
                mAmount, tAmount, b);

    }

    public static void testAddMartian_Green_Success (){
        System.out.println("\n-->testAddMartian_Green_Success");

        Martian m1 = new GreenMartian(2, 3);
        MartianManager mm = new MartianManager();
        boolean b = mm.addMartian(m1);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= martians=1 teleporters=1 return=true");
        System.out.printf("Actual= martians=%d, teleporters=%d, return=%b%n",
                mAmount, tAmount, b);
    }

    public static void testAddMartian_RGGR_Success (){
        System.out.println("\n-->testAddMartian_RGGR_Success");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new GreenMartian(2, 3);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new RedMartian(4, 3, 4);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= martians=4 teleporters=2");
        System.out.printf("Actual= martians=%d, teleporters=%d\n",
                mAmount, tAmount);
    }

    public static void testAddMartian_RGGR_Failure (){
        System.out.println("\n-->testAddMartian_RGGR_Failure");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new GreenMartian(2, 3);
        Martian m3 = new GreenMartian(2, 3);
        Martian m4 = new RedMartian(4, 3, 4);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= martians=3 teleporters=1");
        System.out.printf("Actual= martians=%d, teleporters=%d\n",
                mAmount, tAmount);
    }

    public static void testToString (){
        System.out.println("\n-->testAddMartian_RGGR_Failure");

        Martian m1 = new RedMartian(1, 1, 1);
        Martian m4 = new RedMartian(2, 2, 2);
        Martian m2 = new GreenMartian(3, 1);
        Martian m3 = new GreenMartian(4, 5);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        System.out.println("Expected= \n" +
                "Martians:\n" +
                "\tRed Martian - id=1 vol=1, ten=1\n" +
                "\tRed Martian - id=2 vol=2, ten=2\n" +
                "\tGreen Martian - id=3 vol=1\n" +
                "\tGreen Martian - id=4 vol=5\n" +
                " \n" +
                "Teleporters:\n" +
                "\tGreen Martian - id=3 vol=1\n" +
                "\tGreen Martian - id=4 vol=5");
        System.out.println("Actual= \n" + mm);
    }

    public static void testGetMartianAt_ValidIndex (){
        System.out.println("\n-->testGetMartianAt_ValidIndex");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new GreenMartian(2, 3);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new RedMartian(4, 3, 4);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.getMartianAt(1);
        System.out.println("Expected= Green Martian - id=2 vol=3");
        System.out.println("Actual= " + m);
    }

    public static void testGetMartianAt_InvalidIndex_Low (){
        System.out.println("\n-->testGetMartianAt_InvalidIndex_Low");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new GreenMartian(2, 3);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new RedMartian(4, 3, 4);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.getMartianAt(-1);
        System.out.println("Expected= null");
        System.out.println("Actual= " + m);
    }

    public static void testGetMartianAt_InvalidIndex_High (){
        System.out.println("\n-->testGetMartianAt_InvalidIndex_High");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new GreenMartian(2, 3);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new RedMartian(4, 3, 4);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.getMartianAt(4);
        System.out.println("Expected= null");
        System.out.println("Actual= " + m);
    }

    public static void testGetTeleporterAt_ValidIndex (){
        System.out.println("\n-->testGetTeleporterAt_ValidIndex");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        Martian m5 = new GreenMartian(5, 3);
        Martian m6 = new GreenMartian(6, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        mm.addMartian(m5);
        mm.addMartian(m6);
        Teleporter m = mm.getTeleporterAt(2);
        System.out.println("Expected= GreenMartian - id=5 vol=3");
        System.out.println("Actual= " + m);
    }

    public static void testGetTeleporterAt_InvalidIndex_Low (){
        System.out.println("\n-->testGetTeleporterAt_InvalidIndex_Low");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        Martian m5 = new GreenMartian(5, 3);
        Martian m6 = new GreenMartian(6, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        mm.addMartian(m5);
        mm.addMartian(m6);
        Teleporter m = mm.getTeleporterAt(-1);
        System.out.println("Expected= null");
        System.out.println("Actual= " + m);
    }

    public static void testGetTeleporterAt_InvalidIndex_High (){
        System.out.println("\n-->testGetTeleporterAt_InvalidIndex_High");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        Martian m5 = new GreenMartian(5, 3);
        Martian m6 = new GreenMartian(6, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        mm.addMartian(m5);
        mm.addMartian(m6);
        Teleporter m = mm.getTeleporterAt(4);
        System.out.println("Expected= null");
        System.out.println("Actual= " + m);
    }

    public static void testGetMartianWithId_Success (){
        System.out.println("\n-->testGetMartianWithId_Success");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.getMartianWithId(2);
        System.out.println("Expected= Red Martian - id=2, vol=3, ten=4");
        System.out.println("Actual= " + m);
    }

    public static void testGetMartianWithId_Failure (){
        System.out.println("\n-->testGetMartianWithId_Failure");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.getMartianWithId(5);
        System.out.println("Expected= null");
        System.out.println("Actual= " + m);
    }

    public static void testContains_Success (){
        System.out.println("\n-->testContains_Success");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        boolean b = mm.contains(3);
        System.out.println("Expected= true");
        System.out.println("Actual= " + b);
    }

    public static void testContains_Failure (){
        System.out.println("\n-->testContains_Success");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        boolean b = mm.contains(5);
        System.out.println("Expected= false");
        System.out.println("Actual= " + b);
    }

    public static void testGroupSpeak (){
        System.out.println("\n-->testGroupSpeak");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        String s = mm.groupSpeak();
        System.out.println("Expected=\n" +
                "id=1, Rubldy Rock\n" +
                "id=2, Rubldy Rock\n" +
                "id=3, Grobldy Grock");
        System.out.println("Actual=\n" + s);
    }

    public static void testGroupTeleport (){
        System.out.println("\n-->testGroupTeleport");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        Martian m5 = new GreenMartian(5, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        mm.addMartian(m5);
        String s = mm.groupTeleport("China");
        System.out.println("Expected=\n" +
                "id=3 teleporting to China\n" +
                "id=4 teleporting to China\n" +
                "id=5 teleporting to China");
        System.out.println("Actual=\n" + s);
    }

    public static void testRemoveMartianAt_Success_Red (){
        System.out.println("\n-->testRemoveMartianAt_Success_Red");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.removeMartianAt(1);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Red Martian - id=2, vol=3, ten=4, " +
                "martian amount=3, teleporters=2");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d", m, mAmount, tAmount));
    }

    public static void testRemoveMartianAt_Success_Green (){
        System.out.println("\n-->testRemoveMartianAt_Success_Green");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.removeMartianAt(2);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Green Martian - id=3, vol=3, " +
                "martian amount=3, teleporters=1");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d",
                m, mAmount, tAmount));
    }

    public static void testRemoveMartianAt_Failure (){
        System.out.println("\n-->testRemoveMartianAt_Failure");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.removeMartianAt(4);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= null, " +
                "martian amount=4, teleporters=2");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d",
                m, mAmount, tAmount));
    }

    public static void testRemoveMartianWithId_Success_Red (){
        System.out.println("\n-->testRemoveMartianWithId_Success_Red");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.removeMartianWithId(1);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Red Martian - id=1, vol=3, ten=4, " +
                "martian amount=3, teleporters=2");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d",
                m, mAmount, tAmount));
    }

    public static void testRemoveMartianWithId_Success_Green (){
        System.out.println("\n-->testRemoveMartianWithId_Success_Green");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.removeMartianWithId(3);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Green Martian - id=3, vol=3 " +
                "martian amount=3, teleporters=1");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d",
                m, mAmount, tAmount));
    }

    public static void testRemoveMartianWithId_Failure (){
        System.out.println("\n-->testRemoveMartianWithId_Failure");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new GreenMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.removeMartianWithId(5);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= null, " +
                "martian amount=4, teleporters=2");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d",
                m, mAmount, tAmount));
    }

    public static void testGetMartianClosestTo_Index_LowerMatch1 (){
        System.out.println("\n-->testGetMartianClosestTo_Index_LowerMatch1");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(3, 3, 4);
        Martian m3 = new GreenMartian(8, 3);
        Martian m4 = new GreenMartian(13, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.getMartianClosetTo(4);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Red Martian - id=3, vol=3, ten=4, " +
                "martian amount=4, teleporters=2");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d",
                m, mAmount, tAmount));
    }

    public static void testGetMartianClosestTo_Index_LowerMatch2 (){
        System.out.println("\n-->testGetMartianClosestTo_Index_LowerMatch2");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(3, 3, 4);
        Martian m3 = new GreenMartian(8, 3);
        Martian m4 = new GreenMartian(13, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.getMartianClosetTo(6);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Green Martian - id=8, vol=3, " +
                "martian amount=4, teleporters=2");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d",
                m, mAmount, tAmount));
    }

    public static void testGetMartianClosestTo_Martian_LowerMatch (){
        System.out.println("\n-->testGetMartianClosestTo_Martian_LowerMatch");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(3, 3, 4);
        Martian m3 = new GreenMartian(8, 3);
        Martian m4 = new GreenMartian(13, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        Martian m = mm.getMartianClosetTo(new GreenMartian(6, 2));
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Green Martian - id=8, vol=3, " +
                "martian amount=4, teleporters=2");
        System.out.println(String.format("Actual= %s, martian amount=%d, teleporters=%d",
                m, mAmount, tAmount));
    }

    public static void testGetSortedMartians(){
        System.out.println("\n-->testGetMartianClosestTo_Martian_LowerMatch");

        Martian m1 = new RedMartian(4, 3, 4);
        Martian m2 = new RedMartian(8, 3, 4);
        Martian m3 = new GreenMartian(1, 3);
        Martian m4 = new GreenMartian(2, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        ArrayList<Martian> list = mm.getSortedMartians();
        System.out.println("Expected=\n" +
                "Green Martian - id=1, vol=3\n" +
                "Green Martian - id=2, vol=3\n" +
                "Red Martian - id=4, vol=3, ten=4\n" +
                "Red Martian - id=8, vol=3, ten=4");
        System.out.println("Actual= ");
        for(Martian m : list){
            System.out.println(m);
        }
    }

    public static void testAbsorbColony(){
        System.out.println("\n-->testAbsorbColony");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(3, 3, 4);
        Martian m3 = new GreenMartian(8, 3);
        Martian m4 = new GreenMartian(13, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        ArrayList<Martian> list = new ArrayList<>();
        list.add(new GreenMartian(2,3));
        list.add(new GreenMartian(4,3));
        mm.absorbColony(list);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Martians amount=6, teleporter=4");
        System.out.println(String.format("Actual= Martians amount=%d, teleporter=%d",
                mAmount, tAmount));
    }

    public static void testObliterateTeleporters_One (){
        System.out.println("\n-->testObliterateTeleporters_One");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(3, 3, 4);
        Martian m3 = new GreenMartian(8, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.obliterateTeleporters();
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Martians amount=2, teleporter=0");
        System.out.println(String.format("Actual= Martians amount=%d, teleporter=%d",
                mAmount, tAmount));
    }

    public static void testObliterateTeleporters_Many (){
        System.out.println("\n-->testObliterateTeleporters_Many");

        Martian m1 = new RedMartian(1, 3, 4);
        Martian m2 = new RedMartian(2, 3, 4);
        Martian m3 = new RedMartian(3, 3);
        Martian m4 = new GreenMartian(4, 3);
        Martian m5 = new GreenMartian(5, 3);
        Martian m6 = new GreenMartian(6, 3);
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        mm.addMartian(m5);
        mm.addMartian(m6);
        mm.obliterateTeleporters();
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Martians amount=3, teleporter=0");
        System.out.println(String.format("Actual= Martians amount=%d, teleporter=%d",
                mAmount, tAmount));
    }

    public static void testBattle_One_on_One_One_Kill (){
        System.out.println("\n-->testBattle_One_on_One_One_Kill");

        RedMartian m1 = new RedMartian(1,1,1); // power=3
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        ArrayList<Martian> mKills = mm.battle(new ArrayList<>
                (List.of(new GreenMartian(2, 3)))); //9
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Martians amount=0, teleporter=0, Killed id=1");
        System.out.println(String.format("Actual= Martians amount=%d, teleporter=%d, Killed id=%d",
                mAmount, tAmount, mKills.getFirst().getId()));
    }

    public static void testBattle_One_on_One_No_Kill (){
        System.out.println("\n-->testBattle_One_on_One_No_Kill");

        RedMartian m1 = new RedMartian(1,3,1); // power=7
        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        ArrayList<Martian> mKills = mm.battle(new ArrayList<>
                (List.of(new GreenMartian(2, 1)))); //2
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        String s = "Not Empty";
        if (mKills.isEmpty()) {
            s = null;
        }
        System.out.println("Expected= Martians amount=1, teleporter=0, Killed id=null");
        System.out.println(String.format("Actual= Martians amount=%d, teleporter=%d, Killed id=%d",
                mAmount, tAmount, s));
    }

    public static void testBattle_Four_on_Two_One_Kill (){
        System.out.println("\n-->testBattle_Four_on_Two_One_Kill");

        RedMartian m1 = new RedMartian(1,4,1); // power=9
        RedMartian m2 = new RedMartian(2,4,1); // power=9
        GreenMartian m3 = new GreenMartian(3,4); // power=12
        GreenMartian m4 = new GreenMartian(4,2); // power=6

        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        ArrayList<Martian> mKills = mm.battle(new ArrayList<>
                (List.of(new GreenMartian(2, 1), new RedMartian(1,3,1)))); //3, 10
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Martians amount=3, teleporter=1, Killed id=4");
        System.out.println(String.format("Actual= Martians amount=%d, teleporter=%d, Killed id=%d",
                mAmount, tAmount, mKills.getFirst().getId()));
    }

    public static void testBattle_Five_on_Three_Two_Kills (){
        System.out.println("\n-->testBattle_Five_on_Three_Two_Kills");

        RedMartian m1 = new RedMartian(1,4,1); // power=9
        RedMartian m2 = new RedMartian(2,4,1); // power=9
        GreenMartian m3 = new GreenMartian(3,4); // power=12
        GreenMartian m4 = new GreenMartian(4,2); // power=6
        GreenMartian m5 = new GreenMartian(5,5); // power=15


        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        mm.addMartian(m5);

        ArrayList<Martian> mKills = mm.battle(new ArrayList<>
                (List.of(new GreenMartian(2, 1),
                        new RedMartian(1,3,1),
                        new GreenMartian(3, 4)))); //3, 7, 12
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Martians amount=3, teleporter=2, Killed id=4 1");
        System.out.print(String.format("Actual= Martians amount=%d, teleporter=%d, Killed id=",
                mAmount, tAmount));
        for(Martian m : mKills){
            System.out.print(m.getId() + " ");
        }
        System.out.println();
    }

    public static void testCaptureInvaders_Five_on_Three_Two_Captures (){
        System.out.println("\n-->testCaptureInvaders_Five_on_Three_Two_Captures");

        RedMartian m1 = new RedMartian(1,4,1); // power=9
        RedMartian m2 = new RedMartian(2,4,1); // power=9
        GreenMartian m3 = new GreenMartian(3,4); // power=12
        GreenMartian m4 = new GreenMartian(4,2); // power=6
        GreenMartian m5 = new GreenMartian(5,5); // power=15


        MartianManager mm = new MartianManager();
        mm.addMartian(m1);
        mm.addMartian(m2);
        mm.addMartian(m3);
        mm.addMartian(m4);
        mm.addMartian(m5);
        ArrayList<Martian> invaders = new ArrayList<>();
        Martian i1 = new GreenMartian(2, 1);
        Martian i2 = new RedMartian(1,3,10);
        Martian i3 = new GreenMartian(3, 1); //3, 16, 3
        invaders.add(i1);
        invaders.add(i2);
        invaders.add(i3);
        invaders = mm.captureInvaders(invaders);
        int mAmount = mm.getNumMartians();
        int tAmount = mm.getNumTeleporters();
        System.out.println("Expected= Martians amount=7, teleporter=5, Captured id=2 3");
        System.out.print(String.format("Actual= Martians amount=%d, teleporter=%d, Killed id=",
                mAmount, tAmount));
        for(Martian m : invaders){
            System.out.print(m.getId() + " ");
        }
        System.out.println();
    }
}
