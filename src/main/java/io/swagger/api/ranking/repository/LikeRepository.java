package io.swagger.api.ranking.repository;

import io.swagger.api.ranking.model.Like;
import io.swagger.api.ranking.model.LikePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, LikePK> {
//    void save(Like likeInfo);
    List<Like> findAllLikeByUserId(String userId);
    List<Like> findAllLikeBySneakerId(String sneakerId);
    List<Like> findAll();
    int countLikesBySneakerId(String sneakerId);
//    int likeCount(String sneakerId);
}
