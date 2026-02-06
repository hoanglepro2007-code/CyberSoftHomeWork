
import java.util.ArrayList;
interface Invoice{
    void printInvoice();
}

abstract  class Product{
    protected  String ID;
    protected  String productName;
    protected  double listedPrice;
    public Product (String ID, String productName,double listedPrice){
        this.ID = ID;
        this.productName = productName;
        this.listedPrice = listedPrice;
    }
    public abstract double calcPrice();

}
class Electronics extends Product{
    double guaranteeFee;
    public Electronics(String ID,String productName,double listedPrice,double guaranteeFee){
        super(ID, productName, listedPrice);
        this.guaranteeFee = guaranteeFee;
    }
    @Override
    public double calcPrice(){
        return (listedPrice + guaranteeFee)*1.1;
    }
}
class Fashion extends Product{
    String size;
    int discountRate;
    public Fashion(String ID,String productName,double listedPrice,String size,int discountRate){
        super(ID, productName, listedPrice);
        this.size = size;
        this.discountRate = discountRate;
    }
    public double calcPrice(){
       double  discountMoney = listedPrice * discountRate  / 100;
       return listedPrice - discountMoney;
    }
}
class Cart  implements Invoice {
    ArrayList<Product> productList;
    public Cart(){
        this.productList = new ArrayList<>();
    }
    public void addProduct(Product p){
      productList.add(p);
    }
    public double calcTotal(){
        double total = 0;
        for(int i =0;i<productList.size();i++){
            double price = productList.get(i).calcPrice();
            total+=price;
        }
        return total;
    }
    @Override
    public void printInvoice(){
        System.out.println("----- INVOICE -----");
        // Normal FOR loop
        /*for(int i=0;i<productList.size();i++){
            
        }*/ 
       // Enhanced Loop:
       for(Product p : this.productList){
        System.out.println("Product name: "+p.productName+"------"+"ID: "+p.ID+"------"+"Price:"+p.calcPrice());
       }
       System.out.println("TOTAL MONEY: "+this.calcTotal());
    }
}




public class OnlineShop_Manager {
    public static void main(String[] args) {
        Cart myCart = new Cart();
        myCart.addProduct(new Electronics("TV001","Television",10_000_000,500_000));
        myCart.addProduct(new Fashion("TS001", "T-Shirt", 450_000, "4XL", 20));
        myCart.printInvoice();
    }
}
