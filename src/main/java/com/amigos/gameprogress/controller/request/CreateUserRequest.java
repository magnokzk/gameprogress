package com.amigos.gameprogress.controller.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    private String userName;
    private String password;
    private String nome;
    private String dataNascimento;
    private String email;

}
