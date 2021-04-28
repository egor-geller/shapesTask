package by.geller.project.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class PathToFileValidator {
    private static final Logger logger = LogManager.getLogger();

    static final String PATH_VALIDATION = "(.*\\\\\\w+.txt)$";

    public boolean pathValidation(String pathToFile){
        if (pathToFile.isBlank()){
            logger.info("Empty path to file {}", pathToFile);
            return false;
        }

        var pattern = Pattern.compile(PATH_VALIDATION);
        var matcher = pattern.matcher(pathToFile);
        boolean isMatches = matcher.matches();
        logger.info("Path to file is {}", isMatches);
        return isMatches;
    }
}
