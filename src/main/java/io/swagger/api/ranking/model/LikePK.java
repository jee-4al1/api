package io.swagger.api.ranking.model;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class LikePK implements Serializable {

    private String userId;
    private String sneakerId;

    public LikePK() {

    }

    public LikePK(String userId, String sneakerId) {
        this.userId = userId;
        this.sneakerId = sneakerId;
    }

}
