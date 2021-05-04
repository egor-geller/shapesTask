package reader;

import by.geller.project.exception.QuadrangleException;
import by.geller.project.reader.ReadShapeDataFromFile;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class ReadShapeDataFromFileTest {
    @Test
    public void readLinesFromFileTest() throws QuadrangleException {
        ReadShapeDataFromFile readShapeDataFromFile = new ReadShapeDataFromFile();
        Set<String> setOfCoordinatesFromFile = readShapeDataFromFile.readLinesFromFile("./src/main/resources/file/shapes.txt");
        Set<String> expectedSetOfCoordinates = new HashSet<>();

        expectedSetOfCoordinates.add("1 2 3 4 5");
        expectedSetOfCoordinates.add("1 2 3.4 sfdg");
        expectedSetOfCoordinates.add("Quadrangle: 1.0 1.1 1.2 1.3 1.4 3.4");
        expectedSetOfCoordinates.add("1 2 3 -4 5");
        expectedSetOfCoordinates.add("Quadrangle: 1.0 1.1 1.2");
        expectedSetOfCoordinates.add("-1 -1 -1 1 1");

        assertEquals(setOfCoordinatesFromFile, expectedSetOfCoordinates);
    }

    @Test(expectedExceptions = QuadrangleException.class)
    public void testReadFromFileException() throws QuadrangleException {
        ReadShapeDataFromFile reader = new ReadShapeDataFromFile();
        Set<String> actualArray = reader.readLinesFromFile("path.txt");
    }
}
