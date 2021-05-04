package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;
import by.geller.project.service.impl.CalculateServiceImpl;

import java.util.Comparator;

public class AreaComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var calculateService = new CalculateServiceImpl();

        double area1;
        double area2;

        try {
            area1 = calculateService.areaOfFigure(o1);
            area2 = calculateService.areaOfFigure(o2);
        } catch (QuadrangleException e) {
            return (o1 == null || o2 == null) ? -1 : 1;
        }

        int compare = Double.compare(area1, area2);

        return compare;
    }
}
