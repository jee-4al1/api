package io.swagger.api.service;

import io.swagger.api.sneaker.model.Sneaker;
import io.swagger.api.sneaker.service.SneakerService;
import org.springframework.stereotype.Service;

@Service
public class SneakerPriceService {

    private final SneakerService sneakerService;

    public SneakerPriceService(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    public Sneaker updateSneakerPriceBasedOnLikeCount(String sneakerId, int likeCount) {
        Sneaker sneaker = sneakerService.getSneakerById(sneakerId);
        int newPrice = computeSneakerPrice(likeCount, sneaker.getRetailPrice());
        sneaker.setRetailPrice(newPrice);
        sneakerService.saveSneaker(sneaker);
        return sneaker;
    }

    private int computeSneakerPrice(int likeCount, int price) {
        double newPrice = likeCount * 0.1;

        if(likeCount > 0) {
            return (int) Math.ceil(price * (1 + newPrice));
        } else {
            return (int) Math.ceil(price * (1 - newPrice));
        }
    }
}
