package by.geller.project.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ParseShapeDataFromFile {
    private static final Logger logger = LogManager.getLogger();

    private static final String SPACE_REGEX = "\\s+";

    public double[] parseQuadrangleFromStringToDouble(String correctLineFromFile) {
        String[] line = correctLineFromFile.split(SPACE_REGEX);

        var setOfPoints = new double[line.length];

        for (var i = 1; i < line.length; i++) {
            setOfPoints[i] = Double.parseDouble(line[i]);
        }

        logger.info("Sets of points: {}", setOfPoints);
        return setOfPoints;
    }
}
