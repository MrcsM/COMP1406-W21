public class Laptop {
    double speed;
    int ram;
    int storage;
    boolean SSD;
    int screensize;

    public Laptop(double speed, int ram, int storage, boolean SSD, int screensize) {
        this.speed = speed;
        this.ram = ram;
        this.storage = storage;
        this.SSD = SSD;
        this.screensize = screensize;
    }

    @Override
    public String toString() {
        String screen = String.valueOf(screensize) + '"';
        if (SSD) {
            return screen + " Laptop PC with " + speed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB SSD drive.";
        } else {
            return screen + " Laptop PC with " + speed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB HDD drive.";
        }
    }
}
