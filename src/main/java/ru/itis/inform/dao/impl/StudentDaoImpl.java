package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.StudentDao;
import ru.itis.inform.dao.mappers.StudentMapper;
import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    private static final String SQL_FIND_ALL =
            "SELECT * FROM student_info s " +
                    "INNER JOIN u_user u ON (s.user_id = u.u_id) " +
                    "INNER JOIN teacher t ON (s.leader_id = t.t_id) " +
                    "INNER JOIN lab l ON (s.lab_id = l.lab_id)" +
                    "INNER JOIN elective e ON (s.elective_id = e.el_id) " +
                    "INNER JOIN practice p ON (s.practice_id = p.pr_id);";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM student_info s " +
                    "INNER JOIN u_user u ON (s.user_id = u.u_id) " +
                    "INNER JOIN teacher t ON (s.leader_id = t.t_id) " +
                    "INNER JOIN lab l ON (s.lab_id = l.lab_id)" +
                    "INNER JOIN elective e ON (s.elective_id = e.el_id) " +
                    "INNER JOIN practice p ON (s.practice_id = p.pr_id)" +
                    "WHERE s.st_id = :id;";

    private static final String SQL_FIND_BY_TOKEN =
            "SELECT * FROM student_info s " +
                    "INNER JOIN u_user u ON (s.user_id = u.u_id) " +
                    "INNER JOIN teacher t ON (s.leader_id = t.t_id) " +
                    "INNER JOIN lab l ON (s.lab_id = l.lab_id)" +
                    "INNER JOIN elective e ON (s.elective_id = e.el_id) " +
                    "INNER JOIN practice p ON (s.practice_id = p.pr_id) " +
                    "WHERE u.token = :token;";

    private static final String SQL_INSERT =
            "INSERT INTO student_info (s_group, course, lab_id, elective_id, practice_id, leader_id, user_id) " +
                    "VALUES (:group, :course, :labId, :elId, :prId, :leaderId, :userId);";

    private static final String SQL_UPDATE =
            "UPDATE student_info SET (s_group, course, lab_id, elective_id, practice_id, leader_id)" +
                    " = (:group, :course, :labId, :elId, :prId, :leaderId) " +
                    "WHERE st_id = :id;";

    private static final String SQL_DELETE =
            "DELETE FROM student_info WHERE st_id = :id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Student> findAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new StudentMapper());
    }

    public Student findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        Student student = (Student) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new StudentMapper());
        return student;
    }

    public Student findByToken(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return (Student) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_TOKEN, params, new StudentMapper());
    }

    public void insert(Student student) {
        Map<String, Object> params = new HashMap<>();
        params.put("group", student.getGroup());
        params.put("course", student.getCourse());
        params.put("leaderId", student.getTeacher().getId());
        params.put("userId", student.getuId());
        params.put("labId", student.getLabId());
        params.put("elId", student.getElectiveId());
        params.put("prId", student.getPracticeId());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);

    }

    public void update(Student student, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("group", student.getGroup());
        params.put("course", student.getCourse());
        params.put("leaderId", student.getTeacher().getId());
        params.put("labId", student.getLabId());
        params.put("elId", student.getElectiveId());
        params.put("prId", student.getPracticeId());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
