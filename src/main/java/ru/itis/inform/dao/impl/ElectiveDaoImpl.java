package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.ElectiveDao;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class ElectiveDaoImpl implements ElectiveDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Elective> findAll() {
        return null;
    }

    public Elective findById(long id) {
        return null;
    }

    public Elective insert(Elective elective) {
        return null;
    }

    public Elective update(Elective elective, long id) {
        return null;
    }

    public void delete(long id) {

    }
}
