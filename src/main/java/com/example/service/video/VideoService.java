package com.example.service.video;

import com.example.dto.entityDto.video.VideoCreateDto;
import com.example.entity.video.VideoEntity;
import com.example.repository.video.VideoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }


    public VideoCreateDto createVideo(VideoCreateDto createDto) {

        VideoEntity entity = new VideoEntity();

        entity.setCategoryId(createDto.getCategoryId());
        entity.setVideoId(createDto.getVideoId());
        entity.setChannelId(createDto.getChannelId());
        entity.setCreatedDate(LocalDateTime.now());
        entity.setPreviewAttachId(createDto.getPreviewAttachId());
        entity.setStatus(createDto.getStatus());
        entity.setTitle(createDto.getTitle());
        entity.setVideoType(createDto.getVideoType());

        videoRepository.save(entity);
        return createDto;
    }



}
