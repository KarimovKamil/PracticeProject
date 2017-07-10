package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.model.User;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> findAll() {
        return null;
    }

    public User findById(long id) {
        return null;
    }

    public User insert(User User) {
        return null;
    }

    public User update(User User, long id) {
        return null;
    }

    public void delete(long id) {

    }
}
