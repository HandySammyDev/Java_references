package prob1;

public class Employee {

    private double[] hours = {0,0,0,0,0,0,0};
    private String name;
    private double payRate;


    public Employee(String name, double payRate){
        this.name = name;
        this.payRate = payRate;
    }


    public double getHours(int day){
        return hours[day];
    }
    public String getName(){
        return name;
    }
    public int getNumDaysWorked(){
        int amountOfDaysWorked = 0;

        for(int i=0; i<hours.length; i++){
            if(hours[i] > 0){
                amountOfDaysWorked++;
            }
        }

        return amountOfDaysWorked;
    }
    public double getPay(){
        double totalPay = 0;
        double totalHours = 0;
        boolean workedOnWeekend = false;
        double bonus = 50;

        for(int i=0; i<hours.length; i++){
            if(i==5 || i==6){
                workedOnWeekend = true;
                break;
            }

            totalHours += hours[i];
        }

        if(totalHours <= 40){
            totalPay += totalHours * payRate;
        }
        else if(totalHours > 40){
            double overTime = totalHours - 40;
            totalPay += 40 * payRate;
            totalPay += overTime * (payRate*1.5);
        }

        if(workedOnWeekend){
            double weekendHours = hours[5] + hours[6];
            totalPay += weekendHours * (payRate*2);
        }

        if(getNumDaysWorked()==7){
            totalPay += bonus;
        }

        return totalPay;
    }

    public double getPayRate(){
        return payRate;
    }
    public double getTotalHours(){
        double totalHours = 0;

        for(int i=0; i<hours.length; i++){
            if(hours[i] > 0){
                totalHours += hours[i];
            }
        }

        return totalHours;
    }
    public double getWeekdayHours(){
        double weekdayHours = 0;
        int weekendDays = 2;

        for(int i=0; i<hours.length-weekendDays; i++){
            if(hours[i] > 0){
                weekdayHours += hours[i];
            }
        }

        return weekdayHours;
    }
    public double getWeekendHours(){
        return hours[5] + hours[6];
    }
    public void mergeEmployee(Employee e){
        for(int i=0; i<hours.length; i++){
            hours[i] = hours[i] + e.getHours(i);
        }
    }
    public void newWeek(){
        for(int i=0; i<hours.length; i++){
            hours[i] = 0;
        }
    }
    public void setHours(int day, double hours){
        if(day>=0 && day<=6){
            this.hours[day] = hours;
        }
    }

    @Override
    public String toString(){
        return String.format(
                "Pay Stub\n" +
                "--------\n" +
                "Name:%s, Pay Rate $%.2f\n" +
                "Hours:Mon:%.2f Tue:%.2f Wed:%.2f Thu:%.2f Fri:%.2f Sat:%.2f Sun:%.2f\n" +
                "Days worked:%d, Total Hours:%.2f\n" +
                "Weekdays hours:%.2f, Weekend hours: %.2f\n" +
                "Total pay: $%.2f\n",
                getName(), getPayRate(),
                getHours(0),getHours(1),getHours(2),getHours(3),getHours(4),getHours(5),getHours(6),
                getNumDaysWorked(), getTotalHours(),
                getWeekdayHours(), getWeekendHours(),
                getPay()
        );
    }

    public static void main(String[] args){

    }
}
