package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.PracticeDao;
import ru.itis.inform.model.Practice;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class PracticeDaoImpl implements PracticeDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Practice> findAll() {
        return null;
    }

    public Practice findById(long id) {
        return null;
    }

    public Practice insert(Practice Practice) {
        return null;
    }

    public Practice update(Practice Practice, long id) {
        return null;
    }

    public void delete(long id) {

    }
}
