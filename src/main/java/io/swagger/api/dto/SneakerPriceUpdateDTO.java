package io.swagger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SneakerPriceUpdateDTO {
    private String sneakerId;
    private int likeCount;
}
