package by.geller.project.service;

import by.geller.project.entity.Quadrangle;

public interface CalculateService {
    double areaOfFigure(Quadrangle quadrangle);

    double perimeterOfFigure(Quadrangle quadrangle);
}
