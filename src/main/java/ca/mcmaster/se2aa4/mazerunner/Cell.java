package ca.mcmaster.se2aa4.mazerunner;

public enum Cell {
    OPEN(0),
    WALL(1);

    private final Integer type;

    Cell(Integer type) {
        this.type = type;
    }

}
