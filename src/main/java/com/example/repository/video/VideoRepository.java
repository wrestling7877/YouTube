package com.example.repository.video;

import com.example.entity.video.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoEntity,String> {

}
