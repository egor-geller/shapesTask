package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;

import java.util.Comparator;

public class PointOneQuadrangleYCoordinateComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var compareYCoordinatePoint1 = Double.compare(o1.getPoint1().getY(), o2.getPoint1().getY());

        return compareYCoordinatePoint1;
    }
}
