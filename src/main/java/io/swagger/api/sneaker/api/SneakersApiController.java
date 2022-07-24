package io.swagger.api.sneaker.api;

import java.util.List;

import io.swagger.api.shared.dto.SneakerPriceUpdateDTO;
import io.swagger.api.shared.service.DiscountService;
import io.swagger.api.shared.service.SneakerPriceService;
import io.swagger.api.sneaker.dto.DiscountDTO;
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
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")

@Controller
public class SneakersApiController implements SneakersApi {

    private static final Logger log = LoggerFactory.getLogger(SneakersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final SneakerService sneakerService;

    private final DiscountService discountService;

    private final SneakerPriceService sneakerPriceService;

    private final Environment env;

    @org.springframework.beans.factory.annotation.Autowired
    public SneakersApiController(ObjectMapper objectMapper,
                                 HttpServletRequest request,
                                 SneakerService sneakerService,
                                 DiscountService discountService,
                                 SneakerPriceService sneakerPriceService,
                                 Environment env) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.sneakerService = sneakerService;
        this.discountService = discountService;
        this.sneakerPriceService = sneakerPriceService;
        this.env = env;
        sneakerService.bootstrapData();
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

    public ResponseEntity<Sneaker> getSneakerDiscountedPrice(@ApiParam(value = "Retrieve one sneaker with discount for the user." ,required=true )  @Valid @RequestBody DiscountDTO body) {
        return new ResponseEntity<Sneaker>(discountService.computeSneakerPriceDiscounted(body.getUserId(), body.getSneakerId()), HttpStatus.OK);
    }

    public ResponseEntity<Sneaker> updateSneakerPrice(@ApiParam(value = "Update sneaker price based on like count." ,required=true )  @Valid @RequestBody SneakerPriceUpdateDTO body) {
        return new ResponseEntity<Sneaker>(sneakerPriceService.updateSneakerPriceBasedOnLikeCount(body.getSneakerId(), body.getLikeCount()), HttpStatus.OK);
    }
}
