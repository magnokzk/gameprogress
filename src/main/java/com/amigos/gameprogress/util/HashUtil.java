package com.amigos.gameprogress.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hashString(String string){
        return encoder.encode(string);
    }

    public static boolean verifyHash(String raw, String hash) {
        return encoder.matches(raw, hash);
    }

}
