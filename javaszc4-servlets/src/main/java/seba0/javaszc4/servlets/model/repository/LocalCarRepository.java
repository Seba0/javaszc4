package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Car;
import seba0.javaszc4.servlets.model.qualifier.Local;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Local
public class LocalCarRepository implements CarRepository {

    private final Map<Long, Car> repository = new HashMap<>();
    private long nextId = 1;

    @Override
    public boolean create(Car car) {
        car.setId(nextId++);
        repository.put(car.getId(), car);
        return true;
    }

    @Override
    public Car read(Long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Car> read() {
        return repository.values();
    }

    @Override
    public boolean update(Car car) {
        if (!repository.containsKey(car.getId())) {
            return false;
        }
        repository.put(car.getId(), car);
        return true;
    }

    @Override
    public Car delete(Long id) {
        return repository.remove(id);
    }
}
