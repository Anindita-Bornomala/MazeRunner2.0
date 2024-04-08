package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

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

            // AdjacencyList list = new AdjacencyList(mazeInput);
            // list.createAdjacencyList();
            // list.printAdjacencyList();
            // NEW TEST
            // mazeInput.printAdjacencyList(mazeInput);
            /* 
            BreadthFirstSearch getPathBFS = new BreadthFirstSearch(mazeInput);
            if (getPathBFS.findPath() != null) {
                System.out.println("yikes...");
            }
            */
            // System.out.println(getPathBFS.findPath());

            BreadthFirstSearch getPathBFS = new BreadthFirstSearch(mazeInput);
            List<Coordinate> path = getPathBFS.findPath();

            System.out.print(System.lineSeparator());
            logger.info("**** Computing path");

            if (config.getPathGuess() == null) {
                RightHandRule getPath = new RightHandRule(mazeInput);
                getPath.rightHandRule();
            } else {
                PathChecker check = new PathChecker();
                System.out.println(check.pathCheck(mazeInput, config.getPathGuess()));
            }
            
            // System.out.println();
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}

// This should be turned into an interface that runs either algorithm, RightHandRule or BFS 