package association1;

public class PersonTest {

    public static void main(String[] args) {
        testPersonCreation();
        testWalkDog();
        testGetDog();
    }

    public static void testPersonCreation() {
        System.out.println("-->testPersonCreation");
        Dog d = new Dog("Juno");
        Person p = new Person("Xavier", d);
        System.out.println(p);

    }

    public static void testWalkDog() {
        System.out.println("\n-->testWalkDog");
        Dog d = new Dog("Juno");
        Person p = new Person("Xavier", d);
        String msg = p.walkDog();
        System.out.println(msg);
    }

    public static void testGetDog() {
        System.out.println("\n-->testGetDog");
        Dog d = new Dog("Juno");
        Person p = new Person("Xavier", d);
        Dog d2 = p.getDog();
        String msg = d2.walk();
        System.out.println(msg);
    }
}