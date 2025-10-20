package read_examples3;

import java.util.ArrayList;

public class Person {
    ArrayList<Dog> dogs = new ArrayList<>();
    private String name;

    public Person(String name){
        this.name = name;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    @Override
    public String toString(){
        StringBuilder msg = new StringBuilder();
        msg.append("Person: " + name + " - Dogs: ");
        for(Dog dog : dogs)
            msg.append(dog.getName() + ", ");
        msg.delete(msg.length()-2,msg.length());
        return msg.toString();
    }
}