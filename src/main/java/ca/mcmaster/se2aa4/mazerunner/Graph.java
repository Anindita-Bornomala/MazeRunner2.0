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
                start.updateX(i);
                break;
            }
        }
        System.out.println(start);
        return start;
    }

    public Coordinate endCoord(Maze maze) {
        Coordinate start = new Coordinate(0,graph.size() - 1);
        for (Integer i = 0; i < graph.size(); i++) {
            if (graph.get(i).get(graph.size()-1) == 0) {
                start.updateX(i);
                break;
            }
        }
        System.out.println(start);
        return start;
    }
    
}
