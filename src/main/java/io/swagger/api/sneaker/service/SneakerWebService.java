package io.swagger.api.sneaker.service;

import io.swagger.api.sneaker.dto.SneakerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SneakerWebService {
    private final String API_URI = "https://v1-sneakers.p.rapidapi.com/v1";
    private final String GET_ALL_SNEAKERS = "/sneakers";
    private final int LIMIT = 30;
    private final String GENDER = "men,women";
    private int RELEASE_YEAR;
    public List<SneakerDTO> RetrieveSneakerFromApi(int releaseYear){
        this.RELEASE_YEAR = releaseYear;
        String URI = this.BuildUri();
        System.out.println(URI);
        // TODO implement here
        return List.of();
    }

    private String BuildUri() {
        return (API_URI +
                GET_ALL_SNEAKERS +
                "?limit=" +
                LIMIT +
                "&gender=" +
                GENDER +
                "&releaseYear=" +
                RELEASE_YEAR)
                .replace(",", "%2C");
    }

    /*
    new StringBuilder()
                .append(API_URI)
                .append(GET_ALL_SNEAKERS)
                .append("?limit=")
                .append(LIMIT)
                .append("&gender=")
                .append(GENDER)
                .append("&releaseYear=")
                .append(RELEASE_YEAR)
                .toString()
                .replace(",", "%2C");
     */


    /*
    Request request = new Request.Builder()
            .url("https://v1-sneakers.p.rapidapi.com/v1/sneakers?limit=50&gender=men%2Cwomen&releaseYear=2020")
            .get()
            .addHeader("X-RapidAPI-Key", "00265657dcmsh995dcc18b9ae3f6p18571fjsne33fce3b48f2")
            .addHeader("X-RapidAPI-Host", "v1-sneakers.p.rapidapi.com")
            .build();
    */

}
