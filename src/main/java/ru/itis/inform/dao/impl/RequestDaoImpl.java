package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.RequestDao;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class RequestDaoImpl implements RequestDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Request> findAll() {
        return null;
    }

    public Request findById(long id) {
        return null;
    }

    public Request insert(Request Request) {
        return null;
    }

    public Request update(Request Request, long id) {
        return null;
    }

    public void delete(long id) {

    }
}
