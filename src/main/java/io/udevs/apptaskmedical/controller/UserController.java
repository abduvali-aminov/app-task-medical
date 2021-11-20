package io.udevs.apptaskmedical.controller;

import io.udevs.apptaskmedical.dto.request.UserDto;
import io.udevs.apptaskmedical.entity.User;
import io.udevs.apptaskmedical.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody UserDto userDto){
        if (!userService.validatePassword(userDto.getPassword())){
            return new ResponseEntity<>("Password must be minimum 8 characters!", HttpStatus.BAD_REQUEST);
        }else if (userService.checkUsername(userDto.getUserName())){
            return new ResponseEntity<>("Username already exist!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(userDto));
    }
}
