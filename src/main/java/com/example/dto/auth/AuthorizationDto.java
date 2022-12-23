package com.example.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorizationDto {

    private String email;

    private String password;
}
