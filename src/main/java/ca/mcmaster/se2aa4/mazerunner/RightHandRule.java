package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule {

    private Compass heading;
    private Graph graph;


    public RightHandRule(Maze maze) {
        this.graph = new Graph(maze);
        this.heading = new Compass(Direction.EAST);
    }

    public void rightHandRuleTest() {
        Coordinate startCond = graph.startCoord();
        Coordinate endCond = graph.endCoord();
        Coordinate pointer = startCond;
        Direction direction = this.heading.getHeading();
        String canonical = "";
        Coordinate nextPosition;
        System.out.println("lit"); // WE WILL MOVE THIS DOWN UNTIL THIS METHOD WORKS
        System.out.println(pointer.getX());
        System.out.println(endCond.getX());
    
        int count = 0;
        while (pointer.getX() < endCond.getX() && count < 10) {
            // System.out.println("lit"); // YEE
            if (graph.checkRight(pointer, direction).equals(false)) {
                if (graph.checkForward(pointer, direction).equals(true)) {
                    nextPosition = graph.nextStep(direction);
                    graph.updateCurrent(nextPosition); // = pointer
                    System.out.println(nextPosition);
                    System.out.println(pointer);
                    canonical = canonical + "F";
                    System.out.println(canonical);
                } else {
                    direction = this.heading.turnLeft();
                    canonical = canonical + "L";
                    System.out.println(canonical);
                }
            } else {
                direction = this.heading.turnRight();
                canonical = canonical + "R";
                nextPosition = graph.nextStep(direction);
                graph.updateCurrent(nextPosition); // = pointer
                canonical = canonical + "F";
                System.out.println(canonical);
            }
            // System.out.println(canonical);
            count++;
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
