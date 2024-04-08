package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class PathChecker {
    private PathTranslator translator;
    private Compass compass;
    private Graph graph;

    public PathChecker(Maze maze) {
        this.translator = new PathTranslator();
        this.compass = new Compass(Direction.EAST);
        // this.graph = new Graph(maze);
    }

    public String pathCheck(Maze maze, String pathGuess) {
        Graph graph = new Graph(maze);
        // Compass compass = new Compass(Direction.EAST);
        if (pathGuess.charAt(0) == 'F' || pathGuess.charAt(0) == 'R' || pathGuess.charAt(0) == 'L') {
            pathGuess = pathGuess.replaceAll(" ", "");
        } else {
            pathGuess = translator.translateToCanon(pathGuess);
        }

        Coordinate endCond = maze.endCoord();
        // System.out.println(endCond);
        Coordinate pointer = graph.getCurrent();
        // System.out.println(pointer);
        Direction heading = compass.getHeading();
        Coordinate nextPosition;

        for (char element : pathGuess.toCharArray()) {
            if (element == 'F') {
                nextPosition = graph.nextStep(heading);
                pointer = graph.updateCurrent(nextPosition);
                System.out.println(nextPosition);
            } else if (element == 'R') {
                heading = compass.turnRight();
            } else if (element == 'L') {
                heading = compass.turnLeft();
            } else {
                    continue;
            }
        }

        if (pointer.getX() == endCond.getX()) {
            return "Correct path!";
        } else {
            return "Incorrect path!";
        }
    }
}