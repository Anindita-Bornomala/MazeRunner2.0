package ca.mcmaster.se2aa4.mazerunner;

import java.io.FileNotFoundException;
import org.apache.commons.cli.*;

public class Configuration {
    private final String inputFile;
    private final String pathGuess;
    private final String method;
    private final String baseline;

    public Configuration(String inputFile, String pathGuess, String inputMethod, String inputBaseline) {
        if (inputFile == null) {
            throw new IllegalArgumentException("Maze text file is empty!");
        }
        this.inputFile = inputFile;
        this.pathGuess = pathGuess;
        this.method = inputMethod;
        this.baseline = inputBaseline;
    }

    public static Configuration configure(String[] cmdArgs) throws Exception, FileNotFoundException {
        Options options = new Options();
        options.addOption("i", "input", true, "Input filepath");
        options.addOption("p", "pathGuess", true, "Input path guess (optional)");
        options.addOption("m", "method", true, "Input method");
        options.addOption("b", "baseline", true, "Input baseline (optional)");
        
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, cmdArgs);
        String inputFilePath = cmd.getOptionValue("i");
        String inputPathGuess = cmd.getOptionValue("p");
        String inputMethod = cmd.getOptionValue("method");
        String inputBaseline = cmd.getOptionValue("baseline");
        // Integer inputBaseline = Integer.parseInt(inputBaselineString);

        return new Configuration(inputFilePath, inputPathGuess, inputMethod, inputBaseline);
    }

    public String getInputFile() { return inputFile; }

    public String getPathGuess() { return pathGuess; }

    public String getMethod() { return method; }
    
    public String getBaseline() { return baseline; }
}