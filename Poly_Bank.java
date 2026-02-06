// Class Bank Account Include: balance,id,name
abstract class BankAccount{
   protected  double balance = 0;
    protected String id; // Use protected for children class
    protected String name; 
    public BankAccount(String name,String id){
        this.name = name;
        this.id = id;
        
    }
    public double get_Balance(){
        return balance;
    }
    public void deposit(double amount){ // Need to use another var!
        if(amount > 0){
            this.balance += amount;
            System.out.println("Deposit successful!:"+get_Balance());
        }
        else{
            System.out.println("Deposit fail!");
        }
    }
    public abstract void withdraw(double amount);// Using abtract to let the children class choose their way to do it.
}
class SavingAccount extends BankAccount{
    public SavingAccount(String name,String id){
        super(name, id);
    }
    @Override
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){ 
           balance -= amount;
           System.out.println("WithDraw succesful!:"+amount);
        }
        else{
            System.out.println("WithDraw fail!:");
        }
    }
}
class CreditAccount extends BankAccount{
    private double creditLimit;
    public  CreditAccount(String name,String id,double creditLimit){
        super(name,id);
        this.creditLimit = creditLimit;
    }
    @Override
    public void withdraw(double amount){
        if((balance - amount) >= -creditLimit){
            balance -= amount;
           System.out.println("WithDraw succesful!:"+amount);
        }
        else{
             System.out.println("WithDraw fail!:");
        }
    }
}


public class Poly_Bank{
    public static void main (String[] args){

    }
}