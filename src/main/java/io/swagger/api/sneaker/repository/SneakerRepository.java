package io.swagger.api.sneaker.repository;

import io.swagger.api.sneaker.model.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SneakerRepository extends JpaRepository<Sneaker, String> {
    List<Sneaker> findAll();
    Optional<Sneaker> findById(String sneakerId);

}
