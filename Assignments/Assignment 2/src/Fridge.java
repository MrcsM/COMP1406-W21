public class Fridge extends Product {
    private int wattage;
    private String color;
    private String brand;
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double p, int q, int wattage, String color, String brand, double cf, boolean hasFreezer) {
        super(p, q);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
        this.cubicFeet = cf;
        this.hasFreezer = hasFreezer;
    }

    public String toString() {
        if (hasFreezer) {
            return cubicFeet + " cu. ft. " + brand + " Fridge with Freezer (" + color + ", " + wattage + " watts) (" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        } else {
            return cubicFeet + " cu. ft. " + brand + " Fridge (" + color + ", " + wattage + " watts) (" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        }
    }
}
