import java.awt.Color;
public class Player extends GameObject.MovableObject {
    private static String		name;
    private Color       color;
    private static boolean 	hasBall;
    private int	 		score;

    public Player(String n, Color c, Point2D loc, int dir) {
        super(dir, 0, loc);
        name = n;
        color = c;
        hasBall = false;
        score = 0;
    }

    // The get/set methods
    public static String getName() { return name; }
    public Color getColor() { return color; }
    public static boolean hasBall() { return hasBall; }
    public int getScore() { return score; }
    public void setHasBall(boolean newHasBall) { hasBall = newHasBall; }
    public void setScore(int newScore) { score = newScore; }

}