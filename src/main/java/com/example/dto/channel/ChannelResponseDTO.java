package com.example.dto.channel;

import com.example.enums.ChannelStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelResponseDTO {
    private String id;
    private String name;
    private String photoId;
    private String description;
    private ChannelStatus status;
    private String bannerId;
    private Integer profileId;
}
