public class Desktop {
    double speed;
    int ram;
    int storage;
    boolean SSD;

    public Desktop(double speed, int ram, int storage, boolean SSD) {
        this.speed = speed;
        this.ram = ram;
        this.storage = storage;
        this.SSD = SSD;
    }

    @Override
    public String toString() {
        if (SSD) {
            return "Desktop PC with " + speed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB SSD drive.";
        } else {
            return "Desktop PC with " + speed + "ghz CPU, " + ram + "GB RAM, " + storage + "GB HDD drive.";
        }
    }
}
