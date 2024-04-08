package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> graph;
    private Coordinate currentPosition;

    public Graph(Maze maze) {
        this.graph = maze.getData();
        this.currentPosition = maze.startCoord();
    }

    // might not need
    public Integer size() {
        return graph.size();
    }

    public Coordinate getCurrent() { return this.currentPosition; }

    public Coordinate nextStep(Direction heading) {
        Coordinate nextStep = new Coordinate(this.currentPosition.getX(), this.currentPosition.getY());
        switch (heading) {
            case Direction.EAST:
                nextStep.updateX(nextStep.getX() + 1);
                break;
            case Direction.SOUTH:
                nextStep.updateY(nextStep.getY() + 1);
                break;
            case Direction.WEST:
                nextStep.updateX(nextStep.getX() - 1);
                break;
            case Direction.NORTH:
                nextStep.updateY(nextStep.getY() - 1);
                break;
        }
        return nextStep;
    }

    // UPDATES CURRENT POSITION
    public Coordinate updateCurrent(Coordinate coord) {
        this.currentPosition = coord;
        return this.currentPosition;
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

    public Boolean checkRightTest(Coordinate coord, Direction heading) {
        switch(heading) {
            case Direction.EAST:
                return checkSouth(coord);
            case Direction.SOUTH:
                return checkWest(coord);
            case Direction.WEST:
                return checkNorth(coord);
            case Direction.NORTH:
                return checkEast(coord);
            default:
                return false;
        }
    }

    public Boolean checkRight(Coordinate coord, Compass compass) {
        // Compass compass = new Compass(direction);
        Direction right = compass.getRight();
        return checkForward(coord, right);
    }

    public Boolean checkLeft(Coordinate coord, Compass compass) {
        Direction left = compass.getLeft(); 
        return checkForward(coord, left);
        // Coordinate leftCoord = takeLeft(coord, heading);
        // return checkForward(leftCoord, heading);

        // Compass compass = new Compass(heading);
        // Direction left = compass.getLeft(); 
        // return checkForward(coord, left);
    }

}
