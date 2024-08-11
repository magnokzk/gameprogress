package com.amigos.gameprogress.service.interfaces;

import com.amigos.gameprogress.controller.request.CreateUserRequest;
import com.amigos.gameprogress.controller.request.LoginUserRequest;
import com.amigos.gameprogress.controller.response.LoginUserResponse;
import com.amigos.gameprogress.controller.response.UserInfoResponse;

public interface UserService {
    Long createdUser(CreateUserRequest request);
    LoginUserResponse loginUser(LoginUserRequest request);
    UserInfoResponse getUserInfoToken(String authorization);
}
