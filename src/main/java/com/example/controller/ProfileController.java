package com.example.controller;

import com.example.dto.entityDto.ProfileDto;
import com.example.enums.Language;
import com.example.service.ProfileService;
import com.example.service.ResourceBundleService;
import com.example.util.SpringSecurityUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@Tag(name = "ProfileController API", description = "Api list for ProfileController")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private SpringSecurityUtil details;
    @Autowired
    private ResourceBundleService resourceBundleService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create_user")
    public ResponseEntity<?> create (@RequestBody @Valid ProfileDto dto,
                                     @RequestHeader(value = "Accept-Language", defaultValue = "UZ") Language language){
        ProfileDto profileDto = profileService.create(dto , language);
        return ResponseEntity.ok(profileDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/update_user")
    public ResponseEntity<?> update(@RequestBody ProfileDto dto ,
                                    @RequestHeader(value = "Accept-Language", defaultValue = "UZ") Language language){
        ProfileDto update = profileService.update(dto);
        return ResponseEntity.ok(update);
    }

}
