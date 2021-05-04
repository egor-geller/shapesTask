package by.geller.project.creator;

import by.geller.project.entity.Quadrangle;
import by.geller.project.entity.QuadrangleParameters;
import by.geller.project.exception.QuadrangleException;

import by.geller.project.service.CalculateService;
import by.geller.project.service.impl.CalculateServiceImpl;
import by.geller.project.warehouse.QuadrangleWarehouse;

public class QuadrangleWarehouseCreator {
    CalculateService calculateService = new CalculateServiceImpl();

    public void createQuadrangleWarehouse(Quadrangle quadrangle) throws QuadrangleException {
        String shapeName = quadrangle.getFigureName();

        double area = calculateService.areaOfFigure(quadrangle);
        double perimeter = calculateService.perimeterOfFigure(quadrangle);

        QuadrangleParameters quadrangleParameters = new QuadrangleParameters(perimeter, area);
        QuadrangleWarehouse warehouse = QuadrangleWarehouse.getInstance();
        warehouse.put(shapeName, quadrangleParameters);
    }

    public void createQuadrangleWarehouse(String shapeName, double[] coordinates) throws QuadrangleException {
        var quadrangle = new Quadrangle(shapeName, coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], coordinates[5]);


        double area = calculateService.areaOfFigure(quadrangle);
        double perimeter = calculateService.perimeterOfFigure(quadrangle);

        QuadrangleParameters quadrangleParameters = new QuadrangleParameters(perimeter, area);
        QuadrangleWarehouse warehouse = QuadrangleWarehouse.getInstance();
        warehouse.put(shapeName, quadrangleParameters);
    }
}
