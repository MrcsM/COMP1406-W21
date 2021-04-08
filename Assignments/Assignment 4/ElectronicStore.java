//Class representing an electronic store
//Has an array of products that represent the items the store can sell
import java.io.*;
import java.util.*;

public class ElectronicStore {
  private String name;
  private ArrayList<Product> stock;
  private ArrayList<Customer> customers;
  
  public ElectronicStore(String initName){
    name = initName;
    stock = new ArrayList<>();
    customers = new ArrayList<>();
  }

  public boolean addProduct(Product newProduct) {
    boolean found = false;
    for (Product product : stock) {
      if (product.toString().toLowerCase() == newProduct.toString().toLowerCase()) {
        found = true;
        break;
      } else {
        found = false;
      }
    }
    if (!found) {
      stock.add(newProduct);
      return true;
    } else {
      return false;
    }
  } // Works as of 03/04/21

  public boolean registerCustomer(Customer c) {
    boolean found = false;
    for (Customer customer : customers) {
      if (customer.getName() == c.getName()) {
        found = true;
        break;
      } else {
        found = false;
      }
    }
    if (!found) {
      customers.add(c);
      return true;
    } else {
      return false;
    }
  }  // Works as of 03/04/21

  public List<Customer> getCustomers() {
    return customers;
  } // Works as of 03/04/21

  public List<Product> searchProducts(String x) {
    List<Product> foundProducts = new ArrayList<>();
    for (Product product : stock) {
      if (product.toString().toLowerCase().contains(x.toLowerCase())) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  } // Works as of 03/04/21

  public List<Product> searchProducts(String x, double minPrice, double maxPrice) {
    List<Product> foundProducts = new ArrayList<>();
    if (minPrice == -1 && maxPrice == -1) {
      searchProducts(x);
    } else {
      for (Product product : stock) {
        if (product.toString().toLowerCase().contains(x.toLowerCase())) { // the product toString contains x
          if (minPrice > -1 && maxPrice > -1) { // both are greater than -1, so checking minPrice <= Product Price <= maxPrice
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
              foundProducts.add(product);
            }
          } else {
            if (minPrice == -1) { // checking if price is less than maxPrice
              if (product.getPrice() <= maxPrice) {
                foundProducts.add(product);
              }
            } else {
              if (maxPrice == -1) { // checking if price is greater than minPrice
                if (product.getPrice() >= minPrice) {
                  foundProducts.add(product);
                }
              }
            }
          }
        }
      }
    }
    return foundProducts;
  } // Works as of 03/04/21

  public boolean addStock(Product p, int amount) {
    if (stock.contains(p)) {
      p.setStockQuantity(p.getStockQuantity() + amount);
      return true;
    }
    return false;
  } // Works as of 03/04/21

  public boolean sellProduct(Product p, Customer c, int amount) {
    if (!(customers.contains(c))) { // customer is not registered in store
      return false;
    }
    if (!(stock.contains(p))) { // stock doesn't contain product
      return false;
    }
    if (p.getStockQuantity() < amount) { // not enough in stock to sell.
      return false;
    }
    p.setStockQuantity(p.getStockQuantity() - amount);
    c.addPurchasedProduct(p, amount);
    return true;
  } // Works as of 03/04/21

  public List<Customer> getTopXCustomers(int x) {
    List<Customer> topXCustomers = new ArrayList<>();
    List<Customer> customersCopy = new ArrayList<>();
    if (x <= 0) {
      return topXCustomers;
    } else {
      for (Customer c: customers) {
        customersCopy.add(c);
      }
      customersCopy.sort(Comparator.comparing(Customer::getAmountSpent).reversed());
      if (x > customers.size()) {
        return customersCopy;
      } else {
        for (int i = 0; i < x; i++) {
          topXCustomers.add(customersCopy.get(i));
        }
      }
    }
    return topXCustomers;
  } // Works as of 03/04/21

  public boolean saveToFile(String filename) {
    try {
      FileOutputStream fileOut = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(this.name);
      out.writeObject(this.stock);
      out.writeObject(this.customers);
      out.close();
      fileOut.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  } // Works as of 08/04/21

  public static ElectronicStore loadFromFile(String filename) {
    ElectronicStore store = new ElectronicStore("null");
    try {
      FileInputStream fileIn = new FileInputStream(filename);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      store.name = (String) in.readObject();
      store.stock = (ArrayList<Product>) in.readObject();
      store.customers = (ArrayList<Customer>) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException | ClassNotFoundException e) {
      return null;
    }
    return store;
  } // Works as of 08/04/21
} 