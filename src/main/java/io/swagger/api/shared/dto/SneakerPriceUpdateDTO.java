package io.swagger.api.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SneakerPriceUpdateDTO {
    private String sneakerId;
    private int likeCount;
}
