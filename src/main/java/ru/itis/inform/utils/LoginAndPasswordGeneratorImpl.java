package ru.itis.inform.utils;

import org.springframework.stereotype.Component;

/**
 * Created by Kamil Karimov on 15.07.2017.
 */
@Component
public class LoginAndPasswordGeneratorImpl implements LoginAndPasswordGenerator {
    @Override
    public String generateLogin(long studentId) {
        return "user" + studentId;
    }

    @Override
    public String generatePassword(long studentId) {
        return "user" + studentId + "pass";
    }
}
