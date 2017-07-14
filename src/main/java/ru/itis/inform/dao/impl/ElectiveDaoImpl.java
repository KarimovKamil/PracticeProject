package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.ElectiveDao;
import ru.itis.inform.dao.mappers.ElectiveMapper;
import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.models.Elective;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class ElectiveDaoImpl implements ElectiveDao {

    private static final String SQL_FIND_ALL =
            "SELECT * FROM elective e INNER JOIN teacher t ON (e.leader_id = t.t_id);";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM elective e INNER JOIN teacher t ON (e.leader_id = t.t_id) WHERE el_id = :id;";

    private static final String SQL_INSERT =
            "INSERT INTO elective (el_name, leader_id, course) " +
                    "VALUES (:elName, :leaderId, :course);";

    private static final String SQL_UPDATE =
            "UPDATE elective SET (el_name, leader_id, course) " +
                    "= (:elName, :leaderId, :course) WHERE el_id = :id;";

    private static final String SQL_DELETE =
            "DELETE FROM elective WHERE el_id = :id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Elective> findAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new ElectiveMapper());
    }

    public Elective findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return (Elective) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new ElectiveMapper());    }

    public void insert(ElectiveDto electiveDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("elName", electiveDto.getName());
        params.put("leaderId", electiveDto.getTeacherId());
        params.put("course", electiveDto.getCourse());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    public void update(ElectiveDto electiveDto, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("elName", electiveDto.getName());
        params.put("leaderId", electiveDto.getTeacherId());
        params.put("course", electiveDto.getCourse());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
