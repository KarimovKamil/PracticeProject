package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.PracticeDao;
import ru.itis.inform.dao.mappers.PracticeMapper;
import ru.itis.inform.dto.PracticeDto;
import ru.itis.inform.models.Practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class PracticeDaoImpl implements PracticeDao {

    private static final String SQL_FIND_ALL =
            "SELECT * FROM practice p INNER JOIN teacher t ON (p.leader_id = t.t_id);";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM practice p INNER JOIN teacher t ON (p.leader_id = t.t_id) WHERE pr_id = :id;";

    private static final String SQL_INSERT =
            "INSERT INTO practice (pr_name, start_date, end_date, leader_id, course) " +
                    "VALUES (:prName, :startDate, :endDate, :leaderId, :course);";

    private static final String SQL_UPDATE =
            "UPDATE practice SET (pr_name, start_date, end_date, leader_id, course) " +
                    "= (:prName, :startDate, :endDate, :leaderId, :course) WHERE pr_id = :id;";

    private static final String SQL_DELETE =
            "DELETE FROM practice WHERE pr_id = :id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Practice> findAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new PracticeMapper());
    }

    public Practice findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return (Practice) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new PracticeMapper());    }

    public void insert(PracticeDto practiceDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("prName", practiceDto.getName());
        params.put("startDate", practiceDto.getStartDate());
        params.put("endDate", practiceDto.getEndDate());
        params.put("leaderId", practiceDto.getTeacherId());
        params.put("course", practiceDto.getCourse());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    public void update(PracticeDto practiceDto, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("prName", practiceDto.getName());
        params.put("startDate", practiceDto.getStartDate());
        params.put("endDate", practiceDto.getEndDate());
        params.put("leaderId", practiceDto.getTeacherId());
        params.put("course", practiceDto.getCourse());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
