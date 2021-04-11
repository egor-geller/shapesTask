package by.geller.project.entity;

import by.geller.project.exception.QuadrangleException;

import java.util.Objects;

public class Quadrangle {
    //TODO: set in Quadrangle Area and Perimeter for each individual shape
    private String figureName;
    private Point point1;
    private Point point2;
    private Point point3;

    private static final String ERROR_MSG = "Point can't be null";

    public Quadrangle() {
        this.point1 = new Point(0,0);
        this.point2 = new Point(0,0);
        this.point3 = new Point(0,0);
    }

    public Quadrangle(String name, Point point1) {
        this.figureName = name;
        this.point1 = point1;
    }

    public Quadrangle(String name, Point point1, Point point2, Point point3) {
        this.figureName = name;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Quadrangle(Quadrangle quadrangle){
        figureName = quadrangle.figureName;
        point1 = quadrangle.point1;
        point2 = quadrangle.point2;
        point3 = quadrangle.point3;
    }

    public void setFigureName(String name) {
        this.figureName = name;
    }

    public String getFigureName() {
        return figureName;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) throws QuadrangleException {
        if (point1 == null) {
            throw new QuadrangleException(ERROR_MSG);
        }
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) throws QuadrangleException {
        if (point2 == null) {
            throw new QuadrangleException(ERROR_MSG);
        }
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) throws QuadrangleException {
        if (point3 == null) {
            throw new QuadrangleException(ERROR_MSG);
        }
        this.point3 = point3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadrangle that = (Quadrangle) o;
        return figureName.equals(that.figureName) && point1.equals(that.point1) && point2.equals(that.point2) && point3.equals(that.point3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figureName, point1, point2, point3);
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "figureName='" + figureName + '\'' +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                '}';
    }
}
