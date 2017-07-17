package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.TeacherDao;
import ru.itis.inform.dao.mappers.TeacherMapper;
import ru.itis.inform.dto.TeacherDto;
import ru.itis.inform.models.Teacher;

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
            "INSERT INTO teacher (t_first_name, t_last_name, t_middle_name) " +
                    "VALUES (:firstName, :lastName, :middleName);";

    private static final String SQL_UPDATE =
            "UPDATE teacher SET (t_first_name, t_last_name, t_middle_name) = " +
                    "(:firstName, :lastName, :middleName) WHERE t_id = :id;";

    private static final String SQL_DELETE =
            "DELETE FROM teacher WHERE t_id = :id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Teacher> findAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new TeacherMapper());
    }

    public Teacher findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return (Teacher) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new TeacherMapper());
    }

    public void insert(TeacherDto teacherDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", teacherDto.getFirstName());
        params.put("lastName", teacherDto.getLastName());
        params.put("middleName", teacherDto.getMiddleName());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    public void update(TeacherDto teacherDto, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("firstName", teacherDto.getFirstName());
        params.put("lastName", teacherDto.getLastName());
        params.put("middleName", teacherDto .getMiddleName());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
