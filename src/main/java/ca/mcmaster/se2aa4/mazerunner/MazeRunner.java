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
            
            Maze testMaze = new Maze(config.getInputFile()); // TESTING MAZEGRAPH
            testMaze.printMaze(); // TESTING MAZEGRAPH
            
            // Graph graph = new Graph(testMaze);
            // Coordinate smurfStart = graph.startCoord();
            // System.out.println(smurfStart);
            // Coordinate smurfEnd = graph.endCoord();
            // System.out.println(smurfEnd);
            // System.out.println();

            if (config.getPathGuess() == null) {
                System.out.println("yo");
                // NEW TEST FOR RIGHTHANDRULE CLASS
                RightHandRule getPath = new RightHandRule(testMaze);
                getPath.rightHandRuleTest();
            }

            // System.out.println(graph.checkEast(smurfStart)); // east, true
            // System.out.println(graph.checkNorth(smurfStart)); // north, false
            // System.out.println(graph.checkSouth(smurfStart)); // south, false
            // System.out.println(graph.checkWest(smurfStart)); // west, false
            // System.out.println(graph.checkEast(smurfEnd)); // east, false

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