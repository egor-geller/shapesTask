package by.geller.project._main;

import by.geller.project.comparator.AreaComparator;
import by.geller.project.creator.QuadrangleRepositoryCreator;
import by.geller.project.creator.QuadrangleWarehouseCreator;
import by.geller.project.entity.Point;
import by.geller.project.exception.QuadrangleException;
import by.geller.project.observer.QuadrangleObserver;
import by.geller.project.observer.impl.QuadrangleObserverImpl;
import by.geller.project.parser.ParseShapeDataFromFile;
import by.geller.project.reader.ReadShapeDataFromFile;
import by.geller.project.repository.CreateShapeRepository;
import by.geller.project.repository.impl.AreaSpecification;
import by.geller.project.warehouse.QuadrangleWarehouse;


import java.util.*;

public class Main {
    static final String NAME_OF_SHAPE = "(\\D+:)";
    static String shapeName = "Quadrangle";

    public static void main(String[] args) throws QuadrangleException {
        Set<String> readShapes;
        var pathToFile = "./src/main/resources/file/shapes.txt";
        var readShapeDataFromFile = new ReadShapeDataFromFile();
        ParseShapeDataFromFile parseShapeDataFromFile = new ParseShapeDataFromFile();
        QuadrangleRepositoryCreator quadrangleRepositoryCreator = new QuadrangleRepositoryCreator();
        QuadrangleWarehouseCreator quadrangleWarehouseCreator = new QuadrangleWarehouseCreator();

        readShapes = readShapeDataFromFile.readLinesFromFile(pathToFile);
        for (String line : readShapes) {
            var name = Arrays.toString(line.split(NAME_OF_SHAPE));
            double[] setsOfPoints = parseShapeDataFromFile.parseQuadrangleFromStringToDouble(line);
            quadrangleRepositoryCreator.createRepositoryForQuadrangle(name ,setsOfPoints[0], setsOfPoints[1]
                    , setsOfPoints[2], setsOfPoints[3], setsOfPoints[4], setsOfPoints[5]);
            quadrangleWarehouseCreator.createQuadrangleWarehouse(name, setsOfPoints);
        }

        var point1 = new Point(1.2,1.3);
        var point2 = new Point(1.5,-12);
        var point3 = new Point(1.9,0);
        var points = new double[]{1.2, 1.3, 1.5, -12, 1.9, 0};

        quadrangleRepositoryCreator.createRepositoryForQuadrangle(shapeName, point1, point2, point3);
        quadrangleWarehouseCreator.createQuadrangleWarehouse(shapeName, points);
        var warehouse = QuadrangleWarehouse.getInstance();
        var repository = CreateShapeRepository.getInstance();
        System.out.println(warehouse.get(shapeName));
        var observer = new QuadrangleObserverImpl();
        repository.get(1).attach(observer);
        repository.get(1).setPoint1(new Point(33.5,3.6));
        System.out.println(warehouse.get(repository.get(1).getFigureName()));
        System.out.println(repository.sort(new AreaComparator()));
        System.out.println(repository.query(new AreaSpecification(1, 10000)));
    }
}
