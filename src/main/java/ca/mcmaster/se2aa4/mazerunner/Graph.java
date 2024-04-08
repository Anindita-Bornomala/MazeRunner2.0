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

    /* 
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
    */

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

    public Coordinate getForward(Coordinate coord, Direction heading) {
        Coordinate newCoord = new Coordinate(coord.getX(), coord.getY());
        switch(heading) {
            case Direction.EAST:
                newCoord.updateX(coord.getX() + 1);
            case Direction.SOUTH:
                newCoord.updateY(coord.getY() + 1);
            case Direction.WEST:
                newCoord.updateX(coord.getX() - 1);    
            case Direction.NORTH:
                newCoord.updateY(coord.getY() - 1);
        }
        return newCoord;
    }

    public Coordinate takeRight(Coordinate coord, Direction heading) {
        Coordinate newCoord = new Coordinate(coord.getX(), coord.getY());
        switch(heading) {
            case Direction.EAST:
                newCoord.updateY(coord.getY() + 1);
            case Direction.SOUTH:
                newCoord.updateX(coord.getX() - 1);
            case Direction.WEST:
                newCoord.updateY(coord.getY() - 1);
            case Direction.NORTH:
                newCoord.updateX(coord.getX() + 1);
        }
        return newCoord;
    }

    public Coordinate takeLeft(Coordinate coord, Direction heading) {
        Coordinate newCoord = new Coordinate(coord.getX(), coord.getY());
        switch(heading) {
            case Direction.EAST:
                newCoord.updateY(coord.getY() - 1);
            case Direction.SOUTH:
                newCoord.updateX(coord.getX() + 1);
            case Direction.WEST:
                newCoord.updateY(coord.getY() + 1);    
            case Direction.NORTH:
                newCoord.updateX(coord.getX() - 1);
        }
        return newCoord;
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

    public Boolean checkRight(Coordinate coord, Direction direction) {
        Compass compass = new Compass(direction);
        Direction right = compass.getRight(); 
        return checkForward(coord, right);
    }

    public Boolean checkLeft(Coordinate coord, Direction direction) {
        Compass compass = new Compass(direction);
        Direction left = compass.getLeft(); 
        return checkForward(coord, left);
        // Coordinate leftCoord = takeLeft(coord, heading);
        // return checkForward(leftCoord, heading);

        // Compass compass = new Compass(heading);
        // Direction left = compass.getLeft(); 
        // return checkForward(coord, left);
    }

}
