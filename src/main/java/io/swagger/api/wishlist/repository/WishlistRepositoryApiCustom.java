package io.swagger.api.wishlist.repository;


import io.swagger.api.sneaker.model.Sneaker;
import io.swagger.api.wishlist.model.Wishlist;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")

@Validated
@Api(value = "wishlist", description = "the wishlist API")
@RequestMapping(value = "/v1")
public interface WishlistRepositoryApiCustom {

    @ApiOperation(value = "Create wishlist", nickname = "createWishlist", notes = "Only one wishlist NOT purchased by user", tags={ "wishlist", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/wishlist",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Wishlist> createWishlist(@ApiParam(value = "Created wishlist object" ,required=true )  @Valid @RequestBody Wishlist body);

    @ApiOperation(value = "Add sneakers to wishlist", nickname = "addSneakersToWishlist", notes = "", response = Wishlist.class, tags={ "wishlist", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Wishlist.class),
        @ApiResponse(code = 400, message = "Invalid data in the wishlist") })
    @RequestMapping(value = "/wishlist/{wishlistId}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Wishlist> addSneakersToWishlist(@ApiParam(value = "sneakers to add in the wishlist" ,required=true ) @PathVariable("wishlistId") String wishlistId, @Valid  @RequestBody Sneaker body);


    @ApiOperation(value = "Returns sneakers from user wishlist", nickname = "getUserWishlists", notes = "", response = Wishlist.class, responseContainer = "List", tags={ "wishlist", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Wishlist.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid user ID supplied"),
        @ApiResponse(code = 404, message = "Wishlist not found") })
    @RequestMapping(value = "/wishlist/{userId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Wishlist>> getUserWishlists(@ApiParam(value = "ID of user of whom to return the wishlist",required=true) @PathVariable("userId") String userId);

    @ApiOperation(value = "Returns sneakers from user current wishlist (not purchased, ther must be only one", nickname = "getUserCurentWishlist", notes = "", response = Wishlist.class, responseContainer = "List", tags={ "wishlist", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Wishlist.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Invalid user ID supplied"),
            @ApiResponse(code = 404, message = "Wishlist not found") })
    @RequestMapping(value = "/wishlist/current/{userId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Wishlist>> getUserCurrentWishlist(@ApiParam(value = "ID of user of whom to return the wishlist",required=true) @PathVariable("userId") String userId);



    @ApiOperation(value = "Removes a sneaker from the wishlist", nickname = "removeSneakerInWishlist", notes = "", tags={ "wishlist", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Sneaker not found") })
    @RequestMapping(value = "/wishlist/remove/{sneakerId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> removeSneakerInWishlist(@ApiParam(value = "ID of the sneaker to be removed",required=true) @PathVariable("wishlistId") String wishlistId);

    @ApiOperation(value = "Purchase wishlit", nickname = "purchaseWishlist", notes = "", tags={ "wishlist", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid wishlist supplied"),
            @ApiResponse(code = 404, message = "wishlist not found") })
    @RequestMapping(value = "/wishlist/purchase/{wishlistId}",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Wishlist> purchaseWishlist(@ApiParam(value = "wishlist that need to be updated",required=true) @PathVariable("wishlistId") String wishlistId, @ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody Wishlist body);

}
