import java.io.*;

public class Customer implements Serializable {
    private String name;
    private int age;
    private float money;
    private int id;

    public Customer(String n, int a, float m) {
        name = n;
        age = a;
        money = m;
        id = -1;
    }

    public void setID(int newID) {
        id = newID;
    }

    public String toString() {
        return "Customer " + name + ": a " + age + " year old with $" + money;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasMoreMoneyThan(Customer c) {
        return money > c.money;
    }

    public void saveTo(PrintWriter aFile) throws IOException {
        aFile.println(id + "," + name + "," + age + "," + money);
    }

    public static Customer readFrom(BufferedReader aFile) throws IOException {
        String[] info = aFile.readLine().split(",");
        return new Customer(info[1], Integer.parseInt(info[2]), Float.parseFloat(info[3]));
    }
}
