package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;

import java.util.Comparator;

public class PointTwoQuadrangleYCoordinateComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var compareYCoordinatePoint3 = Double.compare(o1.getPoint3().getY(), o2.getPoint3().getY());

        return compareYCoordinatePoint3;
    }
}
