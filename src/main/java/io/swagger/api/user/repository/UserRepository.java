package io.swagger.api.user.repository;

import io.swagger.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String>{

    User findByUsername(String username);
}
