package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule {
    private Compass heading;
    private Graph graph;
    private Coordinate endCond;
    private PathTranslator translator;

    public RightHandRule(Maze maze) {
        this.translator = new PathTranslator();
        this.graph = new Graph(maze);
        this.heading = new Compass(Direction.EAST);
        this.endCond = maze.endCoord();
    }

    public void rightHandRule() {
        Coordinate pointer = graph.getCurrent();
        Direction direction = this.heading.getHeading();
        String canonical = "";
        Coordinate nextPosition;
    
        while (pointer.getX() < endCond.getX()) {
            if (graph.checkRight(pointer, heading).equals(false)) {
                // System.out.println("TESTING");
                if (graph.checkForward(pointer, direction).equals(true)) {
                    nextPosition = graph.nextStep(direction);
                    pointer = graph.updateCurrent(nextPosition);
                    canonical = canonical + "F";
                    // System.out.println("TESTING");
                } else {
                    direction = this.heading.turnLeft();
                    canonical = canonical + "L";
                    // System.out.println("TESTING");
                }
            } else {
                direction = this.heading.turnRight();
                canonical = canonical + "R";
                nextPosition = graph.nextStep(direction);
                pointer = graph.updateCurrent(nextPosition);
                canonical = canonical + "F";
                // System.out.println("TESTING");
            }
        }
        translator.translateToFact(canonical);
    }
}
