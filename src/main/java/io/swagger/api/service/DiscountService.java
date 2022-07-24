package io.swagger.api.service;

import io.swagger.api.sneaker.model.Sneaker;
import io.swagger.api.sneaker.service.SneakerService;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    private final SneakerService sneakerService;

    public DiscountService(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    /*
       This method should be called everytime
     */
    public Sneaker computeSneakerPriceDiscounted(String userId, String sneakerId) {
        /*
           TODO:
              1. Get user from userService by userId
              2. Get user level
         */
        Sneaker sneaker = sneakerService.getSneakerById(sneakerId);
        int price = sneaker.getRetailPrice();
        sneaker.setRetailPrice(computeLevelDiscount(3, price));
        return sneaker;
    }

    private int computeLevelDiscount(int level, int price) {
        double discount = level * 0.1;
        return (int) Math.ceil(price * (1 - discount));
    }

}
