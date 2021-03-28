public class ToasterOven extends Product {
    private int wattage;
    private String color;
    private String brand;
    private int width;
    private boolean convection;

    public ToasterOven(double p, int q, int wattage, String color, String brand, int width, boolean convection) {
        super(p, q);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
        this.width = width;
        this.convection = convection;
    }


    public String toString() {
        if (convection) {
            return width + " inch " + brand + " Toaster with convection (" + color + ", " + wattage + " watts) (" + this.getPrice() + " each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        } else {
            return width + " inch " + brand + " Toaster (" + color + ", " + wattage + " watts) (" + this.getPrice() + " each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        }
    }

}
