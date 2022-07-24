package io.swagger.api.ranking.dto;

import lombok.Data;

@Data
public class LikeDTO {
    private String userId;
    private String sneakerId;
    private int isLiked;
}
