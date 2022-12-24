package com.example.entity.video;

import com.example.entity.AttachEntity;
import com.example.entity.CategoryEntity;
import com.example.entity.ChannelEntity;
import com.example.enums.video.VideoStatus;
import com.example.enums.video.VideoType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "video ")
public class VideoEntity {

//    id(uuid), preview_attach_id,title,category_id,attach_id,created_date,published_date,
//    status(private,public),
//    type(video,short),view_count,shared_count,description,channel_id,(like_count,dislike_count),

    @Id
    @GeneratedValue(generator = "generator_uuid")
    @GenericGenerator(name = "generator_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    @Column(name = "preview_attach_id")
    private String previewAttachId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preview_attach_id", insertable = false, updatable = false)
    private AttachEntity previewAttach;


    @Column(name = "category_id")
    private Integer categoryId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;


    @Column(name = "video_id")
    private String videoId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", insertable = false, updatable = false)
    private AttachEntity video;



    @Column(name = "channel_id")
    private String channelId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id", insertable = false, updatable = false)
    private ChannelEntity channel;


    @Column
    private String title;


    @Column
    private LocalDateTime createdDate;


    @Column
    private LocalDateTime publishedDate;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VideoStatus status;


    @Enumerated(EnumType.STRING)
    @Column(name = "video_type")
    private VideoType videoType;


    @Column(name = "view_count")
    private Long viewCount;


    @Column(name = "shared_count")
    private Long sharedCount;

    @Column(name = "like_count")
    private Long likeCount;


    @Column(name = "dislike_count")
    private Long dislikeCount;


}
