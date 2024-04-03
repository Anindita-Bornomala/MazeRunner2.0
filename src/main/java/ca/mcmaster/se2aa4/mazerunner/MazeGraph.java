package ca.mcmaster.se2aa4.mazerunner;

import java.util.Map;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help.TextTable.Cell;

public class MazeGraph {
    private Map<Coordinate, Cell> graph; // our graph system
    private Coordinate currentStep;
    private MazeData maze; // delete later


    public Coordinate pathStart(MazeData maze) { // get start coordinates
        this.maze = maze; // delete later
        Coordinate startC = new Coordinate(0, 0);

        for (int row = 0; row < maze.getSumRow() - 1; row++) {
            if ((maze.getSumCol() > 0) && ((maze.getStartCol(row)) != '#')) {
                startC.updateY(row);
                break;
            }
        }
        System.out.println(startC); // delete later
        return startC;
    }

    public Coordinate pathEnd(MazeData maze) { // get end coordinates
        this.maze = maze; // delete later
        Coordinate endC = new Coordinate(0, maze.sumRow - 1);

        for (int row = 0; row < maze.getSumRow() - 1; row++) {
            if (maze.getSumCol() > 0 && (maze.getEndCol(row)-1) != '#') {
                endC.updateX(row);
                break;
            }
        }
        return endC;
    }
    


}
