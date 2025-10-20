package exception_examples1;

public class Account {

    double balance;

    public Account(double balance){
        if(balance>0){
            this.balance = balance;
        }
        else{
            throw new IllegalArgumentException("Balance is less than 1");
        }
    }

    @Override
    public String toString(){
        return String.format("balance=$%.2f", balance);
    }

    public static void main(String[] args){
//        Account a1 = new Account(0);
//        System.out.println(a1);
        Account a2 = new Account(2);
        System.out.println(a2);
    }
}
