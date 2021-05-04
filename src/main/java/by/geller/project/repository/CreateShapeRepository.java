package by.geller.project.repository;

import by.geller.project.entity.Quadrangle;
import by.geller.project.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CreateShapeRepository {
    private static final Logger logger = LogManager.getLogger();
    private final List<Quadrangle> shapes;
    private static CreateShapeRepository instance;

    private CreateShapeRepository() {
        shapes = new ArrayList<>();
    }

    public static CreateShapeRepository getInstance() {
        if (instance == null) {
            instance = new CreateShapeRepository();
        }
        return instance;
    }

    public boolean add(Quadrangle quadrangle) {
        return shapes.add(quadrangle);
    }

    public boolean remove(Object o) {
        return shapes.remove(o);
    }

    public boolean addAll(@NotNull Collection<? extends Quadrangle> c) {
        return shapes.addAll(c);
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return shapes.removeAll(c);
    }

    public Quadrangle get(int index) throws QuadrangleException {
        var quadrangle = shapes.get(index);
        if (quadrangle == null) {
            logger.warn("There is no shape in this index: {}", index);
            throw new QuadrangleException("There is no shape in this index: " + index);
        }
        return shapes.get(index);
    }

    public Quadrangle set(int index, Quadrangle element) {
        return shapes.set(index, element);
    }

    public List<Quadrangle> sort(Comparator<? super Quadrangle> c) {
        return shapes.stream().sorted(c).collect(Collectors.toList());
    }

    public List<Quadrangle> query(Specification specification) {
        List<Quadrangle> quadrangleList = new ArrayList<>();
        for (Quadrangle shape : shapes) {
            if (specification.specifyQuadrangle(shape)) {
                quadrangleList.add(shape);
            }
        }
        return quadrangleList;
    }

    public List<Quadrangle> queryByStream(Specification specification){
        return shapes.stream().filter(specification::specifyQuadrangle).collect(Collectors.toList());
    }

}
