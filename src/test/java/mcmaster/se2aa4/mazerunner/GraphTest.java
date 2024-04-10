package mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Coordinate;
import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Graph;
import ca.mcmaster.se2aa4.mazerunner.Maze;

import static org.junit.jupiter.api.Assertions.*;


public class GraphTest {
    private Maze testMaze;
    private Graph testGraph;

    @BeforeEach
    public void setup() {
        this.testMaze = new Maze("./examples/straight.maz.txt");
        this.testGraph = new Graph(testMaze);
    }


    @Test
    public void nextStepTest() {
        testGraph.updateCurrent(new Coordinate(1, 1));
        Coordinate expected = new Coordinate(2, 1);
        Coordinate result = testGraph.nextStep(Direction.EAST);
        assertEquals(expected, result);

        assertEquals(new Coordinate(1, 2), testGraph.nextStep(Direction.SOUTH));
        // Add more test cases for WEST and NORTH directions
    }
    
}
