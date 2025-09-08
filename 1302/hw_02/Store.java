package prob1;
import emp.Employee;

//“This homework represents my own work.
// I understand that I may receive help, but I did not copy any portion of this assignment from anywhere.
// I understand that a violation of this will result in a Report of Academic Dishonesty.— Samuel Perez-Hernandez”

public class Store {

    // Add the three instance variables to the Store class.
    // MAKE THE hours INSTANCE VARIABLE PROTECTED, NOT PRIVATE.
    // protected Employee emps[] = new Employee[20];

    private Employee[] emps = new Employee[20];
    private int numEmps;

    Store(){
        numEmps = 0;
    }

    public void addEmployee(Employee e){
        if(numEmps == emps.length){
            return;
        }
        emps[numEmps] = e;
        numEmps++;
    }
    public Employee getEmployee(int i){
        if(i<0 || i>numEmps){
            return null;
        }
        return emps[i];
    }
    public Employee getEmployeeWithName(String findName){
        for(int i=0; i<numEmps; i++){
            if(emps[i].getName().equals(findName)){
                return emps[i];
            }
        }
        return null;
    }
    public int getNumEmployees(){
        return numEmps;
    }
    public double getTotalHours(){

        double totalHours = 0;

        for(int i=0; i<numEmps; i++){
            totalHours += emps[i].getTotalHours();
        }

        return totalHours;
    }
    public double getTotalPay(){

        double totalPay = 0;

        for(int i=0; i<numEmps; i++){
            totalPay += emps[i].getPay();
        }

        return totalPay;
    }
    public Employee removeEmployee(int i){
        Employee e;

        if(i < 0 || emps[i] == null){
            return null;
        }
        else{
            e = emps[i];
            emps[i] = null;
        }

        for(int j=i; j<numEmps-1; j++){
            emps[j] = emps[j+1];
        }

        numEmps--;
        return e;
    }

    @Override
    public String toString(){

        StringBuilder allEmployeeToStrings = new StringBuilder();

        for(int i=0; i<numEmps; i++){
            allEmployeeToStrings.append(emps[i]);
        }

        return String.format(
                "Payroll Report\n\n" +
                "Num Employees:%d, total hrs:%.2f, total pay=$%.2f\n\n" +
                allEmployeeToStrings,
                getNumEmployees(), getTotalHours(), getTotalPay());
    }
}
