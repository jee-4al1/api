package io.swagger.api.user.service;

import io.swagger.api.user.model.User;
import io.swagger.api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User findById(String userId){
        return userRepository.findById(userId).orElse(null);
    }

}
