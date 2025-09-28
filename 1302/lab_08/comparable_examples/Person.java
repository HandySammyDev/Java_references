package comparable_examples;

import java.util.Objects;

public class Person implements Comparable<Person>{
    String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o){
        return this.name.equals(((Person)o).name);
    }

    @Override
    public String toString(){
        return "Person: name=" + name;
    }
}
