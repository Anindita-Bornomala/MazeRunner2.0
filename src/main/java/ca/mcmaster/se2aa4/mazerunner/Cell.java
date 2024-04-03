package ca.mcmaster.se2aa4.mazerunner;

public enum Cell {
    OPEN(' '),
    WALL('#');

    private final char type;

    Cell(char type) {
        this.type = type;
    }

}
