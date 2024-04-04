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

    // UPDATES CURRENT POSITION
    public Coordinate updateCurrent(Coordinate coord) {
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
    public boolean checkEast(Coordinate coord) {
        int row = coord.getY();
        int col = coord.getX() + 1;
        return col < graph.get(0).size() && graph.get(row).get(col) == 0;
    }

    public boolean checkSouth(Coordinate coord) {
        int row = coord.getY() + 1;
        int col = coord.getX();
        return row < graph.size() && graph.get(row).get(col) == 0;
    }

    public boolean checkWest(Coordinate coord) {
        int row = coord.getY();
        int col = coord.getX() - 1;
        return col >= 0 && graph.get(row).get(col) == 0;
    }

    public boolean checkNorth(Coordinate coord) {
        int row = coord.getY() - 1;
        int col = coord.getX();
        return row >= 0 && graph.get(row).get(col) == 0;
    }

}
