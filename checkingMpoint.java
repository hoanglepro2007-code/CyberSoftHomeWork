
import java.util.Scanner;

class circle{
    double x,y;
   double R;
    public circle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter X:");
        this.x = sc.nextDouble();
        System.out.println("Enter Y:");
        this.y = sc.nextDouble();
        System.out.println("Enter R:");
        this.R = sc.nextDouble();
        
    }
}
class point{
    double x,y;
    public point(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter X:");
        this.x = sc.nextDouble();
        System.out.println("Enter Y:");
        this.y = sc.nextDouble();
        
    }
}

public class checkingMpoint {
    public static void main(String[] args) {
        circle C1 = new circle();
        point M = new point();
        double dx = M.x - C1.x;
        double dy = M.y - C1.y;
       double distance = Math.sqrt(dx*dx + dy *dy);
       Scanner sc = new Scanner(System.in);
          int exit;
        do { 
             if(distance < C1.R){
        System.out.println("M  is inside the Circle 1!");
       }
       else if (distance == C1.R){
        System.out.println("M is located on the Circle 1!");
       }
       else{
        System.out.println("M is outside the Circle 1!");
       }
            exit = sc.nextInt();
        } while (exit != 0);
        System.out.println("Process finished with exit code 0!");
       sc.close();
    }
}
