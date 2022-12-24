package com.example.dto.entityDto.video;

import com.example.dto.attachDto.AttachDto;
import com.example.dto.entityDto.category.CategoryDto;
import com.example.dto.entityDto.channel.ChannelDto;
import com.example.entity.ChannelEntity;
import com.example.enums.video.VideoStatus;
import com.example.enums.video.VideoType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class VideoCreateDto {





    private String previewAttachId;
    private AttachDto previewAttach;


    private Integer categoryId;
    private CategoryDto category;


    private String videoId;
    private AttachDto video;



    private String channelId;
    private ChannelDto channel;



    private String title;



    private LocalDateTime createdDate;


    private LocalDateTime publishedDate;


    private VideoStatus status;



    private VideoType videoType;






}
