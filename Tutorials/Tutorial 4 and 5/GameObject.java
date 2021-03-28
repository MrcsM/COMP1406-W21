public abstract class GameObject {
    protected Point2D location;
    public abstract void update();

    public Point2D getLocation() { return location; }
    public void setLocation(Point2D newLocation) { location = newLocation; }

    public GameObject(Point2D loc) {
        location = loc;
    }

    public abstract static class MovableObject extends GameObject {
        protected int			direction;
        protected int 		    speed;

        public int getDirection() { return direction; }
        public int getSpeed() { return speed; }
        public void setDirection(int newDirection) { direction = newDirection; }
        public void setSpeed(int newSpeed) { speed = newSpeed; }

        public MovableObject(int d, int s, Point2D loc) {
            super(loc);
            setDirection(d);
            setSpeed(s);
            setLocation(loc);
        }

        public void update() {
            moveForward();
            draw();
        }

        public void moveForward() {
            if (speed > 0) {
                location = location.add((int) (Math.cos(Math.toRadians(direction)) * speed), (int) (Math.sin(Math.toRadians(direction)) * speed));
            }
        }

        public void draw() {
            System.out.println(this.getClass().getName() + " at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction +
                    " degrees going " + speed + " pixels per second");
        }

        public String toString() {
            if (this.getClass().getName() == "Ball") {
                return "Ball" + " at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction +
                        " degrees going " + speed + " pixels per second";
            } else if(this.getClass().getName() == "Player") {
                String  s =  "Player" + " " + Player.getName() + " at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction + " degrees";
                if (Player.hasBall())
                    s += " with the ball";
                return s;
            }
            return "";
        }
    }

    public abstract static class StationaryObject extends GameObject {

        public StationaryObject(Point2D loc) {
            super(loc);
        }

        public void update() {}

        public String toString() {
            if (this.getClass().getName() == "Wall") {
                return "Wall" + " at (" + (int)location.getX() + "," + (int)location.getY() + ") with width " +
                        Wall.getWidth() + " and height " + Wall.getHeight();
            } else if(this.getClass().getName() == "Trap") {
                return "Trap" + " at (" + (int)location.getX() + "," + (int)location.getY() + ")";
            } else if(this.getClass().getName() == "Prize") {
                return "Prize" + " at (" + (int)location.getX() + "," + (int)location.getY() + ") with value " + Prize.getValue();
            }
            return "";
        }
    }
}
