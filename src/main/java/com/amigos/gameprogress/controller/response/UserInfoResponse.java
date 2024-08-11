package com.amigos.gameprogress.controller.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoResponse {

    private Long idUser;
    private String userName;
    private String nomeCompleto;
    private String email;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;

}
