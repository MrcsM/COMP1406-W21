public class CustomerTestProgram {
    public static void main(String[] args) {
        Customer c;

        c = new Customer("Bob");
        c.age = 27;
        c.money = 50;
        System.out.println(c.name);
        System.out.println(c.age);
        System.out.println(c.money);

        Customer c2 = new Customer("Jen");
        c2.age = 25;
        c2.money = 15;
        System.out.println(c2.name);
        System.out.println(c2.age);
        System.out.println(c2.money);
    }
}
