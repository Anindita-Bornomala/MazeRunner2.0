package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Baseline {
    private static final Logger logger = LogManager.getLogger();

    public Baseline(Maze maze, String method) {
        long startTimeLoading = System.currentTimeMillis();
        // loadFromFile(file); // Assuming this is a method to load the maze from file
        long endTimeLoading = System.currentTimeMillis();

        long startTimeMethod = System.currentTimeMillis();
        // Assuming baselineMethod() is a placeholder for the actual baseline method
        baselineMethod(maze, method);
        long endTimeMethod = System.currentTimeMillis();

        long startTimeBaseline = System.currentTimeMillis();
        baselineMethod(maze, "baseline"); // Assuming "baseline" is the identifier for the baseline method
        long endTimeBaseline = System.currentTimeMillis();

        double timeLoading = endTimeLoading - startTimeLoading;
        double timeMethod = endTimeMethod - startTimeMethod;
        double timeBaseline = endTimeBaseline - startTimeBaseline;

        double speedup = timeMethod / timeBaseline;

        logger.info("Time spent loading maze: " + String.format("%.2f", timeLoading) + " ms");
        logger.info("Time spent exploring maze using provided method: " + String.format("%.2f", timeMethod) + " ms");
        logger.info("Time spent exploring maze using baseline method: " + String.format("%.2f", timeBaseline) + " ms");
        logger.info("Improvement on the path as a speedup: " + String.format("%.2f", speedup));
    }

    private void baselineMethod(Maze maze, String method) {
        // Placeholder for the baseline method implementation
    }
}
