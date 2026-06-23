package com.ict.user.controller;

import com.ict.user.common.response.ResponseModel;
import com.ict.user.domain.dto.UserRequestDto;
import com.ict.user.domain.dto.UserResponseDto;
import com.ict.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseModel createUser(@Valid @RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping("{id}")
    public ResponseModel getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/all")
    public ResponseModel getAllUser() {
        return userService.getAllUser();
    }

    @PutMapping("/update/{id}")
    public ResponseModel updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto requestDto) {
        return userService.updateUser(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseModel deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}
