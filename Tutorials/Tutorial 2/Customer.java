public class Customer {
    String name;
    int age;
    float money;
    boolean admitted;

    public Customer(String initName, int initAge, float initMoney) {
        this.name = initName;
        this.age = initAge;
        this.money = initMoney;
        this.admitted = false;
    }

    public Customer(String initName, int initAge) {
        this.name = initName;
        this.age = initAge;
        this.money = 0.0f;
        this.admitted = false;
    }

    public Customer(String initName) {
        this.name = initName;
        this.age = 0;
        this.money = 0.0f;
        this.admitted = false;
    }

    public Customer() {
        this.name = "Nick";
        this.age = 0;
        this.money = 0.0f;
        this.admitted = false;
    }

    public float computeFee() {
        if (age > 65 | age == 65) {
            return 6.37f;
        } else if (age > 18 | age == 18){
            return 12.75f;
        } else if (age < 3 | age == 3){
            return 0.0f;
        } else {
            return 8.5f;
        }
    }

    public boolean spend(float amt) {
        if ((money - amt) < 0) {
            return false;
        } else {
            money = money - amt;
            return true;
        }
    }

    public boolean hasMoreMoneyThan(Customer c) {
        if (money > c.money) {
            return true;
        } else {
            return false;
        }
    }

    public void payAdmission() {
        if (spend(computeFee())) {
            admitted = true;
        } else {
            admitted = false;
        }
    }

    public String toString() {
        if (admitted) {
            return "Customer " + name + ": a " + age + " year old with $" + money + " who has been admitted";
        } else {
            return "Customer " + name + ": a " + age + " year old with $" + money + " who has not been admitted";
        }
    }
}
