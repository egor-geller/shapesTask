package by.geller.project.observer;

import by.geller.project.exception.QuadrangleException;
import by.geller.project.observer.impl.QuadrangleObserverImpl;

public interface Observable {
    void attach(QuadrangleObserverImpl observer);

    void detach(QuadrangleObserverImpl observer);

    void notifyObservers() throws QuadrangleException;
}
