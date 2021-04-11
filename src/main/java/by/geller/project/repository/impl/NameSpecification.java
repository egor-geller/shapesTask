package by.geller.project.repository.impl;

import by.geller.project.entity.Quadrangle;
import by.geller.project.repository.Specification;

public class NameSpecification implements Specification {
    private String nameOfShape;

    public NameSpecification(String name){
        this.nameOfShape = name;
    }

    @Override
    public boolean specifyQuadrangle(Quadrangle quadrangle) {
        boolean result = quadrangle.getFigureName().contains(nameOfShape);
        return result;
    }
}
