package com.final_project.staselko.utils.entiti;

import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.security.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserProvider {

    public User getCurrentUser() {
        return ((UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getUser();
    }
}
