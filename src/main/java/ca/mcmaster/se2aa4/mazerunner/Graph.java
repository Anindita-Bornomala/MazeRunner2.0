package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Graph {
    private Maze maze;
    private ArrayList<ArrayList<Integer>> graph;
    private Coordinate currentPosition;

    public Graph(String filePath) {
        this.maze = new Maze(filePath);
        this.graph = maze.getData();
        this.currentPosition = startCoord();
    }

    public Coordinate getCurrent() { return this.currentPosition; }

    public Coordinate getEast() { return new Coordinate(this.currentPosition.getX() + 1, this.currentPosition.getY()); }
    
    public Coordinate getSouth() { return new Coordinate(this.currentPosition.getX(), this.currentPosition.getY() + 1); }

    public Coordinate getWest() { return new Coordinate(this.currentPosition.getX() - 1, this.currentPosition.getY()); }

    public Coordinate getNorth() { return new Coordinate(this.currentPosition.getX(), this.currentPosition.getY() - 1); }

    // UPDATES CURRENT POSITION
    public Coordinate updateCurrent(Coordinate coord) { // might not need to return Coornidate, can be a void method
        this.currentPosition = coord;
        return this.currentPosition;
    }

    // START COORDINATES
    public Coordinate startCoord() {
        Coordinate start = new Coordinate(0,0);
        for (Integer i = 0; i < graph.size(); i++) {
            if (graph.get(i).get(0) == 0) {
                start.updateY(i);
                break;
            }
        }
        return start;
    }

    // END COORDINATES
    public Coordinate endCoord() {
        Coordinate end = new Coordinate(graph.size() - 1, 0);
        for (Integer i = 0; i < graph.size(); i++) {
            if (graph.get(i).get(graph.size()-1) == 0) {
                end.updateY(i);
                break;
            }
        }
        return end;
    }

    // CHECKS COORDINATE TO THE EAST
    // RISK: USING "GRAPH" INSTEAD OF "THIS.GRAPH"
    public Boolean checkEast(Coordinate coord) {
        int row = coord.getY();
        int col = coord.getX() + 1;
        return col < graph.get(0).size() && graph.get(row).get(col) == 0;
    }

    // CHECKS COORDINATE TO THE SOUTH
    public Boolean checkSouth(Coordinate coord) {
        int row = coord.getY() + 1;
        int col = coord.getX();
        return row < graph.size() && graph.get(row).get(col) == 0;
    }

    // CHECKS COORDINATE TO THE WEST
    public Boolean checkWest(Coordinate coord) {
        int row = coord.getY();
        int col = coord.getX() - 1;
        return col >= 0 && graph.get(row).get(col) == 0;
    }

    // CHECKS COORDINATE TO THE NORTH
    public Boolean checkNorth(Coordinate coord) {
        int row = coord.getY() - 1;
        int col = coord.getX();
        return row >= 0 && graph.get(row).get(col) == 0;
    }

    public Boolean checkForward(Coordinate coord, Direction heading) {
        switch(heading) {
            case Direction.EAST:
                return checkEast(coord);
            case Direction.SOUTH:
                return checkSouth(coord);
            case Direction.WEST:
                return checkWest(coord);
            case Direction.NORTH:
                return checkNorth(coord);
            default:
                return false;
        }
    }

    public Boolean checkRight(Coordinate coord, Direction heading) {
        Compass compass = new Compass(heading);
        Direction right = compass.getRight(); 
        return checkForward(coord, right);
    }

}
