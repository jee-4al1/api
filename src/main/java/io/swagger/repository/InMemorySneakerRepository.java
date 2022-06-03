package io.swagger.repository;

import io.swagger.model.Sneaker;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemorySneakerRepository implements SneakerRepository {
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<String, Sneaker> data = new ConcurrentHashMap<>();

    @Override
    public void add(Sneaker Sneaker) {
        data.put(nextIdentity(), Sneaker);
    }

    @Override
    public void delete(String id) {
        data.remove(id);
    }

    @Override
    public List<Sneaker> findAll() {
        return List.copyOf(data.values());
    }

    public String nextIdentity() {
        return String.valueOf(count.incrementAndGet());
    }

    @Override
    public Sneaker findById(String id) {
        return data.get(id);
    }
}
