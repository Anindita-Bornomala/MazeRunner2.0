package ca.mcmaster.se2aa4.mazerunner;

public class Coordinate {
    private Integer x;
    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() { return this.x; }

    public Integer getY() { return this.y; }

    public void updateX(Integer x) { this.x = x; }

    public void updateY(Integer y) { this.y = y; }

    public Coordinate moveForward(Direction direction) {
        Integer newX = this.x;
        Integer newY = this.y;

        switch(direction) {
            case NORTH:
                newY -= 1;
                break;
            case SOUTH:
                newY += 1;
                break;
            case EAST:
                newX += 1;
                break;
            case WEST:
                newX -= 1;
                break;
            default:
                break;
        }
        return new Coordinate(newX, newY);
    }

    public String toString() {
        return "Coordinate [x =" + this.x + ", y =" + this.y + "]";
    }
    
}
