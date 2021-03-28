public abstract class Product {
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    public Product(double p, int q) {
        this.price = p;
        this.stockQuantity = q;
        this.soldQuantity = 0;
    }
    public double sellUnits(int amount) {
        if (amount > stockQuantity) {
            return -1.0;
        } else {
            stockQuantity = stockQuantity - amount;
            soldQuantity += amount;
            return (amount * price);
        }
    }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public int getSoldQuantity() { return soldQuantity; }
}
