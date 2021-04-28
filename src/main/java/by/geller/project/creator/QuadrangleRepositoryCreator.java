package by.geller.project.creator;

import by.geller.project.entity.Point;
import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;
import by.geller.project.factory.ShapeFactory;
import by.geller.project.repository.CreateShapeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleRepositoryCreator {
    private static Logger logger = LogManager.getLogger();

    public void createRepositoryForQuadrangle(String nameOfShape, Point point1, Point point2, Point point3) throws QuadrangleException {
        Quadrangle quadrangle = ShapeFactory.createQuadrangle(nameOfShape, point1, point2, point3);
        QuadrangleWarehouseCreator warehouseCreator = new QuadrangleWarehouseCreator();
        warehouseCreator.createQuadrangleWarehouse(quadrangle);
        CreateShapeRepository createShapeRepository = CreateShapeRepository.getInstance();
        createShapeRepository.add(quadrangle);
        logger.info("Quadrangle {} with points: (0,0), ({}), ({}), ({}) has been created", nameOfShape, point1, point2, point3);
    }
}
