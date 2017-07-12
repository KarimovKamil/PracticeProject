package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 10.07.2017.
 */
public class UserMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User.Builder()
                .uId(resultSet.getLong("u_id"))
                .login(resultSet.getString("login"))
                .hashPassword(resultSet.getString("hash_password"))
                .token(resultSet.getString("token"))
                .firstName(resultSet.getString("first_name"))
                .middleName(resultSet.getString("middle_name"))
                .lastName(resultSet.getString("last_name"))
                .role(resultSet.getString("role"))
                .build();
    }
}