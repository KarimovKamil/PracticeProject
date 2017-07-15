package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.dao.mappers.UserMapper;
import ru.itis.inform.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static final String SQL_FIND_ALL =
            "SELECT * FROM u_user;";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM u_user WHERE u_id = :id;";

    private static final String SQL_FIND_BY_LOGIN =
            "SELECT * FROM u_user WHERE login = :login;";

    private static final String SQL_FIND_BY_TOKEN =
            "SELECT * FROM u_user WHERE token = :token;";

    private static final String SQL_INSERT =
            "INSERT INTO u_user (login, hash_password, token, first_name, last_name, middle_name, role) " +
                    "VALUES (:login, :hashPassword, :token, :firstName, :lastName, :middleName, :role) " +
                    "RETURNING u_user.u_id;";

    private static final String SQL_UPDATE =
            "UPDATE u_user SET (login, hash_password, token, first_name, last_name, middle_name, role) " +
                    "= (:login, :hashPassword, :token, :firstName, :lastName, :middleName, :role) WHERE u_id = :id;";

    private static final String SQL_DELETE =
            "DELETE FROM u_user WHERE u_id = :id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> findAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new UserMapper());
    }

    public User findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return (User) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new UserMapper());
    }

    public User findByLogin(String login) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        return (User) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_LOGIN, params, new UserMapper());
    }

    public User findByToken(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return (User) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_TOKEN, params, new UserMapper());
    }

    public long insert(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", user.getLogin());
        params.put("hashPassword", user.getHashPassword());
        params.put("token", user.getToken());
        params.put("firstName", user.getFirstName());
        params.put("lastName", user.getLastName());
        params.put("middleName", user.getMiddleName());
        params.put("role", user.getRole());
        return namedParameterJdbcTemplate.queryForObject(SQL_INSERT, params, long.class);
    }

    public void update(User user, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("login", user.getLogin());
        params.put("hashPassword", user.getHashPassword());
        params.put("token", user.getToken());
        params.put("firstName", user.getFirstName());
        params.put("lastName", user.getLastName());
        params.put("middleName", user.getMiddleName());
        params.put("role", user.getRole());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
