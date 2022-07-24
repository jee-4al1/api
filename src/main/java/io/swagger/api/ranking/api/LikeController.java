package io.swagger.api.ranking.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.api.ranking.dto.LikeDTO;
import io.swagger.api.ranking.model.Like;
import io.swagger.api.ranking.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "like")
@RestController
@RequestMapping("/v1/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<Void> updateLike(@ApiParam(value = "Like information : userId, sneakerId, like or dislike." ,required=true )  @RequestBody LikeDTO likeDTO) {
        boolean isLiked = likeDTO.getIsLiked() != 0;
        Like likeInfo = new Like(likeDTO.getUserId(), likeDTO.getSneakerId(), isLiked);
        likeService.updateLike(likeInfo);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Like>> findLikeByUserId(@ApiParam(value = "User id",required=true) @PathVariable("userId") String userId) {
        List<Like> likeInfo = likeService.findLikeByUserId(userId);
        return new ResponseEntity<List<Like>>(likeInfo, HttpStatus.OK);
    }

    @GetMapping("/sneaker/{sneakerId}")
    public ResponseEntity<List<Like>> findLikeBySneakerId(@ApiParam(value = "Sneaker id",required=true) @PathVariable("sneakerId") String sneakerId) {
        List<Like> likeInfo = likeService.findLikeBySneakerId(sneakerId);
        return new ResponseEntity<List<Like>>(likeInfo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Like>> findAll() {
        List<Like> likes = likeService.findAll();
        return new ResponseEntity<List<Like>>(likes, HttpStatus.OK);
    }
}
