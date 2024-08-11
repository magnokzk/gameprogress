package com.amigos.gameprogress.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserRequest {

    private String userName;
    private String password;

}
