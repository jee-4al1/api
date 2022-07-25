package io.swagger.api.sneaker.repository;

import java.util.List;

import io.swagger.api.shared.dto.SneakerPriceUpdateDTO;
import io.swagger.api.sneaker.dto.DiscountDTO;
import io.swagger.api.sneaker.model.Sneaker;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")

@Validated
@Api(value = "sneakers", description = "the sneakers API")
@RequestMapping(value = "/v1")
public interface SneakerRepositoryApiCustom {

    @ApiOperation(value = "Update sneaker database by calling an external sneaker API. Require release year of the sneakers.", nickname = "updateSneakersDatabase", notes = "", tags={ "sneakers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Specify a correct release year"),
        @ApiResponse(code = 201, message = "successful operation") })
    @RequestMapping(value = "/sneakers/update/{releaseYear}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> updateSneakersDatabase(@ApiParam(value = "Release year of the sneakers to update." ,required=true ) @PathVariable("releaseYear") int releaseYear);

    @ApiOperation(value = "Update sneaker sneaker price based on like count.", nickname = "updateSneakerPrice", notes = "", tags={ "sneakers", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid data"),
            @ApiResponse(code = 201, message = "successful operation") })
    @RequestMapping(value = "/sneakers/updatePrice",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Sneaker> updateSneakerPrice(@ApiParam(value = "Update sneaker price based on like count." ,required=true )  @Valid @RequestBody SneakerPriceUpdateDTO body);

    @ApiOperation(value = "Compute the price of a sneaker using the DiscountService", nickname = "getSneakerDiscountedPrice", notes = "", tags={ "sneakers", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid data"),
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/sneakers/price",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Sneaker> getSneakerDiscountedPrice(@ApiParam(value = "Retrieve one sneaker with discount for the user." ,required=true )  @Valid @RequestBody DiscountDTO body);

    @ApiOperation(value = "Retrieve all sneakers", nickname = "getAll", notes = "", response = Sneaker.class, responseContainer = "List", tags={ "sneakers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Sneaker.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "No data found") })
    @RequestMapping(value = "/sneakers/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Sneaker>> getAll();


    @ApiOperation(value = "Find sneaker by ID", nickname = "getSneakerById", notes = "Returns a single pair of sneaker", response = Sneaker.class, tags={ "sneakers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Sneaker.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Sneaker not found") })
    @RequestMapping(value = "/sneakers/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Sneaker> getSneakerById(@ApiParam(value = "ID of sneaker to return",required=true) @PathVariable("id") String id);
}
