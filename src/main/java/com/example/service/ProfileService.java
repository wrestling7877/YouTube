package com.example.service;

import com.example.dto.entityDto.ProfileDto;
import com.example.entity.ProfileEntity;
import com.example.enums.Language;
import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import com.example.exp.ForbiddenException;
import com.example.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ResourceBundleService bundleService;

    public ProfileDto create (ProfileDto dto, Language language) {
        Optional<ProfileEntity> entityOptional = profileRepository.findById(dto.getId());
        log.warn("Profile not found id {}", dto);
        ProfileEntity entity = entityOptional.get();
        if (dto.getRole().equals(ProfileRole.ROLE_ADMIN)) {
            throw new ForbiddenException(bundleService.getMessage("credential.wrong" , language.name()));
        }
            entity.setRole(dto.getRole());
            entity.setStatus(ProfileStatus.ACTIVE);
            profileRepository.save(entity);
            return dto;

    }


    //update user (name , surname)
    public ProfileDto update (ProfileDto dto){
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        profileRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public String findAll(ProfileDto dto){
        List<ProfileEntity> all = profileRepository.findAll();
        List<ProfileDto> dtos = new ArrayList<>();
        for (ProfileEntity entity : all) {

        }


        return null;
    }

}
