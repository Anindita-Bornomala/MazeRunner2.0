package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker {

    private PathTranslator translator;

    public PathChecker() {
        this.translator = new PathTranslator();
    }
    

    public String pathCheckTest(Maze maze, String pathGuess) {
        Graph graph = new Graph(maze);
        Compass compass = new Compass(Direction.EAST);
        if (pathGuess.charAt(0) == 'F' || pathGuess.charAt(0) == 'R' || pathGuess.charAt(0) == 'L') {
            pathGuess = pathGuess.replaceAll(" ", "");
        } else {
            pathGuess = translator.translateToCanon(pathGuess);
            // pathGuess = factToCanon(pathGuess);
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


    public String pathCheck(MazeData maze, String pathGuess) {
        PathFinder pathFind = new PathFinder(maze);

        if (pathGuess.charAt(0) == 'F' || pathGuess.charAt(0) == 'R' || pathGuess.charAt(0) == 'L') {
            pathGuess = pathGuess.replaceAll(" ", "");
        } else {
            pathGuess = factToCanon(pathGuess);
        }

        Integer[] startCond = pathFind.pathStart(maze);
        Integer[] endCond = pathFind.pathEnd(maze);
        Integer[] pointer = startCond; // player
        char direction = 'E';
        Integer[] nextPosition;

        for (char element : pathGuess.toCharArray()) {
            if (element == 'F') {
                nextPosition = pathFind.nextStep(pointer, direction);
                pointer = pathFind.moveForward(pointer, nextPosition);
            } else if (element == 'R') {
                direction = pathFind.turnRight(direction);
            } else if (element == 'L') {
                direction = pathFind.turnLeft(direction);
            } else {
                continue;
            }
        }
        if (pointer[1] == endCond[1]) {
            return "Correct path!";
        } else {
            return "Incorrect path!";
        }
    }

    public String factToCanon(String factPathGuess) { // convert from factorized form to compact canonical
        String[] pathSplit = factPathGuess.split("(?<=\\D)(?=\\d)");
        String result = "";
        int count = 0;

        for (String element : pathSplit) {
            count = element.charAt(0) - '0';
            for (int i = 0; i < count; i++) {
                result = result + element.charAt(1);
            }
        }
        return result;
    }
}