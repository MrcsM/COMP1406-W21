import java.util.Scanner;

public class ElectronicStoreTester {
    public static void main(String[] args) {
        ElectronicStore.printStock();

        System.out.println();

        while (true) {
            System.out.print("Enter a term to search for: ");
            Scanner sc = new Scanner(System.in);

            String term = sc.nextLine();

            if (term.equalsIgnoreCase("quit")) {
                System.out.println("Quitting...");
                System.exit(0);
            } else {
                System.out.println(ElectronicStore.searchStock(term));
            }
        }
    }
}


