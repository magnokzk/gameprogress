package com.amigos.gameprogress.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserRequest {

    public String userName;
    public String password;

}
