package com.example.service;



import com.example.dto.ChangeDto;
import com.example.dto.entityDto.ProfileDto;
import com.example.entity.ProfileEntity;
import com.example.enums.Language;
import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import com.example.exp.IncorrectEmailOrPassword;
import com.example.exp.ItemNotFoundException;
import com.example.repository.ProfileRepository;
import com.example.util.Md5Util;
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
//        if (dto.getRole().equals(ProfileRole.ROLE_ADMIN)) {
//            throw new ForbiddenException(bundleService.getMessage("credential.wrong" , language.name()));
//        }
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
    public ProfileDto toDTO(ProfileEntity entity){
        ProfileDto dto = new ProfileDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public String updatePassword( ChangeDto dto, Language language){
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndPassword(dto.getEmail(), dto.getCurrentPassword());
        if (optional.isEmpty()) {
            throw new IncorrectEmailOrPassword(bundleService.getMessage("credential.wrong", language.name()));
        }
        ProfileEntity entity = optional.get();
        entity.setPassword(dto.getNewPassword());
        profileRepository.save(entity);
        return "Successfully changed";
    }



    public String updateEmail (ProfileDto dto, Language language){
        Optional<ProfileEntity> optional = profileRepository.findByEmail(dto.getEmail());
        if (optional.isPresent()){
            throw new ItemNotFoundException(bundleService.getMessage("credential.wrong", language.name()));
        }
        ProfileEntity entity = optional.get();
        entity.setEmail(dto.getEmail());
        profileRepository.save(entity);
        return "Successfully email updated";

    }


    public ProfileDto createUser(ProfileDto dto, Language language){
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setPassword(Md5Util.encode(dto.getPassword()));
        entity.setRole(ProfileRole.ROLE_USER);
        entity.setStatus(ProfileStatus.NOT_ACTIVE);
        entity.setVisible(true);
        profileRepository.save(entity);
        return dto;
    }


}
