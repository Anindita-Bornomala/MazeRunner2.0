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
        Coordinate expectedEast = new Coordinate(2, 1);
        Coordinate expectedSouth = new Coordinate(1, 2);
        Coordinate expectedWest = new Coordinate(0, 1);
        Coordinate expectedNorth = new Coordinate(1, 0);

        assertEquals(expectedEast, testGraph.nextStep(Direction.EAST));
        assertEquals(expectedSouth, testGraph.nextStep(Direction.SOUTH));
        assertEquals(expectedWest, testGraph.nextStep(Direction.WEST));
        assertEquals(expectedNorth, testGraph.nextStep(Direction.NORTH));
    }


    @Test
    public void nextStepTest2() {
        testGraph.updateCurrent(new Coordinate(1, 1));
        Coordinate expectedEast;

        assertEquals(new Coordinate(2, 1), testGraph.nextStep(Direction.EAST));
        assertEquals(new Coordinate(1, 2), testGraph.nextStep(Direction.SOUTH));
        assertEquals(new Coordinate(0, 1), testGraph.nextStep(Direction.WEST));
        assertEquals(new Coordinate(1, 0), testGraph.nextStep(Direction.NORTH));
    }

}
