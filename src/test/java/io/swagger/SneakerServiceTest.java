package io.swagger;

import io.swagger.api.sneaker.model.Sneaker;
import io.swagger.api.sneaker.repository.InMemorySneakerRepository;
import io.swagger.api.sneaker.repository.SneakerRepository;
import io.swagger.api.sneaker.service.SneakerService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SneakerServiceTest {
    private final SneakerRepository sneakerRepository = new InMemorySneakerRepository();
    SneakerService sneakerService = new SneakerService(sneakerRepository);

    @Test
    public void bootstrapDataTest() {
        sneakerService.bootstrapData();
        List<Sneaker> data = sneakerRepository.findAll();
        assertEquals(2, data.size());
    }

}
