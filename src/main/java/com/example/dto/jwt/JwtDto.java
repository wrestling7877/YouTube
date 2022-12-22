package com.example.dto.jwt;

import com.example.enums.ProfileRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtDto {
    private Integer id;

    private ProfileRole role;

    private String username;



    public JwtDto(Integer id, ProfileRole role, String username) {
        this.id = id;
        this.role = role;
        this.username = username;
    }



}
