package logic;

public class RobotCoords {

    Point position;
    Point lookingAt;

    public RobotCoords(Point pos, Point f){
        position = pos;
        lookingAt = f;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getLookingAt() {
        return lookingAt;
    }

    public void setLookingAt(Point lookingAt) {
        this.lookingAt = lookingAt;
    }
}
