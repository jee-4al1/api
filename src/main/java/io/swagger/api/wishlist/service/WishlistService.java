package io.swagger.api.wishlist.service;

import io.swagger.api.wishlist.model.Wishlist;
import io.swagger.api.wishlist.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Wishlist saveWishlist(Wishlist wishlist){

        return wishlistRepository.save(wishlist);
    }

    public Wishlist findById(String wishlistId){

        return wishlistRepository.findById(wishlistId).orElse(null);
    }

    public List<Wishlist> getUserCurrentWishlist(String userId){

        return wishlistRepository.findAllByUserIdAndIsPurchasedFalse(userId);
    }

    public List<Wishlist> getUserAllWishlists(String userId){

        return wishlistRepository.findAllByUserId(userId);
    }

    public Wishlist purchaseWishlist(Wishlist wishlist){
        wishlist.setIsPurchased(true);

        return wishlistRepository.save(wishlist);
    }

    public int getPurchasedWishlistCountByUserId(String userId){
        return wishlistRepository.countAllByUserIdAndIsPurchasedTrue(userId);
    }
}
