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
            logger.info("**** Reading the string: " + config.getMethod());
            
            Maze testMaze = new Maze(config.getInputFile()); // TESTING MAZEGRAPH
            testMaze.printMaze(); // TESTING MAZEGRAPH
            
            Graph graph = new Graph(config.getInputFile());
            Coordinate smurfStart = graph.startCoord(testMaze);
            System.out.println(smurfStart);
            Coordinate smurfEnd = graph.endCoord(testMaze);
            System.out.println(smurfEnd);

            System.out.println(graph.checkEast(testMaze, smurfStart)); // east, true
            System.out.println(graph.checkNorth(testMaze, smurfStart)); // north, false
            System.out.println(graph.checkSouth(testMaze, smurfStart)); // south, false
            // System.out.println(graph.checkPath(testMaze, smurfEnd)); // end coord, true

            // Coordinate east = graph.eastCoord(smurfStart);
            // System.out.println(east);
            // System.out.println(graph.checkEast(testMaze, smurfStart)); // east, true
            // System.out.println("EPIC HATS");
            // System.out.println(smurfStart);

            // Coordinate south = graph.southCoord(smurfStart);
            // System.out.println(south);
            // System.out.println(graph.checkPath(testMaze, south)); // south, false
            // System.out.println("EPIC HATS");
            // System.out.println(smurfStart);

            // Coordinate west = graph.westCoord(smurfStart);
            // System.out.println(west);
            // System.out.println(graph.checkPath(testMaze, west)); // west, false

            // Coordinate north = graph.northCoord(smurfStart);
            // System.out.println(north);
            // System.out.println(graph.checkPath(testMaze, north)); // north, false

            // System.out.println(graph.eastCoord(smurfStart));
            // System.out.println(graph.northCoord(smurfStart));
            // System.out.println(graph.southCoord(smurfStart));
            // System.out.println(graph.westCoord(smurfStart));

            // System.out.println(graph.checkPath(testMaze, graph.southCoord(smurfStart))); // south, false
            // System.out.println(graph.checkPath(testMaze, graph.eastCoord(smurfStart))); // east, true
            // System.out.println(graph.checkPath(testMaze, graph.northCoord(smurfStart))); // north, false
            // System.out.println(graph.checkPath(testMaze, graph.westCoord(smurfStart)));


            System.out.println();

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