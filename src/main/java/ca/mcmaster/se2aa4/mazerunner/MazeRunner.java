package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeRunner {
    private static final Logger logger = LogManager.getLogger();

    public MazeRunner(String[] args) {
        try {
            Configuration config = Configuration.configure(args);

            logger.info("** Starting Maze Runner");
            long startTime = System.currentTimeMillis(); // BENCHMARK 1
            
            logger.info("**** Reading the maze from file " + config.getInputFile());
            logger.info("**** Reading for pathGuess: " + config.getPathGuess());
            logger.info("**** Reading the method: " + config.getMethod());
            logger.info("**** Reading for baseline: " + config.getBaseline());
            Maze mazeInput = new Maze(config.getInputFile());
            // mazeInput.printMaze(); // TEST

            long loadTime = System.currentTimeMillis() - startTime;

            System.out.println(); // System.out.print(System.lineSeparator());
            logger.info("**** Computing path");


            // BASELINE MODE CODE
            if (config.getBaseline() != null) {
                // benchmark 1
                logger.info("Time spent loading the maze: " + String.format("%.2f", loadTime / 1000.0) + " seconds");

                // benchmark 2
                startTime = System.currentTimeMillis();
                BreadthFirstSearch bfs = new BreadthFirstSearch(mazeInput);
                bfs.breadthFirstSearch();
                // Integer methodCount = bfs.getPathCount();
                long methodTime = System.currentTimeMillis() - startTime;
                logger.info("Time spent running BFS algorithm: " + String.format("%.2f", methodTime / 1000.0) + " seconds");

                // benchmark 3
                startTime = System.currentTimeMillis();
                RightHandRule righthand = new RightHandRule(mazeInput);
                righthand.rightHandRule();
                // Integer baselineCount = righthand.getPathCount();
                long baselineTime = System.currentTimeMillis() - startTime;
                logger.info("Time spent running Righthand algorithm: " + String.format("%.2f", baselineTime / 1000.0) + " seconds");
                
                // benchmark 4

                logger.info(righthand.getPathCount());
                logger.info(bfs.getPathCount());
                double speedup = (double) righthand.getPathCount() / bfs.getPathCount();
                logger.info("Improvement on the path as a speedup (BFS vs Righthand Rule): " + String.format("%.2f", speedup));
            }
            
           

            if (config.getPathGuess() != null && config.getBaseline() == null) { // check path
                PathChecker check = new PathChecker(mazeInput);
                System.out.println(check.pathCheck(mazeInput, config.getPathGuess()));
            } else if (config.getPathGuess() == null && config.getBaseline() == null) {
                if (config.getMethod().equals("bfs")) { // To use BFS algo: enter "-method bfs"
                    BreadthFirstSearch getPathBFS = new BreadthFirstSearch(mazeInput);
                    getPathBFS.breadthFirstSearch();
                } else if (config.getMethod().equals("righthand")) { // To use RightHandRule algo: enter "-method right"
                    RightHandRule getPath = new RightHandRule(mazeInput);
                    getPath.rightHandRule();
                }
            }
            

            
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}

/*
Here's the gist:
benchmark1: capture time between load operations
benchmark 2: capture time in rightHandRule class and return it
benchmark 3: capture time in BFS class and return it
benchmark 4: make difference happen in baseline mode (MazeRunner class)
*/