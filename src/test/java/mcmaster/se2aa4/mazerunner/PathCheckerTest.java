package mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.PathChecker;
import ca.mcmaster.se2aa4.mazerunner.Maze;

class PathCheckerTest {
    private Maze testMaze;
    private PathChecker testPathChecker;

    @BeforeEach
    public void setup() {
        this.testMaze = new Maze("./examples/straight.maz.txt");
        this.testPathChecker = new PathChecker(testMaze);
    }

    @Test
    public void testPathCheck() {
        // Correct path
        String correctPath = "FFFF";
        String resultCorrect = testPathChecker.pathCheck(testMaze, correctPath);
        assertEquals("Correct path!", resultCorrect);

        // Incorrect path
        String incorrectPath = "FFFRF";
        String resultIncorrect = testPathChecker.pathCheck(testMaze, incorrectPath);
        assertEquals("Incorrect path!", resultIncorrect);
    }
}
