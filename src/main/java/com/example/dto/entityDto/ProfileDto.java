package com.example.dto.entityDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
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

}
