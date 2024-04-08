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
            
            Maze mazeInput = new Maze(config.getInputFile());
            mazeInput.printMaze();

            // Use the Algorithm interface to implement an algo depending ont he method config

            System.out.print(System.lineSeparator());
            logger.info("**** Computing path");

            if (config.getPathGuess() == null) {
                if (config.getMethod().equals("bfs")) {
                    // To use BFS algo: enter "-method bfs"
                    BreadthFirstSearch getPathBFS = new BreadthFirstSearch(mazeInput);
                    getPathBFS.breadthFirstSearch();
                    // To use RightHandRule algo: enter "-method right"
                } else if (config.getMethod().equals("right")) {
                    RightHandRule getPath = new RightHandRule(mazeInput);
                    getPath.rightHandRule();
                }
            } else {
                PathChecker check = new PathChecker(mazeInput);
                System.out.println(check.pathCheck(mazeInput, config.getPathGuess()));
            }
            
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}

// This should be turned into an interface that runs either algorithm, RightHandRule or BFS 