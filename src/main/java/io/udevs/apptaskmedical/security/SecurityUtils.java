package io.udevs.apptaskmedical.security;

import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@NoArgsConstructor
public final class SecurityUtils {
    public static Optional<String> getCurrentUserName(){
        SecurityContext securityContext  = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails){
                        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                        return userDetails.getUsername();
                    } else if (authentication.getPrincipal() instanceof  String){
                        return  (String) authentication.getPrincipal();
                    }
                    return null;
                });
    }
}
