package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeData {
    private static final Logger logger = LogManager.getLogger();
    public char[][] maze;
    public int sumRow;
    public int sumCol;

    public MazeData(String filePath) {
        this.maze = storeMazeData(filePath);
        this.sumRow = maze.length;
        this.sumCol = maze[0].length;
    }

    private char[][] storeMazeData(String filePath) {
        char [][] mazeData = null;
        try{
            int sumRows = 0;
            int sumCols = 0;

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                sumRows++;
                if (sumCols == 0) {
                    sumCols = line.length();
                }
            }
            reader.close();
            mazeData = new char[sumRows][sumCols];

            BufferedReader reader2 = new BufferedReader(new FileReader(filePath));
            String line2;
            int row = 0;
            while ((line2 = reader2.readLine()) != null) {
                for (int column = 0; column < line2.length(); column++) {
                    mazeData[row][column] = line2.charAt(column);
                }
                row++;
            }
            reader2.close();
        } catch (IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        return mazeData;
    }

    public int getSumRow() { return this.sumRow; }

    public int getSumCol() { return this.sumCol; }

    public char getStartCol(int row) { return this.maze[row][0]; }

    public char getEndCol(int row) { return this.maze[row][getSumCol()-1]; }

    public char getMazeElement(int row, int col) { return this.maze[row][col]; }
 
    public void printMazeData() {
        for (char[] mazeRow : this.maze) {
            for (char element : mazeRow) {
                if (element == '#') {
                    System.out.print("WALL ");
                } else if (element == ' ') {
                    System.out.print("PASS ");
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
}

// MazeData's gonna get a massive rehaul, I don't think we need to print the mazeData. Also this will be the MazeGraph class.