public class Customer {
    private String name;
    private int age;
    private float money;
    private int rewardsID;

    public Customer(String n, int a, float m) {
        name = n;
        age = a;
        money = m;
        rewardsID = -1;
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

    public void setRewardsID(int id) {
        rewardsID = id;
    }

    public int getRewardsID() {
        return rewardsID;
    }

    public boolean hasMoreMoneyThan(Customer c) {
        if (money > c.money) {
            return true;
        } else {
            return false;
        }
    }
}
