package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeRunner {
    private static final Logger logger = LogManager.getLogger();
    private String righthandPath;
    private String bfsPath;

    public MazeRunner(String[] args) {
        try {
            Configuration config = Configuration.configure(args);
            logger.info("** Starting Maze Runner");

            // BENCHMARK 1
            Long startTime = System.currentTimeMillis();
            logger.info("**** Reading the maze from file: " + config.getInputFile());
            logger.info("**** Reading for pathGuess: " + config.getPathGuess());
            logger.info("**** Reading the method: " + config.getMethod());
            logger.info("**** Reading for baseline: " + config.getBaseline());
            Maze mazeInput = new Maze(config.getInputFile());
            Long loadTime = System.currentTimeMillis() - startTime;
            System.out.println();

            // BENCHMARK 2
            startTime = System.currentTimeMillis();
            BreadthFirstSearch bfs = new BreadthFirstSearch(mazeInput);
            bfsPath = bfs.breadthFirstSearch();
            Long methodTime = System.currentTimeMillis() - startTime;

            // BENCHMARK 3
            startTime = System.currentTimeMillis();
            RightHandRule righthand = new RightHandRule(mazeInput);
            righthandPath = righthand.rightHandRule();
            Long baselineTime = System.currentTimeMillis() - startTime;

            if (config.getBaseline() != null) {
                double speedup = (double) righthand.getPathCount() / bfs.getPathCount();
                logger.info("Time spent loading the maze: " + String.format("%.2f", loadTime / 1.0) + " milliseconds"); // benchmark 1
                logger.info("Time spent exploring the maze (BFS): " + String.format("%.2f", methodTime / 1.0) + " milliseconds"); // benchmark 2
                logger.info("Time spent exploring the maze (righthand): " + String.format("%.2f", baselineTime / 1.0) + " milliseconds"); // benchmark 3
                logger.info("Improvement on the path as a speedup (BFS vs Righthand Rule): " + String.format("%.2f", speedup)); // benchmark 4
            } else {
                if (config.getPathGuess() != null) {
                    PathChecker check = new PathChecker(mazeInput);
                    logger.info(check.pathCheck(mazeInput, config.getPathGuess()));
                } else {
                    logger.info("**** Computing path");
                    if (config.getMethod() != null) {
                        if (config.getMethod().equals("bfs")) {
                            logger.info(bfsPath); // To use BFS algo: enter "-method bfs"
                        } else {
                            logger.info(righthandPath); // To use RightHandRule algo: enter "-method righthand"
                        }
                    } else {
                        logger.info(righthandPath);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}