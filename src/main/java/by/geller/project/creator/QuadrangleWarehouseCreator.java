package by.geller.project.creator;

import by.geller.project.entity.Quadrangle;
import by.geller.project.entity.QuadrangleParameters;
import by.geller.project.service.impl.CalculateServiceImpl;
import by.geller.project.warehouse.QuadrangleWarehouse;

public class QuadrangleWarehouseCreator {
    public void createQuadrangleWarehouse(Quadrangle quadrangle) {
        String shapeName = quadrangle.getFigureName();
        var calculateService = new CalculateServiceImpl();

        double area = calculateService.areaOfFigure(quadrangle);
        double perimeter = calculateService.perimeterOfFigure(quadrangle);

        QuadrangleParameters quadrangleParameters = new QuadrangleParameters(perimeter, area);
        QuadrangleWarehouse warehouse = QuadrangleWarehouse.getInstance();
        warehouse.put(shapeName, quadrangleParameters);
    }
}
