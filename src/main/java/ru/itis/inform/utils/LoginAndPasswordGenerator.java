package ru.itis.inform.utils;

/**
 * Created by Kamil Karimov on 15.07.2017.
 */
public interface LoginAndPasswordGenerator {

    String generateLogin(long studentId);

    String generatePassword(long studentId);
}
