package ca.mcmaster.se2aa4.mazerunner;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // @Override
    // public String toString() {
    //     return "Coordinate [x = " + this.x + ", y = " + this.y + "]";
    // }




}

// Coordinate is fine, tbh the only action we need is moving forward (need to fix logic for forward, right, and left turns) 