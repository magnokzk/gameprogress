package com.amigos.gameprogress.service.interfaces;

import java.util.Map;

public interface JwtTokenService {
    String generateToken(String subject, Map<String, Object> claims);
    String getTokenUsername(String authorization);
}
