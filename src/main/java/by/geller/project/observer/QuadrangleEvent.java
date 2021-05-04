package by.geller.project.observer;

import by.geller.project.entity.Quadrangle;

import java.util.EventObject;

public class QuadrangleEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public QuadrangleEvent(Object source) {
        super(source);
    }

    @Override
    public Quadrangle getSource() {
        return (Quadrangle) super.getSource();
    }
}
