package read_examples2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeReader {
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        File inFile = new File("src/read_examples2/employees3.txt");

        try{
            Scanner input = new Scanner(inFile);
            while(input.hasNext()){
                String name = input.next();
                double salary = input.nextDouble();
                int age = input.nextInt();
                Employee e = new Employee(name, salary, age);
                employees.add(e);
            }
            input.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
        for(Employee e : employees){
            System.out.println(e);
        }
    }
}
