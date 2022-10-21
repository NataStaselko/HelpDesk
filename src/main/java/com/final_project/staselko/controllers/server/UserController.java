package com.final_project.staselko.controllers.server;

import com.final_project.staselko.model.dto.UserDto;
import com.final_project.staselko.servise.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<UserDto> getUserById(@RequestParam(value = "email",required=true) String email) {
        UserDto userDto = userService.getUserByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }
}
