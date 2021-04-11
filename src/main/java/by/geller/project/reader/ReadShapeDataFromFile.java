package by.geller.project.reader;

import by.geller.project.exception.QuadrangleException;
import by.geller.project.validator.ShapeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class ReadShapeDataFromFile {
    private static final Logger logger = LogManager.getLogger();

    public Set<String> readLinesFromFile(String path) throws QuadrangleException {
        Set<String> strings = new HashSet<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                if (ShapeValidator.isShape(line)) {
                    strings.add(line);
                    logger.info("String '{}' has been read successfully", line);
                }else{
                    logger.info("String '{}' has not been read", line);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            logger.error("IOException problem in reading lines from file");
            throw new QuadrangleException("IOException problem in reading lines from file", e.getCause());
        }
        return strings;
    }
}
