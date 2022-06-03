package io.swagger.repository;

import io.swagger.model.Sneaker;

import java.util.List;

public interface SneakerRepository {
    void add(Sneaker sneaker);
    List<Sneaker> findAll();
}
