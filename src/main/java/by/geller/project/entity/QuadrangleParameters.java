package by.geller.project.entity;

import java.util.Objects;

public class QuadrangleParameters {
    private double perimeter;
    private double area;

    public QuadrangleParameters(){}

    public QuadrangleParameters(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuadrangleParameters that = (QuadrangleParameters) o;
        return Double.compare(that.perimeter, perimeter) == 0 && Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(perimeter, area);
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("Quadrangle parameters:\n");
        stringBuilder.append("Area: ").append(area);
        stringBuilder.append("Perimeter: ").append(perimeter);
        return stringBuilder.toString();
    }
}
