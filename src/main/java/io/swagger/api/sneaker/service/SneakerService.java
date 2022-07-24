package io.swagger.api.sneaker.service;

import io.swagger.api.sneaker.model.Sneaker;
import io.swagger.api.sneaker.repository.SneakerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SneakerService {

    private final SneakerRepository sneakerRepository;

    public SneakerService(SneakerRepository sneakerRepository) {
        this.sneakerRepository = sneakerRepository;
    }

    /*
          This methods transforms the SneakerDTO into domain Sneaker and saves the data.
         */
    public void saveSneakers(List<Sneaker> sneakers) {
        sneakers.forEach(sneakerRepository::save);
    }

    public List<Sneaker> getAllSneakers() {
        return sneakerRepository.findAll();
    }

    public Sneaker getSneakerById(String id) {
        return sneakerRepository.findById(id);
    }

    public void bootstrapData() {
        sneakerRepository.save(
                new Sneaker()
                        .id(UUID.randomUUID().toString())
                        .sneakerId("3a44fa13-bbae-4c54-a5ea-ea5a3dbbe90f")
                        .name("Tie-Dye (W)")
                        .photoUrls(List.of("https://images.stockx.com/images/Nike-Air-Zoom-Pegasus-37-Tie-Dye-W.jpg?fit=fill&bg=FFFFFF&w=700&h=500&fm=webp&auto=compress&trim=color&q=90&dpr=2&updated_at=1642460060"))
                        .brand("Nike")
                        .gender("women")
                        .retailPrice(125)
                        .releaseYear(2020)
        );
        sneakerRepository.save(
                new Sneaker()
                        .id(UUID.randomUUID().toString())
                        .sneakerId("48122403-7050-4ca9-8c6e-29f4d05429a3")
                        .name("Chalk Blue")
                        .photoUrls(List.of("https://images.stockx.com/images/Reebok-Classic-Leather-Legacy-Chalk-Blue.jpg?fit=fill&bg=FFFFFF&w=700&h=500&fm=webp&auto=compress&trim=color&q=90&dpr=2&updated_at=1657956089"))
                        .brand("Reebook")
                        .gender("men")
                        .retailPrice(80)
                        .releaseYear(2020)
        );
    }
}
