package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker {

    private PathTranslator translator;

    public PathChecker() {
        this.translator = new PathTranslator();
    }

    public String pathCheck(Maze maze, String pathGuess) {
        Graph graph = new Graph(maze);
        Compass compass = new Compass(Direction.EAST);
        if (pathGuess.charAt(0) == 'F' || pathGuess.charAt(0) == 'R' || pathGuess.charAt(0) == 'L') {
            pathGuess = pathGuess.replaceAll(" ", "");
        } else {
            pathGuess = translator.translateToCanon(pathGuess);
        }

        Coordinate pointer = graph.getCurrent();
        Coordinate endCond = graph.endCoord();
        Direction heading = compass.getHeading();
        Coordinate nextPosition;

        for (char element : pathGuess.toCharArray()) {
            if (element == 'F') {
                nextPosition = graph.nextStep(heading);
                pointer = graph.updateCurrent(nextPosition);
            } else if (element == 'R') {
                heading = compass.turnRight();
            } else if (element == 'L') {
                heading = compass.getLeft();
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