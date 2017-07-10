package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.StudentDao;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Student> findAll() {
        return null;
    }

    public Student findById(long id) {
        return null;
    }

    public Student insert(Student Student) {
        return null;
    }

    public Student update(Student Student, long id) {
        return null;
    }

    public void delete(long id) {

    }
}
