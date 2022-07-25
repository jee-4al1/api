package io.swagger.api.shared.service;

import io.swagger.api.sneaker.model.Sneaker;
import io.swagger.api.sneaker.service.SneakerService;
import io.swagger.api.user.model.User;
import io.swagger.api.user.service.UserService;
import io.swagger.api.wishlist.model.Wishlist;
import io.swagger.api.wishlist.service.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    private final SneakerService sneakerService;
    private final UserService userService;
    private final WishlistService wishlistService;

    public DiscountService(SneakerService sneakerService, UserService userService, WishlistService wishlistService) {
        this.sneakerService = sneakerService;
        this.userService = userService;
        this.wishlistService = wishlistService;
    }

    /*
       This method should be called everytime
       On calcule le level de discount en fonction du nombre de wishlist qui ont déja été "purchased
       + le nombre de sneaker dans la wishlist actuelle
       un user est supposé n'avoir qu'une seule wishlist courrante (isPurchased = false)
     */
    public Sneaker computeSneakerPriceDiscounted(String userId, String sneakerId) {

        User user = userService.findById(userId);
        if(user != null) {
            int purchaseLevel = wishlistService.getPurchasedWishlistCountByUserId(userId);
            List<Wishlist> currentWishlist = wishlistService.getUserCurrentWishlist(userId);
            int wishlistLevel = currentWishlist.size();
            int level = purchaseLevel + wishlistLevel;
            Sneaker sneaker = sneakerService.getSneakerById(sneakerId);
            int price = sneaker.getRetailPrice();
            // Change the 3 magic number to the actual user level
            sneaker.setRetailPrice(computeLevelDiscount(level, price));
            return sneaker;
        } else {
            //TODO exception
            return null;
        }


    }

    private int computeLevelDiscount(int level, int price) {
        double discount = level * 0.05;
        return (int) Math.ceil(price * (1 - discount));
    }

}
