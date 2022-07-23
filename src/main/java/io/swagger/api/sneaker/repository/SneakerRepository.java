package io.swagger.api.sneaker.repository;

import io.swagger.api.sneaker.model.Sneaker;

import java.util.List;

public interface SneakerRepository {
    void add(Sneaker sneaker);
    List<Sneaker> findAll();
    Sneaker findById(String id);
    void delete(String id);
}
