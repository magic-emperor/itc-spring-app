package com.itc.app.Security;

import java.security.Key;
import java.util.Base64;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class itcsecurityKeyGenerator {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Secret Key: " + key);
    }
}