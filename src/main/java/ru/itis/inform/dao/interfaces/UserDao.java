package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.User;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface UserDao {

    List<User> findAll();

    User findById(long id);

    User findByLogin(String login);

    User findByToken(String token);

    void insert(User user);

    void update(User user, long id);

    void delete(long id);

}
