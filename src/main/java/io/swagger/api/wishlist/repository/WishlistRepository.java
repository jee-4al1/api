package io.swagger.api.wishlist.repository;

import io.swagger.api.wishlist.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, String>{
    List<Wishlist> findAllByUserIdAndIsPurchasedFalse(String userId);
    Optional<Wishlist> findById(String wishlistId);
    List<Wishlist> findAllByUserId(String userId);
    int countAllByUserIdAndIsPurchasedTrue(String userId);

}
