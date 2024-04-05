package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeRunner {
    private static final Logger logger = LogManager.getLogger();

    public MazeRunner(String[] args) {
        try {
            Configuration config = Configuration.configure(args);

            logger.info("** Starting Maze Runner");
            logger.info("**** Reading the maze from file " + config.getInputFile());
            logger.info("**** Reading the string: " + config.getPathGuess());
            logger.info("**** Reading the method: " + config.getMethod());
            
            // TESTING REFACTORED, BETTER VERSION OF RIGHTHANDRULE
            Maze testMaze = new Maze(config.getInputFile()); // TESTING MAZEGRAPH
            // testMaze.printMaze(); // TESTING MAZEGRAPH

            if (config.getPathGuess() == null) {
                RightHandRule getPath = new RightHandRule(testMaze);
                getPath.rightHandRuleTest();
            }
            System.out.println();

            // Original stuff
            MazeData maze1 = new MazeData(config.getInputFile());
            maze1.printMazeData();

            System.out.print(System.lineSeparator());
            logger.info("**** Computing path");

            if (config.getPathGuess() == null) {
                PathSequence getSeq = new PathSequence(maze1);
                getSeq.rightHandRule(maze1);
            } else {
                PathChecker check = new PathChecker(maze1);
                System.out.println(check.pathCheck(maze1, config.getPathGuess()));
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}

// This should be turned into an interface that runs either algorithm, RightHandRule or BFS 