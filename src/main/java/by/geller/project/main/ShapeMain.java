package by.geller.project.main;

import by.geller.project.exception.QuadrangleException;
import by.geller.project.reader.ReadShapeDataFromFile;
import by.geller.project.repository.CreateShapeRepository;

public class ShapeMain {
    public static void main(String[] args) {
        //TODO: main method
        //CreateShapeRepository createShapeRepository = new CreateShapeRepository();
        ReadShapeDataFromFile readShapeDataFromFile = new ReadShapeDataFromFile();
        var pathToFile = "./src/test/resources/file/shapes.txt";
        try {
            readShapeDataFromFile.readLinesFromFile(pathToFile);
        }catch (QuadrangleException e){
            e.getStackTrace();
        }
    }
}
