package ru.itis.inform.controllers.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * 13.07.2017.
 *
 * @author Maxim Romanov
 */
public class HeaderCreator {

    public static HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
