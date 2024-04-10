package mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.mazerunner.Coordinate;
import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Compass;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.BreadthFirstSearch;

class BreadthFirstSearchTest {
    private Maze testMaze;
    private BreadthFirstSearch testBFS;

    @BeforeEach
    public void setup() {
        this.testMaze = new Maze("./examples/straight.maz.txt");
        this.testBFS = new BreadthFirstSearch(testMaze);
    }

    @Test
    public void testBreadthFirstSearch() {
        String path = testBFS.breadthFirstSearch();

        assertNotNull(path);
    }

    @Test
    public void testDirectionForward() {
        Compass compass = new Compass(Direction.EAST);
        Coordinate current = new Coordinate(1, 1);
        Coordinate nextEast = new Coordinate(2, 1);

        assertTrue(testBFS.directionForward(current, nextEast, compass.getHeading()));
    }

    @Test
    public void testDirectionLeft() {
        Compass compass = new Compass(Direction.EAST);
        Coordinate current = new Coordinate(1, 1);
        Coordinate nextNorth = new Coordinate(1, 0);

        assertTrue(testBFS.directionLeft(current, nextNorth, compass));
    }

    @Test
    public void testDirectionRight() {
        Compass compass = new Compass(Direction.EAST);
        Coordinate current = new Coordinate(1, 1);
        Coordinate nextSouth = new Coordinate(1, 2);
        
        assertTrue(testBFS.directionRight(current, nextSouth, compass));
    }
}
