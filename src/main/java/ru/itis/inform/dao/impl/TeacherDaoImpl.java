package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.TeacherDao;
import ru.itis.inform.model.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class TeacherDaoImpl implements TeacherDao {

    private static final String SQL_FIND_ALL =
            "SELECT * FROM teacher;";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM teacher WHERE t_id = :id;";

    private static final String SQL_INSERT =
            "INSERT INTO teacher (t_first_name, t_last_name, t_middle_name) VALUES (:name, :lastName, :middleName);";

    private static final String SQL_UPDATE =
            "UPDATE teacher SET (t_first_name, t_last_name, t_middle_name) = (:name, :lastName, :middleName) WHERE t_id = :id;";

    private static final String SQL_DELETE =
            "DELETE FROM teacher WHERE t_id = :id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Teacher> findAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new TeacherMapper());
    }

    public void findById(long id) {
        return namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, new TeacherMapper());
    }

    public void insert(Teacher teacher) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", teacher.getFirstName());
        params.put("lastName", teacher.getLastName());
        params.put("middleName", teacher.getMiddleName());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    public void update(Teacher teacher, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", teacher.getFirstName());
        params.put("lastName", teacher.getLastName());
        params.put("middleName", teacher.getMiddleName());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
