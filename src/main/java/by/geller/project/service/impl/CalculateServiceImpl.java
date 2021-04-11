package by.geller.project.service.impl;

import by.geller.project.entity.Quadrangle;
import by.geller.project.service.CalculateService;

public class CalculateServiceImpl implements CalculateService {
    Quadrangle quadrangle = new Quadrangle();
    double point1X = quadrangle.getPoint1().getX();
    double point1Y = quadrangle.getPoint1().getY();
    double point2X = quadrangle.getPoint2().getX();
    double point2Y = quadrangle.getPoint2().getY();
    double point3X = quadrangle.getPoint3().getX();
    double point3Y = quadrangle.getPoint3().getY();


    @Override
    public double areaOfFigure(Quadrangle quadrangleArea) {
        //Init Point1, Point2, Point3
        quadrangle = new Quadrangle(quadrangleArea);

        //Area of square
        if (quadrangleArea.getFigureName().equals("Square")) {
            double areaOfSquare = Math.pow(point1X, 2);
            return areaOfSquare;
        }
        //Area of Trapezoid
        if (quadrangleArea.getFigureName().equals("Trapezoid")) {
            double d3 = point2X - point1X;

            double areaOfTrapezoid = ((point3X + d3) / 2) * point1Y;
            return areaOfTrapezoid;
        }

        //Area of Rhombus
        if (quadrangleArea.getFigureName().equals("Rhombus")) {
            double p = distanceBetweenTwoPoints(0, 0, point2X, point2Y);
            double q = distanceBetweenTwoPoints(point1X, point1Y, point3X, point3Y);

            double areaOfRhombus = (p * q) / 2;
            return areaOfRhombus;
        }

        //Area of shape
        double a = distanceBetweenTwoPoints(0, 0, point1X, point1Y);
        double b = distanceBetweenTwoPoints(point1X, point1Y, point2X, point2Y);
        double c = distanceBetweenTwoPoints(point2X, point2Y, point3X, point3Y);
        double d = distanceBetweenTwoPoints(0, 0, point3X, point3Y);
        double e = distanceBetweenTwoPoints(point1X, point1Y, point3X, point3Y);
        double f = distanceBetweenTwoPoints(0, 0, point2X, point2Y);

        double areaOfShape = areaOfAGeneralQuadrilateral(a, b, c, d, e, f);
        return areaOfShape;
    }

    @Override
    public double perimeterOfFigure(Quadrangle quadranglePerimeter) {
        //Init Point1, Point2, Point3
        quadrangle = new Quadrangle(quadranglePerimeter);

        //Perimeter for Square or Rhombus
        if (quadranglePerimeter.getFigureName().equals("Square")
                || quadranglePerimeter.getFigureName().equals("Rhombus")) {
            double perimeterOfSquare = point1X * 4;
            return perimeterOfSquare;
        }

        //Perimeter for Trapezoid
        if (quadranglePerimeter.getFigureName().equals("Trapezoid")) {
            double d1 = distanceBetweenTwoPoints(0, 0, point1X, point1Y);
            double d3 = (double) point2X - point1X;
            double d4 = distanceBetweenTwoPoints(point2X, point2Y, point3X, point3Y);

            double perimeterOfTrapezoid = d1 + point3X + d3 + d4;

            return perimeterOfTrapezoid;
        }

        //Perimeter for shape
        double d1 = distanceBetweenTwoPoints(0, 0, point1X, point1Y);
        double d2 = distanceBetweenTwoPoints(point1X, point1Y, point2X, point2Y);
        double d3 = distanceBetweenTwoPoints(point2X, point2Y, point3X, point3Y);
        double d4 = distanceBetweenTwoPoints(0, 0, point3X, point3Y);

        double perimeterOfShape = d1 + d2 + d3 + d4;
        return perimeterOfShape;
    }

    private double distanceBetweenTwoPoints(double pointOf1x, double pointOf1y, double pointOf2x, double pointOf2y) {
        double d = Math.sqrt(Math.pow((pointOf2y - pointOf1y), 2) + Math.pow((pointOf2x - pointOf1x), 2));
        return d;
    }

    private double areaOfAGeneralQuadrilateral(double a, double b, double c, double d, double e, double f) {
        double s = (a + b + c + d) / 2;
        double result = Math.sqrt((s - a) * (s - b) * (s - c) * (s - d)
                - (0.25 * (a * c + b * d + e * f) * (a * c + b * d - e * f)));
        return result;
    }
}
