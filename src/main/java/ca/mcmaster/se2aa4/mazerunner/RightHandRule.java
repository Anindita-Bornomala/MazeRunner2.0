package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule {
    private Compass heading;
    private Graph graph;
    
    private PathTranslator translator; // NEW!

    public RightHandRule(Maze maze) {
        this.translator = new PathTranslator();
        this.graph = new Graph(maze);
        this.heading = new Compass(Direction.EAST);
    }

    public void rightHandRule() {
        Coordinate endCond = graph.endCoord();
        Coordinate pointer = graph.getCurrent();
        Direction direction = this.heading.getHeading();
        String canonical = "";
        Coordinate nextPosition;
        System.out.println(pointer.getX());
        System.out.println(endCond.getX());
    
        while (pointer.getX() < endCond.getX()) {
            if (graph.checkRight(pointer, direction).equals(false)) {
                if (graph.checkForward(pointer, direction).equals(true)) {
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
        }
        translator.translateToFact(canonical); // gotta be able to return the string later
        // factorize(canonical);
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
