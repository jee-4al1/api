package io.swagger.api.sneaker.repository;

import io.swagger.api.sneaker.model.Sneaker;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemorySneakerRepository implements SneakerRepository {

    private final Map<String, Sneaker> data = new ConcurrentHashMap<>();

    @Override
    public void save(Sneaker sneaker) {
        data.put(sneaker.getId(), sneaker);
    }

    @Override
    public void delete(String id) {
        data.remove(id);
    }

    @Override
    public List<Sneaker> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public Sneaker findById(String id) {
        return data.get(id);
    }
}
