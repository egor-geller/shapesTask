package parser;

import by.geller.project.parser.ParseShapeDataFromFile;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParseShapeDataFromFileTest {
    @Test
    public void parseQuadrangleFromStringToDoubleTest(){
        ParseShapeDataFromFile parseShapeDataFromFile = new ParseShapeDataFromFile();
        double[] setFromParser = parseShapeDataFromFile.parseQuadrangleFromStringToDouble("Quadrangle: 1.0 1.1 1.2 1.3 1.4 3.4");
        double[] expectedSet = new double[6];
        expectedSet[0] = 1.0;
        expectedSet[1] = 1.1;
        expectedSet[2] = 1.2;
        expectedSet[3] = 1.3;
        expectedSet[4] = 1.4;
        expectedSet[5] = 3.4;

        assertEquals(setFromParser, expectedSet);
    }
}
