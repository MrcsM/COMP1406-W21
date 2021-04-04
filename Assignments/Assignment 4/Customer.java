import java.util.HashMap;
import java.util.Map;

public class Customer {

    private String name;
    private double amountSpent;
    private HashMap<Product, Integer> productsPurchased;

    public Customer(String name) {
        this.name = name;
        this.amountSpent = 0.0;
        this.productsPurchased = new HashMap<Product, Integer>();
    }

    public String toString() {
        return this.name + " who has spent $" + this.amountSpent;
    }

    public double getAmountSpent() {
        return this.amountSpent;
    }

    public void addPurchasedProduct(Product p, int amount) {
        amountSpent += p.getPrice() * amount;
        boolean found = false;
        for (Product key : productsPurchased.keySet()) {
            if (key == p) {
                found = true;
            } else {
                found = false;
            }
        }
        if (!found) {
            productsPurchased.put(p, amount);
        } else {
            int curAmount = productsPurchased.get(p);
            productsPurchased.put(p, curAmount + amount);
        }
    } // Works as of 03/04/21

    public void printPurchaseHistory() {
        for (Map.Entry me : productsPurchased.entrySet()) {
            System.out.println(me.getValue() + "x " + me.getKey());
        }
     } // Works as of 03/04/21

    public String getName() {
        return this.name;
    }
}
