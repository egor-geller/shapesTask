package by.geller.project.observer.impl;

import by.geller.project.entity.Quadrangle;
import by.geller.project.entity.QuadrangleParameters;
import by.geller.project.exception.QuadrangleException;
import by.geller.project.observer.QuadrangleEvent;
import by.geller.project.observer.QuadrangleObserver;
import by.geller.project.service.impl.CalculateServiceImpl;
import by.geller.project.warehouse.QuadrangleWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleObserverImpl implements QuadrangleObserver {
    private static final Logger logger = LogManager.getLogger();

    QuadrangleWarehouse quadrangleWarehouse = QuadrangleWarehouse.getInstance();
    CalculateServiceImpl calculateService = new CalculateServiceImpl();

    @Override
    public void updateArea(QuadrangleEvent quadrangleEvent) {
        Quadrangle quadrangle = quadrangleEvent.getSource();
        String nameOfShape = quadrangle.getFigureName();
        QuadrangleParameters quadrangleParameters = quadrangleWarehouse.get(nameOfShape);

        try {
            quadrangleParameters.setArea(calculateService.areaOfFigure(quadrangle));
        } catch (QuadrangleException e) {
            logger.error("Update area had an exception: {}", e.getMessage());
        }
    }

    @Override
    public void updatePerimeter(QuadrangleEvent quadrangleEvent) {
        Quadrangle quadrangle = quadrangleEvent.getSource();
        String nameOfShape = quadrangle.getFigureName();
        QuadrangleParameters quadrangleParameters = quadrangleWarehouse.get(nameOfShape);

        try {
            quadrangleParameters.setArea(calculateService.perimeterOfFigure(quadrangle));
        } catch (QuadrangleException e) {
            logger.error("Update perimeter had an exception {}", e.getMessage());
        }

    }
}
