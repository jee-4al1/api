package io.swagger.api.user.api;

import io.swagger.api.user.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.user.repository.UserRepository;
import io.swagger.api.user.repository.UserRepositoryCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")

@Controller
public class UserRepositoryController implements UserRepositoryCustom {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private final UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public UserRepositoryController(ObjectMapper objectMapper, HttpServletRequest request, UserRepository userRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User userTmp = new User(user.getUsername(), user.getEmail());
            System.out.println(userTmp.toString());
            User _user = userRepository
                .save(userTmp);
            System.out.println(_user.toString());
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true) @PathVariable("username") String username) {
        try {
            Optional<User> user = userRepository.findByUsername(username);

            if (user.isPresent()){
                userRepository.delete(user.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ",required=true) @PathVariable("username") String username) {
        Optional<User> userData = userRepository.findByUsername(username);
        if (userData.isPresent()){
            return new ResponseEntity<User>(userData.get(), HttpStatus.OK);
        } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> loginUser(@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username,@NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("{  \"bytes\": [],  \"empty\": true}", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<User> updateUser(@ApiParam(value = "name that need to be updated",required=true) @PathVariable("username") String username,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body) {
        Optional<User> userData = userRepository.findByUsername(username);
        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setEmail(body.getEmail());
            _user.setFirstName(body.getFirstName());
            _user.setLastName(body.getLastName());
            _user.setPassword(body.getPassword());
            _user.setUserStatus(body.getUserStatus());
            _user.setUsername(body.getUsername());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
