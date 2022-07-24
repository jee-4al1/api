package io.swagger.api.user.repository;

import io.swagger.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String>{

    Optional<User> findByUsername(String username);
}
