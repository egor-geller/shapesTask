package by.geller.project.repository;

import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;

public interface Specification {
    boolean specifyQuadrangle(Quadrangle quadrangle);
}
