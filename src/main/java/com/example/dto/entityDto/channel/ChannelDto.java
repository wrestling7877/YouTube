package com.example.dto.entityDto.channel;

import com.example.dto.attachDto.AttachDto;
import com.example.dto.entityDto.ProfileDto;
import com.example.entity.AttachEntity;
import com.example.entity.ProfileEntity;
import com.example.enums.ChannelStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChannelDto {

    private String id;


    private String name;


    private String photoId;
    private AttachDto photo;


    private String description;


    private ChannelStatus status;


    private String bannerId;
    private AttachDto banner;


    private Integer profileId;
    private ProfileDto profile;
}
