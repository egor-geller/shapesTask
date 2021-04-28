package by.geller.project.factory;

import by.geller.project.entity.Point;
import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeFactory {
    private static Logger logger = LogManager.getLogger();

    private ShapeFactory(){

    }

    public static Quadrangle createQuadrangle(String shapeName, Point point1, Point point2, Point point3) throws QuadrangleException {
        Quadrangle quadrangle;
        if (point1.equals(point2) || point1.equals(point3) || point2.equals(point3)){
            logger.info("Shape cannot be Quadrangle, points are the same: ({}), ({}), ({})", point1, point2, point3);
            throw new QuadrangleException("Shape cannot be Quadrangle, points are the same");
        }


        quadrangle = new Quadrangle(shapeName, point1, point2, point3);
        logger.info("Quadrangle {} with points: (0,0), ({}), ({}), ({}) has been created", shapeName, point1, point2, point3);
        return quadrangle;
    }
}
