package by.geller.project.comparator;

import by.geller.project.entity.Quadrangle;

import java.util.Comparator;

public class ShapeNameComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        String firstShapeName = o1.getFigureName();
        String secondShapeName = o2.getFigureName();

        if (firstShapeName.equals(secondShapeName)){
            return 0;
        }else{
            return -1;
        }
    }
}
