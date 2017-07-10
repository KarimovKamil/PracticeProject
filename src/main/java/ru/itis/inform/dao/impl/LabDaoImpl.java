package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.LabDao;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class LabDaoImpl implements LabDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Lab> findAll() {
        return null;
    }

    public Lab findById(long id) {
        return null;
    }

    public Lab insert(Lab Lab) {
        return null;
    }

    public Lab update(Lab Lab, long id) {
        return null;
    }

    public void delete(long id) {

    }
}
