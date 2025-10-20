package exception_examples1;

public class DogTestBubbling {
    public static void main(String[] args) {
        try {
            testDog_InvalidName();
        }
        catch(RuntimeException e){
            System.out.println("Dog not created, invalid name");
        }
    }

    private static void testDog_InvalidName() {
        System.out.println("testDog_InvalidName()");
        String name = "A";
        System.out.println("trying: new Dog(\"A\")");
        Dog d = new Dog(name);
        System.out.println("Dog created");
        System.out.println(d);
    }

}
