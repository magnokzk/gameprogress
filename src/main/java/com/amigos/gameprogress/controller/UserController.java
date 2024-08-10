package com.amigos.gameprogress.controller;

import com.amigos.gameprogress.controller.request.CreateUserRequest;
import com.amigos.gameprogress.controller.request.LoginUserRequest;
import com.amigos.gameprogress.controller.response.LoginUserResponse;
import com.amigos.gameprogress.service.implementations.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createdUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> loginUser(@RequestBody LoginUserRequest request) throws Exception {
        return ResponseEntity.ok(userService.loginUser(request));
    }

}
