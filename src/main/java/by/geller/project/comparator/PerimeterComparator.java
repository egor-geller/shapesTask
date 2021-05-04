package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;
import by.geller.project.service.impl.CalculateServiceImpl;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var calculateService = new CalculateServiceImpl();

        double perimeter1;
        double perimeter2;

        try {
            perimeter1 = calculateService.perimeterOfFigure(o1);
            perimeter2 = calculateService.perimeterOfFigure(o2);
        } catch (QuadrangleException e) {
            return (o1 == null || o2 == null) ? -1 : 1;
        }

        int compare = Double.compare(perimeter1, perimeter2);

        return compare;
    }
}
