public class Laptop extends Product {
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;
    private double screenSize;

    public Laptop(double p, int q, double cpuSpeed, int ram, boolean ssd, int storage, double screenSize) {
        super(p, q);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
        this.screenSize = screenSize;
    }


    public String toString() {
        if (ssd) {
            return screenSize + " inch Laptop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB SSD drive. (" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        } else {
            return screenSize + " inch Laptop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB HDD drive. (" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        }
    }
}
