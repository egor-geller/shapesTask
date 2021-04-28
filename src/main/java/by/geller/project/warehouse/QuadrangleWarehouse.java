package by.geller.project.warehouse;

import by.geller.project.entity.QuadrangleParameters;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class QuadrangleWarehouse {
    private final Map<String, QuadrangleParameters> quadrangleMap;
    private static QuadrangleWarehouse instance;

    private QuadrangleWarehouse() {
        quadrangleMap = new HashMap<>();
    }

    public static QuadrangleWarehouse getInstance() {
        if (instance == null) {
            instance = new QuadrangleWarehouse();
        }
        return instance;
    }

    public QuadrangleParameters get(String key) {
        return quadrangleMap.get(key);
    }

    public QuadrangleParameters put(String key, QuadrangleParameters value) {
        return quadrangleMap.put(key, value);
    }

    public boolean remove(String key, QuadrangleParameters value) {
        return quadrangleMap.remove(key, value);
    }

    public Collection<QuadrangleParameters> values() {
        return quadrangleMap.values();
    }
}
