package io.swagger.api.sneaker.api;

import java.util.List;
import io.swagger.api.sneaker.model.Sneaker;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.sneaker.service.SneakerWebService;
import io.swagger.api.sneaker.service.SneakerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")

@Controller
public class SneakersApiController implements SneakersApi {

    private static final Logger log = LoggerFactory.getLogger(SneakersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final SneakerService sneakerService;

    private final Environment env;

    @org.springframework.beans.factory.annotation.Autowired
    public SneakersApiController(ObjectMapper objectMapper, HttpServletRequest request, SneakerService sneakerService, Environment env) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.sneakerService = sneakerService;
        this.env = env;
        //sneakerService.bootstrapData();
    }

    public ResponseEntity<Void> updateSneakersDatabase(@ApiParam(value = "Release year of sneakers to update in database." ,required=true )  @PathVariable("releaseYear") int releaseYear) {
        System.out.println(releaseYear);

        SneakerWebService sneakerWebService = new SneakerWebService(objectMapper, env);
        List<Sneaker> sneakers = sneakerWebService.retrieveSneakerFromApi(releaseYear);
        sneakerService.saveSneakers(sneakers);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<List<Sneaker>> getAll() {
        return new ResponseEntity<List<Sneaker>>(sneakerService.getAllSneakers(), HttpStatus.OK);
    }

    public ResponseEntity<Sneaker> getSneakerById(@ApiParam(value = "ID of sneaker to return",required=true) @PathVariable("id") String id) {
        return new ResponseEntity<Sneaker>(sneakerService.getSneakerById(id), HttpStatus.OK);
    }
}
