package hw_06.ver2;

public class WolfDogTest {

    public static void main(String[] args) {
        testDogAndWolfDog();
    }

    public static void testDogAndWolfDog() {
        WolfDog wd = new WolfDog("Juan");
        // Calling inherited method
        // wd.setName("Juno");
        // Calling inherited method
        String name = wd.getName();
        System.out.println("WolfDog's name is: " + name);

        // Calling overridden method
        String msg = wd.bark();
        System.out.println(msg);

        System.out.println(wd);
    }
}