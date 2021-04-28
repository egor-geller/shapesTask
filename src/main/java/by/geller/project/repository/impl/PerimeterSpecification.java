package by.geller.project.repository.impl;

import by.geller.project.entity.Quadrangle;
import by.geller.project.repository.Specification;
import by.geller.project.service.CalculateService;
import by.geller.project.service.impl.CalculateServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerimeterSpecification implements Specification {
    private static final Logger logger = LogManager.getLogger();
    double minimumPerimeter;
    double maximumPerimeter;

    public PerimeterSpecification(double minimumPerimeter, double maximumPerimeter) {
        this.minimumPerimeter = minimumPerimeter;
        this.maximumPerimeter = maximumPerimeter;
    }

    @Override
    public boolean specifyQuadrangle(Quadrangle quadrangle) {
        CalculateService perimeterOfFigureService = new CalculateServiceImpl();
        double perimeter = perimeterOfFigureService.perimeterOfFigure(quadrangle);

        boolean result = perimeter >= minimumPerimeter && perimeter <= maximumPerimeter;
        logger.info("Perimeter: {}, Result: {}", perimeter, result);
        return result;
    }
}
