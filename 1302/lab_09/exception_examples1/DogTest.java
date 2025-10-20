package exception_examples1;

public class DogTest {
    public static void main(String[] args) {
        testDog_NoTryCatch();
        testDog_ValidName();
        testDog_InvalidName();
    }

    private static void testDog_NoTryCatch() {
        System.out.println("testDog_NoTryCatch()");
        String name = "Zorro";
        Dog d = new Dog(name);
        System.out.println("Dog created");
        System.out.println(d);
        System.out.println("Program over!");
    }
    private static void testDog_ValidName() {
        System.out.println("\ntestDog_ValidName()");
        String name = "Zorro";
        Dog d;
        try{
            System.out.println("trying: new Dog(\"Zorro\")");
            d = new Dog(name);
            System.out.println("Dog created");
            System.out.println(d);
        }
        catch(RuntimeException e){
            System.out.println("Dog not created, invalid name");
        }
        System.out.println("Program over!");
    }

    private static void testDog_InvalidName() {
        System.out.println("\ntestDog_InvalidName()");
        String name = "A";
        Dog d;
        try{
            System.out.println("trying: new Dog(\"A\")");
            d = new Dog(name);
            System.out.println("Dog created");
            System.out.println(d);
        }
        catch(RuntimeException e){
            System.out.println("Dog not created, invalid name");
        }
        System.out.println("Program over!");
    }

}
