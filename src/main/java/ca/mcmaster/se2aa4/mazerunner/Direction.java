package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    // private final char dir;

    // Direction(char dir) { this.dir = dir; } // constructor

    // @Override
    // public String toString() { return "" + dir; }

    /* 
    public static Direction toDirection(String dir) {
        switch (dir.toUpperCase()) {
            case "N":
                return NORTH;
            case "S":
                return SOUTH;
            case "E":
                return EAST;
            case "W":
                return WEST;
            default:
                throw new IllegalArgumentException("Invalid direction: " + dir);
        }
    }
    */
}
