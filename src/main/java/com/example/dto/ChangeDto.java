package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeDto {

    @Size(min = 6 , message = "")
    private String currentPassword;
    @Email
    private String email;
    @Size(min = 6 , message = "password min 6 bolishi kerak ")
    private String newPassword;
}
