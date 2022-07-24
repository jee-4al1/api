package io.swagger.api.sneaker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.sneaker.dto.SneakerResponseDTO;
import io.swagger.api.sneaker.model.Sneaker;
import lombok.SneakyThrows;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.*;

@Service
public class SneakerWebService {
    private final ObjectMapper objectMapper;

    private final Environment env;

    public SneakerWebService(ObjectMapper objectMapper, Environment env) {
        this.objectMapper = objectMapper;
        this.env = env;
    }

    @SneakyThrows
    public List<Sneaker> retrieveSneakerFromApi(int releaseYear){

        HttpResponse<String> response = new RestWebClient()
                        .uri(this.buildUri(releaseYear))
                        .headers(new HashMap<>(){
                            {
                                put("X-RapidAPI-Key", env.getProperty("X-RapidAPI-Key"));
                                put("X-RapidAPI-Host", env.getProperty("X-RapidAPI-Host"));
                            }
                        })
                        .get()
                        .retrieve();

        // Convert the response to a SneakerResponseDTO
        SneakerResponseDTO data = objectMapper.readValue(response.body(), SneakerResponseDTO.class);

        //Retrieve each sneakers from SneakerResponseDTO and convert them to Sneaker objects
        List<Sneaker> sneakersList = new ArrayList<>();
        data.getResults()
                .forEach(sneakerDTO ->
                        sneakersList.add(
                                new Sneaker()
                                        .id(UUID.randomUUID().toString())
                                        .sneakerId(sneakerDTO.getId())
                                        .name(sneakerDTO.getName())
                                        .addPhotoUrlsItem(sneakerDTO.getMedia().getImageUrl())
                                        .addPhotoUrlsItem(sneakerDTO.getMedia().getSmallImageUrl())
                                        .addPhotoUrlsItem(sneakerDTO.getMedia().getThumbUrl())
                                        .brand(sneakerDTO.getBrand())
                                        .gender(sneakerDTO.getGender())
                                        .retailPrice(sneakerDTO.getRetailPrice())
                                        .releaseYear(sneakerDTO.getYear())
                )
        );

        return sneakersList;
    }

    private String buildUri(int releaseYear) {
        String apiUri = "https://v1-sneakers.p.rapidapi.com/v1";
        String getAllSneakersEndpoint = "/sneakers";
        int limit = 20;
        String gender = "men,women";

        return (apiUri +
                getAllSneakersEndpoint +
                "?limit=" +
                limit +
                "&gender=" +
                gender +
                "&releaseYear=" +
                releaseYear)
                .replace(",", "%2C");
    }
}
