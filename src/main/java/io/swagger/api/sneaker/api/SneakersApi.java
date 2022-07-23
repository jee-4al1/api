/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.sneaker.api;

import java.util.List;
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
public interface SneakersApi {

    @ApiOperation(value = "Creates list of sneakers with given input array", nickname = "createSneakersWithArrayInput", notes = "", tags={ "sneakers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid data in the wishlist"),
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/sneakers/createWithArray",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> createSneakersWithArrayInput(@ApiParam(value = "List of sneaker object" ,required=true )  @Valid @RequestBody List<Sneaker> body);


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
    @RequestMapping(value = "/sneakers/{sneakerId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Sneaker> getSneakerById(@ApiParam(value = "ID of sneaker to return",required=true) @PathVariable("sneakerId") String sneakerId);

}
