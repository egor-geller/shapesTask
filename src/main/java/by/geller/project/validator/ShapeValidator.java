package by.geller.project.validator;

import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class ShapeValidator {
    Quadrangle quadrangle = new Quadrangle();
    double point1X = quadrangle.getPoint1().getX();
    double point1Y = quadrangle.getPoint1().getY();
    double point2X = quadrangle.getPoint2().getX();
    double point2Y = quadrangle.getPoint2().getY();
    double point3X = quadrangle.getPoint3().getX();
    double point3Y = quadrangle.getPoint3().getY();

    private static final Logger logger = LogManager.getLogger();

    static final String LINE_VALIDATION = "(\\D+:\\s+«\\d+.\\d+\\s+\\d+.\\d+\\s+\\d+.\\d+»)";

    public static boolean isShape(String input) {
        var pattern = Pattern.compile(LINE_VALIDATION);
        var matcher = pattern.matcher(input.trim());

        logger.info("method isQuadrangle for line {} returns {}", input, matcher.matches());

        return matcher.matches();
    }

    public boolean isQuadrangle(Quadrangle quadrangle1) {
        quadrangle = quadrangle1;

        double m1 = (point2Y - point1Y) / (point2X - point1X);
        double m2 = (point3Y - point2Y) / (point3X - point2X);

        return Double.compare(m1, m2) != 0;
    }

    public boolean isSquare(double diagonal1, double diagonal2) {
        return Double.compare(diagonal1, diagonal2) == 0;
    }

    public boolean isRhombus(double distanceA, double distanceB) {
        return Double.compare(distanceA, distanceB) == 0;
    }

    public boolean isTrapezoid(Quadrangle quadrangle1) throws QuadrangleException {
        //Init Point1, Point2, Point3
        quadrangle = quadrangle1;

        if ((point2X - point1X) == 0 || (point3X) == 0 || (point1X) == 0 || (point3X - point2X) == 0) {
            throw new QuadrangleException("Can't divide in formula by 0");
        }

        double m1 = (point2Y - point1Y) / (point2X - point1X);
        double m2 = point3Y / (point3X);
        double m3 = point1Y / (point1X);
        double m4 = (point3Y - point2Y) / (point3X - point2X);

        int isSame = Double.compare(m1, m2);
        int different = Double.compare(m3, m4);
        return isSame == 0 && different != 0;
    }
}
