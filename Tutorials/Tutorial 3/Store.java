public class Store {
    public static final int MAX_CUSTOMERS = 500;
    public static int LATEST_ID = 100000;

    private String name;
    private Customer[] customers;
    private int customerCount;

    public Store(String n) {
        name = n;
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
    }

    public void addCustomer(Customer c) {
        if (customerCount < MAX_CUSTOMERS)
            customers[customerCount++] = c;
            c.setRewardsID(LATEST_ID + 1);
    }

    public void listCustomers() {
        for (int i = 0; i < customerCount; i++)
            System.out.println(customers[i]);
    }

    public int averageCustomerAge() {
        int avgAge = 0;
        for (int i = 0; i < customerCount; i++)
            avgAge += customers[i].getAge();
        return (avgAge / customerCount);
    }

    public Customer richestCustomer() {
        Customer richestCustomer = null;
        for (int i = 0; i < customerCount; i++) {
            if (richestCustomer != null) {
                if (customers[i].hasMoreMoneyThan(richestCustomer)) {
                    richestCustomer = customers[i];
                }
            } else {
                richestCustomer = customers[i];
            }
        }
        return richestCustomer;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public int getCustomerCount() {
        return customerCount;
    }

}
