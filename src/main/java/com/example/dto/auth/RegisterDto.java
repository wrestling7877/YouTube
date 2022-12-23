package com.example.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDto {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email
    private String email;

    private String photoId;

    @NotBlank
    private String password;

}
