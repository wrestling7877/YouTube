package com.example.dto.attachDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachDto {

    private String id;

    private String originalName;

    private Long size;

    private String extension;

    private String path;

    private Long duration;

    private String url;
}


