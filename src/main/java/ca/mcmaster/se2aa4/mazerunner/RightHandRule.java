package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule {

    private Compass heading;


    public RightHandRule(Graph graph) {
        this.heading = new Compass(Direction.EAST);
    }


    public void rightHandRuleTest(Graph graph) {
        Coordinate startCond = graph.startCoord();
        Coordinate endCond = graph.endCoord();
        Coordinate pointer = startCond; // maybe replace with graph.getCurrent()
        Direction direction = this.heading.getHeading(); // Direction direct = Direction.EAST;
        String canonical = ""; // change if can later
        Coordinate nextPosition;

        while (pointer.getY() < endCond.getY()) {
            if (graph.checkRight(pointer, direction) == false) {
                if (graph.checkForward(pointer, direction) == true) {
                    nextPosition = graph.nextStep(direction);
                    pointer = graph.updateCurrent(nextPosition);
                    canonical = canonical + "F";
                } else {
                    direction = this.heading.turnLeft();
                    canonical = canonical + "L";
                }
            } else {
                direction = this.heading.turnRight();
                canonical = canonical + "R";
                nextPosition = graph.nextStep(direction);
                pointer = graph.updateCurrent(nextPosition);
                canonical = canonical + "F";
            }
            factorize(canonical);
        }
    }
    

    public void rightHandRule(MazeData maze, Graph graph) { // delete MazeData maze parameter later
        PathFinder pathFind = new PathFinder(maze); // delete when fully replaced

        Integer[] startCond = pathFind.pathStart(maze);
        Integer[] endCond = pathFind.pathEnd(maze);
        Integer[] pointer = startCond;
        char direction = 'E';
        String canonical = "";
        Integer[] nextPosition;
        

        while (pointer[1] < endCond[1]) { // pointer y coord < endCond y coord
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
