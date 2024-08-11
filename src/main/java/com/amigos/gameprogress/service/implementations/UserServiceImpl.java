package com.amigos.gameprogress.service.implementations;

import com.amigos.gameprogress.controller.request.CreateUserRequest;
import com.amigos.gameprogress.controller.request.LoginUserRequest;
import com.amigos.gameprogress.controller.response.LoginUserResponse;
import com.amigos.gameprogress.controller.response.UserInfoResponse;
import com.amigos.gameprogress.entity.UserEntity;
import com.amigos.gameprogress.exceptions.ExpectedException;
import com.amigos.gameprogress.repository.UserRepository;
import com.amigos.gameprogress.service.interfaces.UserService;
import com.amigos.gameprogress.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtTokenServiceImpl jwtTokenService;

    @Override
    public Long createdUser(CreateUserRequest request) {
        UserEntity userEntity = userRepository.save(
                mapCreateUserEntity(request)
        );
        return userEntity.getIdUser();
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
        UserEntity userEntity = getUserEntityByUsername(request.getUserName());
        if(!HashUtil.verifyHash(request.getPassword(), userEntity.getPassword()))
            throw new ExpectedException("user.invalidPassword");
        return mapLoginUserReponse(userEntity, generateUserToken(userEntity));
    }

    @Override
    public UserInfoResponse getUserInfoToken(String authorization) {
        UserEntity userEntity = getUserEntityByUsername(jwtTokenService.getTokenUsername(authorization));
        return mapUserInfoResponse(userEntity);
    }

    private UserEntity getUserEntityByUsername(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new ExpectedException("user.notFound"));
    }

    private String generateUserToken(UserEntity userEntity) {
        return jwtTokenService.generateToken(userEntity.getUserName(), new HashMap<>());
    }

    private UserInfoResponse mapUserInfoResponse(UserEntity userEntity) {
        return UserInfoResponse.builder()
                .idUser(userEntity.getIdUser())
                .nomeCompleto(userEntity.getNomeCompleto())
                .userName(userEntity.getUserName())
                .email(userEntity.getEmail())
                .dataNascimento(userEntity.getDataNascimento())
                .dataCadastro(userEntity.getDataCriacao())
                .build();
    }

    private LoginUserResponse mapLoginUserReponse(UserEntity userEntity, String token) {
        return LoginUserResponse.builder()
                .userName(userEntity.getUserName())
                .token(token)
                .nome(userEntity.getNomeCompleto())
                .email(userEntity.getEmail())
                .idUser(userEntity.getIdUser())
                .build();
    }

    private UserEntity mapCreateUserEntity(CreateUserRequest request) {
        return UserEntity.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .nomeCompleto(request.getNome())
                .dataNascimento(LocalDate.parse(request.getDataNascimento()))
                .password(HashUtil.hashString(request.getPassword()))
                .build();
    }

}
