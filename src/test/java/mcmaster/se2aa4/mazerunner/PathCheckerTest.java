package mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.PathChecker;

class PathCheckerTest {
    private Maze testMaze;
    private PathChecker testPathChecker;

    @BeforeEach
    public void setup() {
        this.testMaze = new Maze(/* pass your maze parameters here */);
        this.testPathChecker = new PathChecker(testMaze);
    }

    @Test
    public void testPathCheck() {
        // Test a correct path
        String correctPath = "FFRFF";
        String resultCorrect = testPathChecker.pathCheck(testMaze, correctPath);
        assertEquals("Correct path!", resultCorrect);

        // Test an incorrect path
        String incorrectPath = "FFFRF";
        String resultIncorrect = testPathChecker.pathCheck(testMaze, incorrectPath);
        assertEquals("Incorrect path!", resultIncorrect);

        // Add more test cases for different paths and maze configurations
    }
}
