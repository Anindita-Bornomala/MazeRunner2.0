package ca.mcmaster.se2aa4.mazerunner;

public class PathSequence {
    public PathSequence(MazeData maze) {
    }

    public void rightHandRule(MazeData maze) {
        PathFinder pathFind = new PathFinder(maze);

        Integer[] startCond = pathFind.pathStart(maze); 
        Integer[] endCond = pathFind.pathEnd(maze);
        Integer[] pointer = startCond;
        char direction = 'E';
        String canonical = "";
        Integer[] nextPosition;
        
        while (pointer[1] < endCond[1]) {
            if (pathFind.checkRight(maze, pointer, direction) == false) {
                if (pathFind.checkFront(maze, pointer, direction) == true) {
                    nextPosition = pathFind.nextStep(pointer, direction);
                    pointer = pathFind.moveForward(pointer, nextPosition);
                    canonical = canonical + "F";
                } else {
                    direction = pathFind.turnLeft(direction);
                    canonical = canonical + "L";
                }
            } else {
                direction = pathFind.turnRight(direction);
                canonical = canonical + "R";
                nextPosition = pathFind.nextStep(pointer, direction);
                pointer = pathFind.moveForward(pointer, nextPosition);
                canonical = canonical + "F";
            }
        }
        factorize(canonical);
    }

    public void factorize(String canonical) {
        String result = "";
        int count = 1;

        for (int i = 1; i <= canonical.length(); i++) {
            if(i == canonical.length() || canonical.charAt(i) != canonical.charAt(i-1)) {
                result = result + count + canonical.charAt(i-1) + " ";
                count = 1;
            } else {
                count++;
            }
        }
        System.out.println(result);
    }
}