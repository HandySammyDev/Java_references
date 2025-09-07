package association3;

public class Person {
    private Dog[] dogs = new Dog[10];
    private int numDogs = 0;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public int getNumDogs() {
        return numDogs;
    }

    public void addDog(Dog d) {
        if(numDogs<10 ) {
            dogs[numDogs] = d;
            numDogs++;
        }
    }

    public Dog getDog(int i) {
        if(i>=0 && i<numDogs) {
            return dogs[i];
        }
        return null;
    }

    public String walkDogs() {
        String msg = "Dog's are walking...:\n";
        for(int i=0; i<numDogs; i++) {
            msg += "   " + dogs[i].walk() + "\n";
        }
        return msg;
    }

    public Dog removeLastDog() {
        if(numDogs>0) {
            numDogs--;
            return dogs[numDogs];
        }
        return null;
    }

    public Dog removeFirstDog() {
        if(numDogs>0) {
            Dog returnDog = dogs[0];
            for(int i=1; i<numDogs; i++) {
                dogs[i-1] = dogs[i];
            }
            numDogs--;
            return returnDog;
        }
        return null;
    }

    public Dog removeDog(int i) {
        if(i>=0 && i<numDogs) {
            Dog returnDog = dogs[i];
            for(int j=i+1; j<numDogs; j++) {
                dogs[j-1] = dogs[j];
            }
            numDogs--;
            return returnDog;
        }
        return null;
    }

    @Override
    public String toString() {
        String msg = "";
        msg = String.format("Person:%s, Dogs:\n", name);
        for(int i=0; i<numDogs; i++) {
            msg += String.format("  %s\n", dogs[i].getName());
        }
        return msg;
    }

}
