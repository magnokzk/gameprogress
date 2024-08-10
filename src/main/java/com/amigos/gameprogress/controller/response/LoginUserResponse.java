package com.amigos.gameprogress.controller.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserResponse {

    private Long idUser;
    private String userName;
    private String nome;
    private String email;

}
