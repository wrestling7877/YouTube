package com.example.dto.entityDto;

import com.example.dto.attachDto.AttachDto;
import com.example.enums.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDto {

    private Integer id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private AttachDto attachDto;

    private ProfileRole role;

    private Boolean visible;
}
