package prob1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1.  This class should compile before turning in your assignment. 
 * 
 * 2.  Any compile error in this code means that the signature (spelling of method, return type, parameters) 
 *     of the method YOU wrote is incorrect. Fix your code.
 *      
 * 3.  If you didn't implement a method, then add a "stub" so that this class compiles and to make the grading
 *     process go more smoothly on my end. Some example stubs for various methods:
 * 
 *       public void mergeEmployee(Employee e){
 *       }
 *
 *	     public Employee getEmployeeWithMostHours (Employee[] emps) {
 *		     return null;	
 *	     }
 *
 *       public double getPay() {
 *		     return Double.MIN_VALUE;
 *	     }
 *
 * 4.  If you need to correct the spelling of a method, be sure and use: Refactor/Rename, which changes all
 *     occurrences in all files. See Lab 2 if needed. 
 */ 
public class HW05CompileTest {
	public static void main(String[] args) {
		testCompileRedMartian();
		testCompileGreenMartian();
		testCompileMartianManager();
		System.out.println("All methods have correct signature");
	}
	
	private static void testCompileRedMartian() {
		prob1.RedMartian r1 = new prob1.RedMartian(1,1,1);
		prob1.RedMartian r2 = new prob1.RedMartian(2,2);
		prob1.Martian m = new prob1.RedMartian(1,1,1);
		int id = r1.getId();
		int ten = r1.getTenacity();
		int vol = r1.getVolume();
		int comp = r1.compareTo(r2);
		r1.setVolume(33);
		int pwr = r1.power();
		String spk = r1.speak();
		boolean isSame = r1.equals(r2);
		String msg = r1.toString();
	}

	public static void testCompileGreenMartian() {
		prob1.GreenMartian g1 = new prob1.GreenMartian(1,1);
		prob1.GreenMartian g2 = new prob1.GreenMartian(2);
		prob1.Teleporter t = new prob1.GreenMartian(1,1);
		prob1.Martian m = new prob1.GreenMartian(1,1);
		int id = g1.getId();
		int vol = g1.getVolume();
		g1.setVolume(33);
		int pwr = g1.power();
		String spk = g1.speak();
		int comp = g1.compareTo(g2);
		boolean isSame = g1.equals(g2);
		String tele = g1.teleport("Orck");
		String msg = g1.toString();
	}

	public static void testCompileMartianManager() {
		prob1.GreenMartian g2 = new prob1.GreenMartian(4,5);
		prob1.MartianManager mm = new prob1.MartianManager();
		mm.addMartian(g2);
		prob1.RedMartian r1 = new prob1.RedMartian(1,1,1); // power=2
		prob1.RedMartian r2 = new prob1.RedMartian(2,2,2); // power=4
		prob1.GreenMartian g1 = new prob1.GreenMartian(3); // power=1
		ArrayList<Martian> invaders = new ArrayList<>(Arrays.asList(r1,r2,g1));
		mm.absorbColony(invaders);
		ArrayList<prob1.Martian> killed = mm.battle(invaders);
		ArrayList<prob1.Martian> captured = mm.captureInvaders(invaders);
		boolean isThere = mm.contains(3);
		prob1.Martian m = mm.getMartianAt(0);
		prob1.Martian m2 = mm.getMartianClosetTo(0);
		prob1.Martian m3 = mm.getMartianClosetTo(g1);
		prob1.Martian m4 = mm.getMartianWithId(33);
		int num = mm.getNumMartians();
		int num2 = mm.getNumTeleporters();
		ArrayList<prob1.Martian> sorted = mm.getSortedMartians();
		prob1.Teleporter t = mm.getTeleporterAt(0);
		String grp = mm.groupSpeak();
		String telep = mm.groupTeleport("lerb");
		mm.obliterateTeleporters();
		prob1.Martian m5 = mm.removeMartianAt(2);
		prob1.Martian m6 = mm.removeMartianWithId(33);
		String msg = mm.toString();
	}
}
