package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Graph {
    private Maze maze;
    private ArrayList<ArrayList<Integer>> graph;

    public Graph(String filePath) {
        this.maze = new Maze(filePath);
        this.graph = maze.getData();
    }

    public Coordinate startCoord(Maze maze) {
        Coordinate start = new Coordinate(0,0);
        for (Integer i = 0; i < graph.size(); i++) {
            if (graph.get(i).get(0) == 0) {
                start.updateY(i);
                break;
            }
        }
        System.out.println(start);
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
        System.out.println(start);
        return start;
    }

    public Coordinate eastCoord(Coordinate currentPosition) {
        Coordinate eastCoord = currentPosition;
        eastCoord.updateX(eastCoord.getX() + 1);
        return eastCoord;
    }

    public Coordinate southCoord(Coordinate currentPosition) {
        Coordinate southCoord = currentPosition;
        southCoord.updateY(southCoord.getY() + 1);
        return southCoord;
    }

    public Coordinate westCoord(Coordinate currentPosition) {
        Coordinate westCoord = currentPosition;
        westCoord.updateX(westCoord.getX() - 1);
        return westCoord;
    }

    public Coordinate northCoord(Coordinate currentPosition) {
        Coordinate northCoord = currentPosition;
        northCoord.updateY(northCoord.getY() - 1);
        return northCoord;
    }


    public Boolean checkPath(Maze maze, Coordinate coord) {
        Integer row = coord.getX();
        Integer col = coord.getY();
        if (graph.get(row).get(col) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
