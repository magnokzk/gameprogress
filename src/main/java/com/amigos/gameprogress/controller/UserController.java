package com.amigos.gameprogress.controller;

import com.amigos.gameprogress.controller.request.CreateUserRequest;
import com.amigos.gameprogress.controller.request.LoginUserRequest;
import com.amigos.gameprogress.controller.response.LoginUserResponse;
import com.amigos.gameprogress.controller.response.UserInfoResponse;
import com.amigos.gameprogress.service.implementations.UserServiceImpl;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody CreateUserRequest request) {
        log.info("Iniciando criação de usuário");
        Long userId = userService.createdUser(request);
        log.info("Finalizando criação de usuário");
        return ResponseEntity.ok(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> loginUser(@RequestBody LoginUserRequest request) {
        log.info("Iniciando processo de login");
        LoginUserResponse response = userService.loginUser(request);
        log.info("Finalizando processo de login");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info")
    public ResponseEntity<UserInfoResponse> getUserInfo(@RequestHeader("Authorization") String authorizationToken) {
        log.info("Iniciando busca de informações do usuário");
        UserInfoResponse response = userService.getUserInfoToken(authorizationToken);
        log.info("Finalizando busca de informações do usuário");
        return ResponseEntity.ok(response);
    }

}
