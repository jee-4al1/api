package io.swagger.api.ranking.repository;

import io.swagger.api.ranking.model.Like;

import java.util.List;

public interface LikeRepository {
    void save(Like likeInfo);
    List<Like> findAllLikeByUserId(String userId);
    List<Like> findAllLikeBySneakerId(String sneakerId);
    List<Like> findAll();
    int likeCount(String sneakerId);
}
