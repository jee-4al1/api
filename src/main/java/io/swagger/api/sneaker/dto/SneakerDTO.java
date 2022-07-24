package io.swagger.api.sneaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SneakerDTO {
    private String sneakerId;
    private String name;
    private List<String> photoUrls;
    private String brand;
    private String gender;
    private int retailPrice;
    private int releaseYear;
}
