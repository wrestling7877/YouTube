package com.example.service;

import com.example.enums.Language;
import com.example.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
@Slf4j
@Service
public class ResourceBundleService {

    @Autowired
    private ResourceBundleMessageSource messageSource;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AttachService attachService;
    @Autowired
    private EmailHistoryService emailHistoryService;

    @Autowired
    private MailService mailService;


    public String getMessage(String code, String lang) {
        return messageSource.getMessage(code, null, new Locale(lang));
    }

    public String getMessage(String code, Language lang, Object... arg) {
        return messageSource.getMessage(code, arg, new Locale(lang.name()));
    }
}
