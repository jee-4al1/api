package io.swagger.api.ranking.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "snk_like")
@IdClass(LikePK.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @Column(name = "userId")
    private String userId;

    @Id
    @Column(name = "sneakerId")
    private String sneakerId;


    @Column(name = "isLiked")
    private boolean isLiked;



}
