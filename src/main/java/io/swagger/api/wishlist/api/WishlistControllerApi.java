package io.swagger.api.wishlist.api;

import io.swagger.api.sneaker.model.Sneaker;
import io.swagger.api.sneaker.service.SneakerService;
import io.swagger.api.wishlist.model.Wishlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.wishlist.repository.WishlistRepositoryApiCustom;
import io.swagger.api.wishlist.service.WishlistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")

@Controller
public class WishlistControllerApi implements WishlistRepositoryApiCustom {

    private static final Logger log = LoggerFactory.getLogger(WishlistControllerApi.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final WishlistService wishlistService;

    private final SneakerService sneakerService;

    @org.springframework.beans.factory.annotation.Autowired
    public WishlistControllerApi(ObjectMapper objectMapper, HttpServletRequest request, WishlistService wishlistService, SneakerService sneakerService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.wishlistService = wishlistService;
        this.sneakerService = sneakerService;
    }

    public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist body) {
        try {
            return new ResponseEntity<>(wishlistService.saveWishlist(body), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Wishlist> addSneakersToWishlist(@ApiParam(value = "sneakers to add in the wishlist", required = true) @PathVariable(value = "wishlistId") String wishlistId, @RequestBody Sneaker body) {
        Wishlist wishlist = wishlistService.findById(wishlistId);
        if (wishlist != null) {
            Wishlist _wishlist = wishlist;
            Sneaker _sneaker = new Sneaker();

            if (body.getId() != "") {

                Sneaker sneaker = sneakerService.getSneakerById(body.getId());
                if (sneaker != null) {
                    _sneaker = sneaker;

                } else {
                    //TODO Exception
                }
            } else {
                _sneaker = sneakerService.saveSneaker(body);
            }
            _wishlist.addSneaker(_sneaker);
            Wishlist updated = wishlistService.saveWishlist(_wishlist);
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        }


        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    public ResponseEntity<List<Wishlist>> getUserWishlists(@ApiParam(value = "ID of user of whom to return the wishlist", required = true) @PathVariable("userId") String userId) {

        try {
            return new ResponseEntity<List<Wishlist>>(wishlistService.getUserAllWishlists(userId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<List<Wishlist>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public ResponseEntity<List<Wishlist>> getUserCurrentWishlist(@ApiParam(value = "ID of user of whom to return the wishlist", required = true) @PathVariable("userId") String userId) {

        try {
            return new ResponseEntity<List<Wishlist>>(wishlistService.getUserCurrentWishlist(userId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<List<Wishlist>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //TODO
    public ResponseEntity<Void> removeSneakerInWishlist(@ApiParam(value = "ID of the sneaker to be removed", required = true) @PathVariable("sneakerId") String sneakerId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Wishlist> purchaseWishlist(@ApiParam(value = "wishlist that need to be purchased", required = true) @PathVariable("wishlistId") String wishlistId, @ApiParam(value = "purchased Wishlist object", required = true) @Valid @RequestBody Wishlist body) {

        Wishlist wishlistData = wishlistService.findById(wishlistId);
        return new ResponseEntity<>(wishlistService.purchaseWishlist(wishlistData), HttpStatus.OK);
    }

    //TODO ajouter methode empechant l'ajout de la meme sneaker dans la meme wishlist
}
