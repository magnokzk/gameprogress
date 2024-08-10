package com.amigos.gameprogress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "jogos", name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid_user")
    private Long idUser;

    @Column(name = "username")
    @NotNull
    private String userName;

    @Column(name = "password")
    @JsonIgnore
    @NotNull
    private String password;

    @Column(name = "nome_completo")
    @NotNull
    private String nomeCompleto;

    @Column(name = "data_nascimento")
    @NotNull
    private LocalDate dataNascimento;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        dataCriacao = now;
        dataAtualizacao = now;
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

}
