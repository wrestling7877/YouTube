package com.example.dto.entityDto;

import com.example.dto.attachDto.AttachDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDto {

    private Integer id;

    private String name;

    private String surname;

    @Email(message = "email is required")
    private String email;

    @NotBlank
    @Size(min = 6 ,message = "password should be longer then 6 ")
    private String password;

    private AttachDto attachDto;

}
