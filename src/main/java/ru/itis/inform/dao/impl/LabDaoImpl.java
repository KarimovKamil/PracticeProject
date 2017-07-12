package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.LabDao;
import ru.itis.inform.dao.mappers.LabMapper;
import ru.itis.inform.model.Lab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class LabDaoImpl implements LabDao {

    private final static String SQL_FIND_ALL =
            "SELECT * FROM lab l INNER JOIN teacher t ON l.leader_id = t.t_id;";

    private final static String SQL_FIND_BY_ID =
            "SELECT * FROM lab l INNER JOIN teacher t ON l.leader_id = t.t_id WHERE l.lab_id = :id;";

    private final static String SQL_INSERT =
            "INSERT INTO lab (lab_name, leader_id, course) VALUES (:labName, :leaderId, :course);";

    private final static String SQL_UPDATE =
            "UPDATE lab l SET (lab_name, leader_id, course) = (:labName, :leaderId, :course) " +
                    "WHERE l.lab_id = :id;";

    private final static String SQL_DELETE =
            "DELETE FROM lab WHERE lab_id = :id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Lab> findAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new LabMapper());
    }

    public Lab findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return (Lab) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new LabMapper());
    }

    public void insert(Lab lab) {
        Map<String, Object> params = new HashMap<>();
        params.put("labName", lab.getName());
        params.put("course", lab.getCourse());
        params.put("leaderId", lab.getTeacher().getId());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    public void update(Lab lab, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("labName", lab.getName());
        params.put("course", lab.getCourse());
        params.put("leaderId", lab.getTeacher().getId());
        params.put("id", lab.getId());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
