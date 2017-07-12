package ru.itis.inform.utils;

/**
 * Created by Kamil Karimov on 12.07.2017.
 */
public interface HashGenerator {

    String encode(String password);

    boolean match(String rawPassword, String encodedPassword);

}
