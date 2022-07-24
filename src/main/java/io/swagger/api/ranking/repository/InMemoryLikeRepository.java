package io.swagger.api.ranking.repository;
import io.swagger.api.ranking.model.Like;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryLikeRepository implements  LikeRepository {
    private final Map<String, Like> data = new ConcurrentHashMap<>();

    @Override
    public void save(Like likeInfo) {
        data.put(likeInfo.getUserId() + likeInfo.getSneakerId(), likeInfo);
    }

    @Override
    public List<Like> findAllLikeByUserId(String userId) {
        return data.values().stream().filter(like -> like.getUserId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public List<Like> findAllLikeBySneakerId(String sneakerId) {
        return data.values().stream().filter(like -> like.getSneakerId().equals(sneakerId)).collect(Collectors.toList());
    }

    public List<Like> findAll() {
        return List.copyOf(data.values());
    }
}
