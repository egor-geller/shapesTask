package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;
import by.geller.project.service.impl.CalculateServiceImpl;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var calculateService = new CalculateServiceImpl();
        double area1 = calculateService.perimeterOfFigure(o1);
        double area2 = calculateService.perimeterOfFigure(o2);

        int compare = Double.compare(area1, area2);

        return compare;
    }
}
