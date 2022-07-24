package io.swagger.api.sneaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDTO {
    private String imageUrl;
    private String smallImageUrl;
    private String thumbUrl;
}
