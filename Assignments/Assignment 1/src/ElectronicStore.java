import java.util.ArrayList;

public class ElectronicStore {

    public String name;
    static ArrayList<Object> stock = new ArrayList<>();

    public ElectronicStore(String name) {
        this.name = name;

        stock.add(new Desktop(2.7, 8, 1000, false));
        stock.add(new Desktop(3.1, 16, 2000, false));
        stock.add(new Desktop(4.2, 32, 6000, true));

        stock.add(new Laptop(4.0, 16, 500, true, 17));
        stock.add(new Laptop(1.5, 8, 256, true, 13));
        stock.add(new Laptop(2.7, 8, 500, false, 15));

        stock.add(new Fridge(15.6, true, "Gray"));
        stock.add(new Fridge(22.5, false, "Stainless Steel"));
        stock.add(new Fridge(33, true, "Black"));

    }

    @Override
    public String toString() {
        return name;
    }

    public static void printStock() {
        ElectronicStore store = new ElectronicStore("Electro-Shop");
        System.out.println("Here is the stock at the " + store.toString());
        int i = 0;
        while (i < stock.size()) {
            System.out.println(stock.get(i));
            i = i + 1;
        }
    }

    public static String searchStock(String search) {
        String term = search;
        if (true) {
            for (int i = 0; i < stock.size(); i++) {
                if (stock.get(i).toString().toLowerCase().contains(term.toLowerCase())) {
                    return "A matching item is contained in the store's stock.";
                }
            }
        }
        return "Could not find any items with the matching term '" + search + "'.";
    }
}

