public class Ball extends GameObject.MovableObject implements Harmful {
    private boolean 	isBeingHeld;

    public Ball(Point2D loc) {
        super(0, 0, loc);
        isBeingHeld = false;
    }

    // The get/set methods
    public boolean isBeingHeld() { return isBeingHeld; }
    public void setIsBeingHeld(boolean newHoldStatus) { isBeingHeld = newHoldStatus; }

    public int getDamageAmount() {
        return -200;
    }

    public void update() {
        moveForward();
        draw();
        if (speed - 1 > 0) {
            speed = speed - 1;
        } else {
            speed = 0;
        }
    }
}