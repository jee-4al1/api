package io.swagger.api.ranking.service;

import io.swagger.api.ranking.model.Like;
import io.swagger.api.ranking.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public void updateLike(Like likeInfo) {
        likeRepository.save(likeInfo);
    }
    
    public List<Like> findLikeByUserId(String userId) {
        return likeRepository.findAllLikeByUserId(userId);
    }

    public List<Like> findLikeBySneakerId(String sneakerId) {
        return likeRepository.findAllLikeBySneakerId(sneakerId);
    }

    public List<Like> findAll() {
        return likeRepository.findAll();
    }
}
