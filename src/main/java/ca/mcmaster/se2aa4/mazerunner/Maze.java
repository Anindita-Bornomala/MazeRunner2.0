package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    private ArrayList<ArrayList<Integer>> mazeData; // 2d Integer arraylist where path = 0, wall = 1

    public Maze(String filePath) {
        this.mazeData = new ArrayList<>();
        storeMaze(filePath);
    }


    // won't need later
    public void printAdjacencyList(Maze maze) {
        AdjacencyList list = new AdjacencyList(maze);
        list.printAdjacencyList();
    }
    

    public ArrayList<ArrayList<Integer>> getData() {
        return this.mazeData;
    }

    private void storeMaze(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<Integer> row = new ArrayList<>();
                for (Integer column = 0; column < line.length(); column++) {
                    char cell = line.charAt(column);
                    if (cell == ' ') {
                        row.add(0); // represents a path
                    } else {
                        row.add(1); // represents a wall
                    }
                }
                mazeData.add(row);
            }
            reader.close();
        } catch (IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }

    // in the end, we don't need to print the maze
    public void printMaze() {
        for (ArrayList<Integer> row : this.mazeData) {
            for (Integer cell : row) {
                if (cell == 1) {
                    System.out.print("WALL ");
                } else {
                    System.out.print("PASS ");
                }
            }
            System.out.println();
        }
    }   

        // START COORDINATES
        public Coordinate startCoord() {
            Coordinate startCoord = new Coordinate(0,0);
            for (Integer i = 0; i < mazeData.size(); i++) {
                if (mazeData.get(i).get(0) == 0) {
                    startCoord.updateY(i);
                    break;
                }
            }
            return startCoord;
        }
    
        // END COORDINATES
        public Coordinate endCoord() {
            Coordinate endCoord = new Coordinate(mazeData.size() - 1, 0);
            for (Integer i = 0; i < mazeData.size(); i++) {
                if (mazeData.get(i).get(mazeData.size()-1) == 0) {
                    endCoord.updateY(i);
                    break;
                }
            }
            return endCoord;
        }
    

}
