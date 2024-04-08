package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker {
    private PathTranslator translator;
    private Compass compass;

    public PathChecker(Maze maze) {
        this.translator = new PathTranslator();
        this.compass = new Compass(Direction.EAST);
    }

    public String pathCheck(Maze maze, String pathGuess) {
        Graph graph = new Graph(maze);
        if (pathGuess.charAt(0) == 'F' || pathGuess.charAt(0) == 'R' || pathGuess.charAt(0) == 'L') {
            pathGuess = pathGuess.replaceAll(" ", "");
        } else {
            pathGuess = translator.translateToCanon(pathGuess);
        }

        Coordinate endCond = maze.endCoord();
        Coordinate pointer = graph.getCurrent();
        Direction heading = compass.getHeading();
        Coordinate nextPosition;

        for (char element : pathGuess.toCharArray()) {
            if (element == 'F') {
                nextPosition = graph.nextStep(heading);
                pointer = graph.updateCurrent(nextPosition);
                // System.out.println(nextPosition);
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