package by.geller.project.factory;

import by.geller.project.entity.Point;
import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeFactory {
    private static Logger logger = LogManager.getLogger();

    private ShapeFactory() {

    }

    public static Quadrangle createQuadrangle(String shapeName, Point point1, Point point2, Point point3) throws QuadrangleException {
        Quadrangle quadrangle;
        if (point1.equals(point2) || point1.equals(point3) || point2.equals(point3)) {
            logger.info("Shape cannot be Quadrangle, points are the same: ({}), ({}), ({})", point1, point2, point3);
            throw new QuadrangleException("Shape cannot be Quadrangle, points are the same");
        }


        quadrangle = new Quadrangle(shapeName, point1, point2, point3);
        logger.info("Quadrangle {} with points: (0,0), ({}), ({}), ({}) has been created", shapeName, point1, point2, point3);
        return quadrangle;
    }

    public static Quadrangle createQuadrangle(String shapeName, double x1, double y1, double x2, double y2, double x3, double y3) throws QuadrangleException {
        Quadrangle quadrangle;
        if (Double.compare(x1, x2) != 0 || Double.compare(x1, x3) != 0 || Double.compare(x2, x3) != 0 ||
                Double.compare(y1, y2) != 0 || Double.compare(y1, y3) != 0 || Double.compare(y2, y3) != 0) {
            logger.info("Shape cannot be Quadrangle, points are the same: ({},{}), ({},{}), ({},{})", x1, y1, x2, y2, x3, y3);
            throw new QuadrangleException("Shape cannot be Quadrangle, points are the same");
        }

        quadrangle = new Quadrangle(shapeName, x1, y1, x2, y2, x3, y3);
        logger.info("Quadrangle {} with points: (0,0), ({},{}), ({},{}), ({},{}) has been created", shapeName, x1, y1, x2, y2, x3, y3);
        return quadrangle;
    }
}
