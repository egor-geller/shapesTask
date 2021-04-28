package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;
import by.geller.project.service.impl.CalculateServiceImpl;

import java.util.Comparator;

public class AreaComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var calculateService = new CalculateServiceImpl();
        double area1 = calculateService.areaOfFigure(o1);
        double area2 = calculateService.areaOfFigure(o2);

        int compare = Double.compare(area1, area2);

        return compare;
    }
}
