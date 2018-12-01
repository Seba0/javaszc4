package seba0.javaszc4.servlets.cdi.model.repository;

import seba0.javaszc4.servlets.cdi.model.entities.Car;

import java.util.Collection;

public interface CarRepository {
    boolean create(Car car);

    Car read(Long id);

    Collection<Car> read();

    boolean update(Car car);

    Car delete(Long id);
}
