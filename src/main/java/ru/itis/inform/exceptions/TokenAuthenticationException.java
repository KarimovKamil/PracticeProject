package ru.itis.inform.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Yoko on 16.07.2017.
 */
public class TokenAuthenticationException extends AuthenticationException {
    public TokenAuthenticationException(String msg) {
        super(msg);
    }
}
