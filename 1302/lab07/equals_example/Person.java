package lab07.equals_example;

public class Person {

    private int ssn;
    private String name;

    public Person(String name, int ssn){
        this.ssn = ssn;
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Person){
            Person p = (Person) o;
            return this.ssn == p.ssn;
        }
        return false;
    }

    @Override
    public String toString(){
        return "(" + name + ", " + ssn + ")";
    }
}
