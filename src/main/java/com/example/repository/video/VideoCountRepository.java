package com.example.repository.video;

import com.example.entity.video.VideoCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoCountRepository extends JpaRepository<VideoCountEntity,Integer> {


    List<VideoCountEntity> findByVideoId(String id);
}
