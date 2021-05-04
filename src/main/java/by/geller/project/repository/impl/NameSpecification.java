package by.geller.project.repository.impl;

import by.geller.project.entity.Quadrangle;
import by.geller.project.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NameSpecification implements Specification {
    private static final Logger logger = LogManager.getLogger();
    private String nameOfShape;

    public NameSpecification(String name){
        this.nameOfShape = name;
    }

    @Override
    public boolean specifyQuadrangle(Quadrangle quadrangle) {
        boolean result = quadrangle.getFigureName().contains(nameOfShape);
        logger.info("Shape: {} is found {}", nameOfShape, result);
        return result;
    }
}
