package logic;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Point(){
    }
    public Point rightFromRotation(Point forward) {

        int forwardX = forward.getX();
        int forwardY = forward.getY();
        int currentX = this.getX();
        int currentY = this.getY();

        if (forwardX == currentX && forwardY < currentY) {
            forwardX = forwardX + 1;
            forwardY = forwardY + 1;
            return new Point(forwardX, forwardY);
        }
        if (forwardX < currentX && forwardY == currentY) {
            forwardX = forwardX + 1;
            forwardY = forwardY - 1;
            return new Point(forwardX, forwardY);
        }
        if (forwardX == currentX && forwardY > currentY) {
            forwardX = forwardX - 1;
            forwardY = forwardY - 1;
            return new Point(forwardX, forwardY);
        }
        if (forwardX > currentX && forwardY == currentY) {
            forwardX = forwardX - 1;
            forwardY = forwardY + 1;
            return new Point(forwardX, forwardY);
        }
        return new Point();
    }

    public Point leftFromRotation(Point forward){

        int forwardX = forward.getX();
        int forwardY = forward.getY();
        int currentX = this.getX();
        int currentY = this.getY();

        if(forwardX == currentX && forwardY<currentY){
            forwardX = forwardX - 1;
            forwardY = forwardY + 1;
            return new Point(forwardX, forwardY);
        }
        if(forwardX < currentX && forwardY == currentY){
            forwardX = forwardX + 1;
            forwardY = forwardY + 1;
            return new Point(forwardX, forwardY);
        }
        if(forwardX == currentX && forwardY > currentY){
            forwardX = forwardX + 1;
            forwardY = forwardY - 1;
            return new Point(forwardX, forwardY);
        }
        if(forwardX > currentX && forwardY == currentY){
            forwardX = forwardX - 1;
            forwardY = forwardY - 1;
            return new Point(forwardX, forwardY);
        }
        return new Point();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
