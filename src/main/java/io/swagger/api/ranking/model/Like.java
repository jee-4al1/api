package io.swagger.api.ranking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Like {
    private String userId;
    private String sneakerId;
    private boolean isLiked;
}
