package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;

import java.util.Comparator;

public class PointTwoQuadrangleXCoordinateComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var compareXCoordinatePoint3 = Double.compare(o1.getPoint3().getX(), o2.getPoint3().getX());

        return compareXCoordinatePoint3;
    }
}
