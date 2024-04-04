package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Graph {
    private Maze maze;
    private ArrayList<ArrayList<Integer>> graph;
    private Coordinate currentPosition;

    public Graph(String filePath) {
        this.maze = new Maze(filePath);
        this.graph = maze.getData();
        this.currentPosition = startCoord(maze);
    }


    public Coordinate updateCurrent(Coordinate coord) {
        
        this.currentPosition = coord;
        return this.currentPosition;
    }

    public Coordinate startCoord(Maze maze) {
        Coordinate start = new Coordinate(0,0);
        for (Integer i = 0; i < graph.size(); i++) {
            if (graph.get(i).get(0) == 0) {
                start.updateY(i);
                break;
            }
        }
        // System.out.println(start);
        return start;
    }

    public Coordinate endCoord(Maze maze) {
        Coordinate start = new Coordinate(graph.size() - 1, 0);
        for (Integer i = 0; i < graph.size(); i++) {
            if (graph.get(i).get(graph.size()-1) == 0) {
                start.updateY(i);
                break;
            }
        }
        // System.out.println(start);
        return start;
    }

    public Boolean checkEast(Maze maze, Coordinate coord) { // NEW
        Integer row = coord.getY();
        Integer col = coord.getX() + 1;
        if (graph.get(row).get(col) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkSouth(Maze maze, Coordinate coord) { // NEW
        Integer row = coord.getY() + 1;
        Integer col = coord.getX();
        if (graph.get(row).get(col) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkWest(Maze maze, Coordinate coord) { // NEW
        Integer row = coord.getY();
        Integer col = coord.getX() - 1;
        if (graph.get(row).get(col) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkNorth(Maze maze, Coordinate coord) { // NEW
        Integer row = coord.getY() - 1;
        Integer col = coord.getX();
        if (graph.get(row).get(col) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkPath(Maze maze, Coordinate coord) {
        Integer row = coord.getY();
        Integer col = coord.getX();
        if (graph.get(row).get(col) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
