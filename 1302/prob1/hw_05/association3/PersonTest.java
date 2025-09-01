package association3;

public class PersonTest {

    public static void main(String[] args) {
        testAddDog();
        testGetDog();
        testToString();
        testWalkDogs();
        testRemoveLastDog_3_Dogs();
        testRemoveLastDog_0_Dogs();
        testRemoveFirstDog_3_Dogs();
        testRemoveFirstDog_0_Dogs();
        testRemoveDog_From_Middle_4_Dogs();
        testRemoveDog_From_End_4_Dogs();
        testRemoveDog_From_Beginning_4_Dogs();
    }

    public static void testAddDog() {
        System.out.println("-->testAddDog");
        Person p = new Person("Wilma");
        System.out.println("Num dogs before addDog:" + p.getNumDogs());
        p.addDog(new Dog("Zoro"));
        System.out.println("Num dogs after addDog:" + p.getNumDogs());
        p.addDog(new Dog("Gigi"));
        System.out.println("Num dogs after addDog:" + p.getNumDogs());
    }

    public static void testGetDog() {
        System.out.println("\n-->testGetDog");
        Person p = new Person("Wilma");
        p.addDog(new Dog("Zoro"));
        p.addDog(new Dog("Gigi"));
        p.addDog(new Dog("Chaps"));

        for(int i=0; i<p.getNumDogs(); i++) {
            Dog d = p.getDog(i);
            System.out.println(d);
        }

        System.out.println();
    }

    public static void testToString() {
        System.out.println("-->testToString");
        Person p = new Person("Wilma");
        p.addDog(new Dog("Zoro"));
        p.addDog(new Dog("Gigi"));
        p.addDog(new Dog("Chaps"));
        System.out.println(p);
    }

    public static void testWalkDogs() {
        System.out.println("-->testWalkDogs");
        Person p = new Person("Sheena");
        p.addDog(new Dog("Ace"));
        p.addDog(new Dog("Leo"));
        p.addDog(new Dog("Fritzy"));
        String msg = p.walkDogs();
        System.out.println(msg);
    }

    public static void testRemoveLastDog_3_Dogs() {
        System.out.println("-->testRemoveLastDog_3_Dogs");
        Person p = new Person("Paul");
        p.addDog(new Dog("Ace"));
        p.addDog(new Dog("Leo"));
        p.addDog(new Dog("Fritzy"));

        System.out.println("Dogs before removeLastDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        Dog d = p.removeLastDog();

        System.out.println("Dogs after removeLastDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }
        System.out.println("Dog removed:" + d);
        System.out.println();
    }

    public static void testRemoveLastDog_0_Dogs() {
        System.out.println("-->testRemoveLastDog_0_Dogs");
        Person p = new Person("Paul");

        System.out.println("Dogs before removeLastDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        Dog d = p.removeLastDog();

        System.out.println("Dogs after removeLastDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }
        System.out.println("Dog removed:" + d);
        System.out.println();
    }

    public static void testRemoveFirstDog_3_Dogs() {
        System.out.println("-->testRemoveFirstDog_3_Dogs");
        Person p = new Person("Paul");
        p.addDog(new Dog("Ace"));
        p.addDog(new Dog("Leo"));
        p.addDog(new Dog("Fritzy"));

        System.out.println("Dogs before removeFirstDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        Dog d = p.removeFirstDog();

        System.out.println("Dogs after removeFirstDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }
        System.out.println("Dog removed:" + d);
        System.out.println();
    }

    public static void testRemoveFirstDog_0_Dogs() {
        System.out.println("-->testRemoveFirstDog_0_Dogs");
        Person p = new Person("Paul");

        System.out.println("Num dogs before removeFirstDog:" + p.getNumDogs());

        Dog d = p.removeFirstDog();

        System.out.println("Num dogs after removeFirstDog:" + p.getNumDogs());
        System.out.println("Dog removed:" + d);
        System.out.println();
    }

    // Add 4 dogs and then remove from index=1
    public static void testRemoveDog_From_Middle_4_Dogs() {
        System.out.println("-->testRemoveDog_From_Middle_4_Dogs");
        Person p = new Person("Paul");
        p.addDog(new Dog("Ace"));
        p.addDog(new Dog("Leo"));
        p.addDog(new Dog("Fritzy"));
        p.addDog(new Dog("Kane"));

        System.out.println("Dogs before removeMiddleDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        Dog d = p.removeDog(1);

        System.out.println("Dogs after removeMiddleDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        System.out.println("Dog removed:" + d);
        System.out.println();
    }

    // Add 4 dogs and then remove from index=3
    public static void testRemoveDog_From_End_4_Dogs() {
        System.out.println("-->testRemoveDog_From_End_4_Dogs");
        Person p = new Person("Paul");
        p.addDog(new Dog("Ace"));
        p.addDog(new Dog("Leo"));
        p.addDog(new Dog("Fritzy"));
        p.addDog(new Dog("Kane"));

        System.out.println("Dogs before removeEndDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        Dog d = p.removeDog(3);

        System.out.println("Dogs after removeEndDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        System.out.println("Dog removed:" + d);
        System.out.println();
    }

    // Add 4 dogs and then remove from index=0
    public static void testRemoveDog_From_Beginning_4_Dogs() {
        System.out.println("-->testRemoveDog_From_End_4_Dogs");
        Person p = new Person("Paul");
        p.addDog(new Dog("Ace"));
        p.addDog(new Dog("Leo"));
        p.addDog(new Dog("Fritzy"));
        p.addDog(new Dog("Kane"));

        System.out.println("Dogs before removeBeginningDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        Dog d = p.removeDog(0);

        System.out.println("Dogs after removeBeginningDog:");
        for(int i=0; i<p.getNumDogs(); i++) {
            System.out.println((i+1) + ". " + p.getDog(i));
        }

        System.out.println("Dog removed:" + d);
    }
}