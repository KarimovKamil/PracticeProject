package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.TeacherDao;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Teacher> findAll() {
        return null;
    }

    public Teacher findById(long id) {
        return null;
    }

    public Teacher insert(Teacher Teacher) {
        return null;
    }

    public Teacher update(Teacher Teacher, long id) {
        return null;
    }

    public void delete(long id) {

    }
}
