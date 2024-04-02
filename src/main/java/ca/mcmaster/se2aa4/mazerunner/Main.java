package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Main {
    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            new MazeRunner(args);
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }    
}

// Main is fine, we don't need to change it.