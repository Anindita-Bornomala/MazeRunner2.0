package ca.mcmaster.se2aa4.mazerunner;

import java.util.Map;

public class MazeTest {
    // private Map<Coordinate, Cell> graph; // our graph system
    private Coordinate currentStep;
    private MazeData maze; // delete later



    public boolean checkNorth(MazeData mase, Coordinate currentSteps, Coordinate nextStep, Direction direction) {
        char element = maze.getMazeElement(nextStep.getX(), nextStep.getY());
        if (element != '#') {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkFront(MazeData maze, Integer[] currentSteps, char direction) { // check for walls in front
        Integer row = currentSteps[0];
        Integer col = currentSteps[1];
        if (direction == 'E') {
            col++;
        } else if (direction == 'S') {
            row++;
        } else if (direction == 'W') {
            col--;
        } else {
            row--;
        }
        if (maze.getMazeElement(row, col) != '#') {
            return true;
        } else {
            return false;
        }
    }

    
    public Coordinate nextStep(Coordinate currentStep, Direction direction) { // determine direction
        Coordinate nextPosition = currentStep;
        nextPosition.moveForward(direction);
        return nextPosition;
    }

    public Coordinate moveForward(Coordinate currentStep, Coordinate nextStep) { // move forward
        currentStep = nextStep;
        return currentStep;
    }

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
