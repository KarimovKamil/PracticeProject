package ru.itis.inform.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Yoko on 16.07.2017.
 */
public class PermissionException extends AuthenticationException {
    public PermissionException(String msg) {
        super(msg);
    }
}
