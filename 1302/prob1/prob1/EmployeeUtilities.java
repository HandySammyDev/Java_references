package prob1;

public class EmployeeUtilities {

    public EmployeeUtilities(){}

    public Employee getEmployeeWithMostHours(Employee[] emps){

        Employee highestEmployeeHours = emps[0];

        for(int i=0; i<emps.length-1; i++){

            if(emps[i].getTotalHours() > emps[i+1].getTotalHours()){
                highestEmployeeHours = emps[i];
            }
            else{
                highestEmployeeHours = emps[i+1];
            }
        }

        return highestEmployeeHours;
    }

    public double[] getHoursArray(Employee[] emps){

        double[] employeesHours = new double[emps.length];

        for(int i=0; i<emps.length; i++){

            employeesHours[i] = emps[i].getTotalHours();
        }

        return employeesHours;
    }

    public double getTotalPay(Employee[] emps){

        double totalPay = 0;

        for(int i=0; i<emps.length; i++){

            totalPay += emps[i].getPay();
        }

        return totalPay;
    }
 }
