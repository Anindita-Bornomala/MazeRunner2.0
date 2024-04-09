package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeRunner {
    private static final Logger logger = LogManager.getLogger();

    public MazeRunner(String[] args) {
        try {
            Configuration config = Configuration.configure(args);

            logger.info("** Starting Maze Runner");
            long startTime = System.currentTimeMillis(); // LOAD MAZE TIME
            // System.out.println(startTime); // TEST
            
            logger.info("**** Reading the maze from file " + config.getInputFile());
            logger.info("**** Reading for pathGuess: " + config.getPathGuess());
            logger.info("**** Reading the method: " + config.getMethod());
            logger.info("**** Reading for baseline: " + config.getBaseline());
            Maze mazeInput = new Maze(config.getInputFile());
            // mazeInput.printMaze(); // TEST
            long loadTime = System.currentTimeMillis() - startTime;
            logger.info("Time spent loading the maze: " + String.format("%.2f", loadTime / 1000.0) + " seconds");


            // long benchmarkTwo = System.currentTimeMillis();
            // System.out.println(benchmarkTwo);
            // logger.info("Time spent loading the maze: " + String.format("%.2f", loadTime/1000.0) + " seconds"); // BASELINE

            System.out.print(System.lineSeparator());
            logger.info("**** Computing path");


            if (config.getBaseline() != null) {

                // Make all the benchmarks happen here

                String yippee = config.getBaseline();
                logger.info("**** Baseline: " + config.getBaseline());
            } else {
                logger.info("**** Baseline not provided");
                Integer yippee2 = 0;
            }

            if (config.getBaseline() != null) {
                System.out.println("EPIC");
            } else if (config.getPathGuess() != null && config.getBaseline() == null) {
                logger.info("Checking provided path");
                PathChecker check = new PathChecker(mazeInput);
                System.out.println(check.pathCheck(mazeInput, config.getPathGuess()));
            } else if (config.getPathGuess() == null && config.getBaseline() == null) {
                // long benchmarkThree = System.currentTimeMillis(); // BENCHMARK 3
                // System.out.println(benchmarkThree); // AHHHH TEST

                if (config.getMethod().equals("bfs")) {
                    // To use BFS algo: enter "-method bfs"
                    logger.info("Running Breadth First Search algorithm");
                    BreadthFirstSearch getPathBFS = new BreadthFirstSearch(mazeInput);
                    getPathBFS.breadthFirstSearch();
                    // To use RightHandRule algo: enter "-method right"
                } else if (config.getMethod().equals("righthand")) {
                    logger.info("Running Righthand Rule algorithm");
                    RightHandRule getPath = new RightHandRule(mazeInput);
                    getPath.rightHandRule();
                }
                long methodTime = System.currentTimeMillis() - startTime;
                logger.info("Time spent exploring the maze using the provided method: " + String.format("%.2f", methodTime / 1000.0) + " seconds");
                // long benchmarkFour = System.currentTimeMillis();
                // System.out.println(benchmarkFour);
            }
            

            
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}

// This should be turned into an interface that runs either algorithm, RightHandRule or BFS 



/*
Here's the gist:
benchmark1: capture time between load operations
benchmark 2: capture time in rightHandRule class and return it
benchmark 3: capture time in BFS class and return it
benchmark 4: make difference happen in baseline mode (MazeRunner class)
*/