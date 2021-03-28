//Base class for all products the store will sell
public class Product{
 private double price;
 private int stockQuantity;
 private int soldQuantity;
 private int soldQuantity2;
 
 public Product(double initPrice, int initQuantity){
   price = initPrice;
   stockQuantity = initQuantity;
   soldQuantity2 = 0;
 }
 
 public int getStockQuantity(){
   return stockQuantity;
 }
 
 public int getSoldQuantity(){
   return soldQuantity;
 }
 
 public double getPrice(){
   return price;
 }

 public void setStockQuantity(int amt) { stockQuantity = amt; }

 public void setSoldQuantity(int amt) { soldQuantity = amt; }

 // This has just been added so I can use it for checking popularity for the mostPopularList.
 public void setOtherSoldQuantity(int amt) { soldQuantity2 = amt; }
 public int getOtherSoldQuantity() { return soldQuantity2; }
 
 //Returns the total revenue (price * amount) if there are at least amount items in stock
 //Return 0 otherwise (i.e., there is no sale completed)
 public double sellUnits(int amount){
   if(amount > 0 && stockQuantity >= amount){
     stockQuantity -= amount;
     soldQuantity += amount;
     return price * amount;
   }
   return 0.0;
 }
}