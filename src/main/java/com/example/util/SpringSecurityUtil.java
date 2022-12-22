package com.example.util;

import com.example.config.CustomUserDetailS;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityUtil {
    public CustomUserDetailS getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetailS customUserDetailS = (CustomUserDetailS) authentication.getPrincipal();
        return customUserDetailS;
    }
}
