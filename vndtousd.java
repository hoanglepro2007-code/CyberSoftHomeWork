
import java.util.Scanner;

class usdTovnd{
    double x;
    public usdTovnd(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter USD to converted! ");
        this.x = sc.nextDouble();
        sc.close();
    }
    public double  convertMoney(){
        if(x<0){
            System.out.println("Invalid money: ");
            return 0;
        }
        else{
            return x*23500;
        }
    }
    public void printMoney(){
        System.err.println( "Your VND after converted: " + convertMoney());
    }
}





public class vndtousd {
    public static void main(String[] args){
        usdTovnd s1 = new usdTovnd();
          Scanner sc = new Scanner(System.in);
          int x;
        do { 
            s1.printMoney();
            System.out.println("Process finished with exit code 0! ");
            x = sc.nextInt();
        } while (x!=0);
        sc.close();
        
    }
}
