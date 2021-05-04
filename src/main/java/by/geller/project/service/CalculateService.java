package by.geller.project.service;

import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;

public interface CalculateService {
    double areaOfFigure(Quadrangle quadrangle) throws QuadrangleException;

    double perimeterOfFigure(Quadrangle quadrangle) throws QuadrangleException;
}
