package ru.itis.inform.dao.interfaces;

import ru.itis.inform.model.User;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface UserDao {

    List<User> findAll();

    User findById(long id);

    User insert(User User);

    User update(User User, long id);

    void delete(long id);

}
