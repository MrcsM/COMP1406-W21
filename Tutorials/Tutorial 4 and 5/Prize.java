public class Prize extends GameObject.StationaryObject {
    private static int 	    value;

    public Prize(Point2D loc, int val) {
        super(loc);
        value = val;
    }

    // The get/set methods
    public static int getValue() { return value; }

}