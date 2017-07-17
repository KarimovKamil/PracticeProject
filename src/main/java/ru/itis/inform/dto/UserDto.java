package ru.itis.inform.dto;

/**
 * Created by Yoko on 17.07.2017.
 */
public class UserDto implements Data {
    private long id;
    private String token;

    public UserDto() {
    }

    public UserDto(long id, String token) {
        this.id = id;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
