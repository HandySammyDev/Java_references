package association2;

public class PersonTest {

    public static void main(String[] args) {
        testPersonCreation();
    }

    public static void testPersonCreation() {
        System.out.println("-->testPersonCreation");
        Dog d = new Dog("Juno");
        Person p = new Person("Xavier", d);
        d.setOwner(p);
        System.out.println(p);
        System.out.println(d);
    }
}
