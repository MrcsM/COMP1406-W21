public class Trap extends GameObject.StationaryObject implements Harmful {

    public Trap(Point2D loc) {
        super(loc);
    }

    // The get method

    public int getDamageAmount() {
        return -50;
    }

}