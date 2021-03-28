public class Wall extends GameObject.StationaryObject {
    private static int		    width;
    private static int		    height;

    public Wall(Point2D loc, int w, int h) {
        super(loc);
        width = w;
        height = h;
    }

    // The get/set methods
    public static int getWidth() { return width; }
    public static int getHeight() { return height; }

}