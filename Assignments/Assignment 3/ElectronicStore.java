//Class representing an electronic store
//Has an array of products that represent the items the store can sell
import java.util.*;

public class ElectronicStore {
  public final int MAX_PRODUCTS = 10; //Maximum number of products the store can have
  private int curProducts;
  private String name;
  private Product[] stock; //Array to hold all products
  private double revenue;
  private int sales;
  private ElectronicStoreView view;
  private float currentCartMoney;
  private Dictionary stockNums;

  public ElectronicStore(String initName) {
    revenue = 0.0;
    name = initName;
    stock = new Product[MAX_PRODUCTS];
    curProducts = 0;
    view = new ElectronicStoreView(this);
    sales = 0;
  }

  public static ElectronicStore createStore() {
    ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
    Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
    Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
    Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
    Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
    Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
    Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
    ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
    store1.addProduct(d1);
    store1.addProduct(d2);
    store1.addProduct(l1);
    store1.addProduct(l2);
    store1.addProduct(f1);
    store1.addProduct(f2);
    store1.addProduct(t1);
    store1.addProduct(t2);
    return store1;
  }
  public void sellProducts() {
    ArrayList<String> sellingItems = getCurCart();
    for (int i = 0; i < sellingItems.size(); i++) {
      String[] textuals = sellingItems.get(i).split("x ");
      int amt = Integer.parseInt(textuals[0]);
      for (int s = 0; s < curProducts; s++) {
        if (stock[s].toString().equals(textuals[1])) {
          revenue += stock[s].getPrice() * amt;
          // Using otherSoldQuantity for popular products case
          stock[s].setOtherSoldQuantity(stock[s].getOtherSoldQuantity() + amt);
          stock[s].setSoldQuantity(0);
        }
      }
    }
  }

  public String getName() {
    return name;
  }

  public double getRevenue() {
    return revenue;
  }

  public ArrayList<String> getCurCart() {
    ArrayList<String> curCart = new ArrayList<>();
    for(int i = 0; i < curProducts; i++) {
      if (stock[i].getSoldQuantity() > 0) {
        curCart.add(stock[i].getSoldQuantity() + "x " + stock[i].toString());
      }
    }
    return curCart;
  }
  public ArrayList<String> getStockString() {
    ArrayList<String> stocks = new ArrayList<>();
    stockNums = new Hashtable();
    int k = 0;
    for (int i = 0; i < curProducts; i++) {
      if (stock[i].getStockQuantity() > 0) {
        stocks.add(stock[i].toString());
        stockNums.put(k, stock[i].toString());
        k++;
      }
    }
    return stocks;
  }
  public ArrayList<String> getStartingPopular() {
    ArrayList<String> pops = new ArrayList<>();
    int k = 0;
    for (int i = 0; i < curProducts; i++) {
      if (k < 3) {
        pops.add(stock[i].toString());
        k++;
      }
    }
    return pops;
  }
  public String getCartMoney() {
    currentCartMoney = 0;
    for (int i = 0; i < curProducts; i++) {
      if (stock[i] != null) {
        if (stock[i].getSoldQuantity() > 0) {
          currentCartMoney += stock[i].getPrice() * stock[i].getSoldQuantity();
        }
      }
    }
    String formatted = String.format("$%.2f", currentCartMoney);
    return formatted;
  }
  public String[] getMostPopular() {
    String[] mostPopularProductsString = new String[3];
    ArrayList<Product> copyOfProducts = new ArrayList<>();
    Product[] mostPopularProducts = new Product[3];

    for (Product p: stock) {
      if (p != null) {
        copyOfProducts.add(p);
      }
    }
    copyOfProducts.sort(Comparator.comparing(Product::getOtherSoldQuantity).reversed());

    mostPopularProducts[0] = copyOfProducts.get(0);
    mostPopularProducts[1] = copyOfProducts.get(1);
    mostPopularProducts[2] = copyOfProducts.get(2);

    for (int i = 0; i < 3; i++) {
      mostPopularProductsString[i] = mostPopularProducts[i].toString();
    }
    return mostPopularProductsString;
  }

  public int getNumSales() {
    return sales;
  }

  public boolean addProduct(Product newProduct) {
    if (curProducts < MAX_PRODUCTS) {
      stock[curProducts] = newProduct;
      curProducts++;
      return true;
    }
    return false;
  }
  public void addProductToCart(int index) {
    for (int i = 0; i < curProducts; i++) {
      if (stock[i] != null) {
        if (stock[i].equals(stock[index])) {
          stock[i].setStockQuantity(stock[i].getStockQuantity() - 1);
          stock[i].setSoldQuantity(stock[i].getSoldQuantity() + 1);
          view.getCartList().getItems().add(stock[i].toString());
        }
      }
    }
  }
  public void removeProductCart(int index) {
    String item = view.getCartList().getItems().get(index);
    for (int i = 0; i < curProducts; i++) {
      if (stock[i] != null) {
        if (stock[i].toString().equals(item)) {
          stock[i].setStockQuantity(stock[i].getStockQuantity() + 1);
          stock[i].setSoldQuantity(stock[i].getSoldQuantity() - 1);
          view.getCartList().getItems().remove(stock[i].toString());
        }
      }
    }
  }

  public void incrementNumSales() {
    sales += 1;
  }

}