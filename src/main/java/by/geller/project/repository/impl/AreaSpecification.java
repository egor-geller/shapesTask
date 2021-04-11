package by.geller.project.repository.impl;

import by.geller.project.entity.Quadrangle;
import by.geller.project.repository.Specification;
import by.geller.project.service.CalculateService;
import by.geller.project.service.impl.CalculateServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AreaSpecification implements Specification {
    private static final Logger logger = LogManager.getLogger();

    double minimumArea;
    double maximumArea;

    public AreaSpecification(double minimumArea, double maximumArea) {
        this.minimumArea = minimumArea;
        this.maximumArea = maximumArea;
    }

    @Override
    public boolean specifyQuadrangle(Quadrangle quadrangle) {
        CalculateService areaOfFigureService = new CalculateServiceImpl();
        double area = areaOfFigureService.areaOfFigure(quadrangle);

        boolean result = area >= minimumArea && area <= maximumArea;
        logger.info("Area: {}, Result: {}", area, result);
        return result;
    }
}
