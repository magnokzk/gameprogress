package com.amigos.gameprogress.service.implementations;

import com.amigos.gameprogress.controller.request.CreateUserRequest;
import com.amigos.gameprogress.controller.request.LoginUserRequest;
import com.amigos.gameprogress.controller.response.LoginUserResponse;
import com.amigos.gameprogress.entity.UserEntity;
import com.amigos.gameprogress.exceptions.ExpectedException;
import com.amigos.gameprogress.repository.UserRepository;
import com.amigos.gameprogress.service.interfaces.UserService;
import com.amigos.gameprogress.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Long createdUser(CreateUserRequest request) {
        UserEntity userEntity = userRepository.save(
                mapCreateUserEntity(request)
        );
        return userEntity.getIdUser();
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) throws Exception {
        UserEntity userEntity = userRepository.findByUserName(request.userName)
                .orElseThrow(() -> new ExpectedException("user.notFound"));
        if(!HashUtil.verifyHash(request.password, userEntity.getPassword()))
            throw new ExpectedException("user.invalidPassword");
        return mapLoginUserReponse(userEntity);
    }

    private LoginUserResponse mapLoginUserReponse(UserEntity userEntity) {
        return LoginUserResponse.builder()
                .userName(userEntity.getUserName())
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
