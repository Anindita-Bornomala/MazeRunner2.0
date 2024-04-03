package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Graph {
    private Maze maze;

    public Graph(Maze maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (ArrayList<Integer> row : this.graph) {
            for (Integer cell : row) {
                if (cell == 1) {
                    System.out.print("WALL "); // wall
                } else {
                    System.out.print("PASS "); // open path
                }
            }
            System.out.println();
        }
    }


    public Coordinate startCoord(Maze maze) {
        Coordinate start = new Coordinate(0,0);

        for (ArrayList<Integer> row : maze.getData()) {
            for (Integer cell : row) {
                if (cell == 1) {
                    System.out.print("WALL "); // wall
                } else {
                    System.out.print("PASS "); // open path
                }
            }
            System.out.println();
        }

        return null;
    }

    public Integer[] pathStart(MazeData maze) { // get start coordinates
        this.maze = maze;
        Integer[] startCoord = {0, 0};
        for (int row = 0; row < maze.getSumRow()-1; row++) {
            if ((maze.getSumCol() > 0) && ((maze.getStartCol(row)) != '#')) {
                startCoord[0] = row;
                break;
            }
        }
        return startCoord;
    } 
    
}
