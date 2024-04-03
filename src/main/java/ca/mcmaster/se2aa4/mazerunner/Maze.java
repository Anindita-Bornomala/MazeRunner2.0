package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    private ArrayList<ArrayList<Integer>> graph; // 2d Integer arraylist where path = 0, wall = 1

    // private Map<Coordinate, Cell> graph; // our graph system

    public Maze(String filePath) {
        graph = new ArrayList<>();
        storeMaze(filePath);
    }

    private ArrayList<ArrayList<Integer>> getData() {
        return this.graph;
    }


    private void storeMaze(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int column = 0; column < line.length(); column++) {
                    char cell = line.charAt(column);
                    if (cell == ' ') {
                        row.add(0); // represents a path
                    } else {
                        row.add(1); // represents a wall
                    }
                }
                graph.add(row);
            }
            reader.close();
        } catch (IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
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
}
