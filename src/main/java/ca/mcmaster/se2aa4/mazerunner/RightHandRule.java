package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule {

    private Compass heading;
    private Graph graph;


    public RightHandRule(Maze maze) {
        this.graph = new Graph(maze);
        this.heading = new Compass(Direction.EAST);
    }

    public void rightHandRuleTest2() {
        Coordinate startCond = graph.startCoord();
        Coordinate endCond = graph.endCoord();
        Coordinate pointer = startCond;
        Direction direction = this.heading.getHeading();
        String canonical = "";
        Coordinate nextPosition;
    
        while (pointer.getY() < endCond.getY()) {
            if (graph.checkRight(pointer, direction).equals(false)) {
                if (graph.checkForward(pointer, direction).equals(true)) {
                    nextPosition = graph.nextStep(direction);
                    graph.updateCurrent(nextPosition); // = pointer
                    canonical = canonical + "F";
                } else {
                    direction = this.heading.turnLeft();
                    canonical = canonical + "L";
                }
            } else {
                direction = this.heading.turnRight();
                canonical = canonical + "R";
                nextPosition = graph.nextStep(direction);
                graph.updateCurrent(nextPosition); // = pointer
                canonical = canonical + "F";
            }
            // System.out.println(canonical);
        }
        System.out.println(canonical);
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
