public class CollisionException extends Exception {

    MovableObject source;

    public CollisionException(MovableObject s) {
        super(s + " collided with wall!");
        source = s;
    }
}
