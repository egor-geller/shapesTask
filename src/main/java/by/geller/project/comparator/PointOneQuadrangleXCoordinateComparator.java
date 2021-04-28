package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;

import java.util.Comparator;

public class PointOneQuadrangleXCoordinateComparator implements Comparator<Quadrangle> {

    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        var compareXCoordinatePoint1 = Double.compare(o1.getPoint1().getX(), o2.getPoint1().getX());

        return compareXCoordinatePoint1;
    }
}
