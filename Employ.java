
import java.util.ArrayList;

interface Bonus{
    void bonus(ArrayList<Employee> EmployList);
}
// Abstract class Employee 
abstract  class Employee{
    protected String employName;
    protected   String id;
    protected double salary;
    public Employee(String employName,String id,double salary){
        this.employName = employName;
        this.id = id;
        this.salary = salary;
    }
    public abstract double CalculateSalary();
}
// Class DEV ( Calculate salary by the OT: Salary = Hard Salary + (OTx200$) => 1hOT = 200$ )
class DEV extends Employee {
     private  int otHours;
    public DEV(String employName,String id,double salary,int otHours){
        super(employName, id, salary);
        this.otHours = otHours;
    }
    @Override
    public double CalculateSalary(){
        return salary + (otHours*200);
    }
}
// Class Sale ( Calculate salary by the KPI in that month: Salary = Comission + Hard Salary)
class SALE extends Employee{
    private int commission;
    public SALE (String employName,String id,double salary,int commission){
        super(employName,id,salary);
        this.commission = commission;
    }
    @Override
    public double CalculateSalary(){
        return salary + (commission*0.05);
    }
}
// Class Manager has a Bonus skill that can bonus salary for the employee
class Manager extends  Employee implements Bonus{
    public Manager(String employName,String id,double salary){
        super(employName, id, salary);
    }
    @Override
    public double CalculateSalary(){
        return salary;
    }
    @Override 
    public void bonus(ArrayList<Employee> EmployList){
        Employee lowestSalary = EmployList.get(0);
        for(int i = 1;i<EmployList.size();i++){
            if(EmployList.get(i).CalculateSalary() < lowestSalary.CalculateSalary() ){ // Compare to find the employee has the lowest salary
                lowestSalary = EmployList.get(i);
            }
        }
        System.out.println("Manager will bonus salary for: " + lowestSalary.employName);
        lowestSalary.salary += 5000000;
    }
}



public class Employ { 
    public static void main(String[] args) {
        ArrayList<Employee> company = new ArrayList<>();
        company.add(new DEV("Le Minh Hoang", "NV00c1", 15000000, 24));
        company.add(new SALE("Le Minh Tam", "NV00c2", 20000000, 150000000));
        Manager mn = new Manager("Jack Ma", "MN00c3", 45000000);
        company.add(mn);
        System.out.println("========= SALARY LIST =========");
        for(int i = 0; i<company.size();i++){
            System.out.println("Name: " + company.get(i).employName + "--- ID: " + company.get(i).id+"--- Salary: " + company.get(i).CalculateSalary());
        }
        mn.bonus(company);
         System.out.println("========= SALARY LIST =========");
        for(int i = 0; i<company.size();i++){
            System.out.println("Name: " + company.get(i).employName + "--- ID: " + company.get(i).id+"--- Salary: " + company.get(i).CalculateSalary());
        }
    }
}
