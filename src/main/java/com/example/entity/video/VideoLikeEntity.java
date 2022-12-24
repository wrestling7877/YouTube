package com.example.entity.video;

import com.example.entity.AttachEntity;
import com.example.enums.video.VideoLike;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "video_like")
public class VideoLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private VideoLike status;


    @Column(name = "video_id")
    private String videoId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", insertable = false, updatable = false)
    private AttachEntity video;

}
