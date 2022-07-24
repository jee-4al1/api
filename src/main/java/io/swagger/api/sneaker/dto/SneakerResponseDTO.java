package io.swagger.api.sneaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SneakerResponseDTO {
    private int count;
    private List<SneakerDTO> results;
}
