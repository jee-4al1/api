package io.swagger.api.ranking.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.shared.dto.SneakerPriceUpdateDTO;
import io.swagger.api.ranking.model.Like;
import io.swagger.api.ranking.repository.LikeRepository;
import io.swagger.api.shared.service.RestWebClient;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

@Service
public class LikeService {

    private final ObjectMapper objectMapper;
    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository, ObjectMapper objectMapper) {
        this.likeRepository = likeRepository;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public void updateLike(Like likeInfo) {
        likeRepository.save(likeInfo);

        int likeCount = likeRepository.likeCount(likeInfo.getSneakerId());
        String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(new SneakerPriceUpdateDTO(likeInfo.getSneakerId(), likeCount));

        HttpResponse<String> response = new RestWebClient()
                 .uri("http://localhost:8080/v1/sneakers/updatePrice")
                 .headers(new HashMap<String, String>() {{
                     put("Content-Type", "application/json");
                 }})
                 .post(requestBody)
                 .retrieve();
        System.out.println(response.body());
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
