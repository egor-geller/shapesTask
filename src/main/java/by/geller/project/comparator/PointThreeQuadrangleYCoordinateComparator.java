package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;

import java.util.Comparator;

public class PointThreeQuadrangleYCoordinateComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var compareYCoordinatePoint2 = Double.compare(o1.getPoint2().getY(), o2.getPoint2().getY());

        return compareYCoordinatePoint2;
    }
}
