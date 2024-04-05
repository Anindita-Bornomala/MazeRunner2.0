package ca.mcmaster.se2aa4.mazerunner;

import java.io.FileNotFoundException;
import org.apache.commons.cli.*;

public class Configuration {
    private final String inputFile;
    private final String pathGuess;
    private final String method;

    public Configuration(String inputFile, String pathGuess, String inputMethod) {
        if (inputFile == null) {
            throw new IllegalArgumentException("Maze text file is empty!");
        }
        this.inputFile = inputFile;
        this.pathGuess = pathGuess;
        this.method = inputMethod;
    }

    public static Configuration configure(String[] cmdArgs) throws Exception, FileNotFoundException {
        Options options = new Options();
        options.addOption("i", "input", true, "Input filepath");
        options.addOption("p", "pathGuess", true, "Input path guess");
        options.addOption("m", "method", true, "Input method");
        
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, cmdArgs);
        String inputFilePath = cmd.getOptionValue("i");
        String inputPathGuess = cmd.getOptionValue("p");
        String inputMethod = cmd.getOptionValue("method");
        return new Configuration(inputFilePath, inputPathGuess, inputMethod);
    }

    public String getInputFile() { return inputFile; }

    public String getPathGuess() { return pathGuess; }

    public String getMethod() { return method; }
}

// We'll need to consider a new flag, one that allows the user to choose their preferred algorithm.
// COMPLETE