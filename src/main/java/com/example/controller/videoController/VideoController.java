package com.example.controller.videoController;

import com.example.dto.entityDto.video.VideoCreateDto;
import com.example.service.video.VideoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "VideoController API", description = "Api list for VideoController")
@RestController
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    private ResponseEntity<VideoCreateDto> create(@RequestBody @Valid VideoCreateDto createDto) {

        VideoCreateDto result = videoService.createVideo(createDto);

        return ResponseEntity.ok(result);
    }

}
