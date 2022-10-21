package com.final_project.staselko.controllers.server;

import com.final_project.staselko.converter.dto.UserConverter;
import com.final_project.staselko.converter.dto.impl.UserConverterImpl;
import com.final_project.staselko.model.dto.UserDto;
//import com.final_project.staselko.utils.entiti.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class SecurityController {
     private final UserConverter userConverter;
    // private final UserProvider userProvider;
    @PostMapping
    public ResponseEntity<UserDto> authUser() {
       // UserDto userDto = userConverter.toUserDto(userProvider.getCurrentUser());
        return null;//ResponseEntity.status(HttpStatus.OK).body(userDto);
    }
}
