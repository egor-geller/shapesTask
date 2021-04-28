package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;

import java.util.Comparator;

public class PointThreeQuadrangleXCoordinateComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var compareXCoordinatePoint2 = Double.compare(o1.getPoint2().getX(), o2.getPoint2().getX());

        return compareXCoordinatePoint2;
    }
}
