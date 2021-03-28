public class Desktop extends Product {
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;
    private String profile;

    public Desktop(double p, int q, double cpuSpeed, int ram, boolean ssd, int storage, String profile) {
        super(p, q);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
        this.profile = profile;
    }

    public String toString() {
        if (ssd) {
            return profile + " Desktop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB SSD drive. (" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        } else {
            return profile + " Desktop PC with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB HDD drive. (" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        }
    }
}
