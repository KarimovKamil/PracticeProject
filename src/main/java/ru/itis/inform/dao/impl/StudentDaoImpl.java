package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.StudentDao;
import ru.itis.inform.dao.mappers.StudentMapper;
import ru.itis.inform.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    private static final String SQL_FIND_ALL =
            "SELECT * FROM student_info student INNER JOIN u_user ON (student.user_id = u_user.u_id) " +
                    "INNER JOIN teacher ON (student.leader_id = teacher.t_id) INNER JOIN lab ON (student.lab_id = lab.lab_id)" +
                    "INNER JOIN elective ON (student.elective_id = elective.el_id) INNER JOIN practice ON (student.practice_id = practice.pr_id);";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM student_info student INNER JOIN u_user ON (student.user_id = u_user.u_id) " +
                    "INNER JOIN teacher ON (student.leader_id = teacher.t_id) INNER JOIN lab ON (student.lab_id = lab.lab_id)" +
                    "INNER JOIN elective ON (student.elective_id = elective.el_id) INNER JOIN practice ON (student.practice_id = practice.pr_id)" +
                    " WHERE student.st_id = :id;";

    private static final String SQL_INSERT =
            "INSERT INTO student_info (s_group, course, lab_id, elective_id, practice_id, leader_id, user_id) " +
                    "SELECT :group, :course, lab_id, el_id, pr_id, :leaderId, :userId FROM lab, elective, practice " +
                    "WHERE (lab.lab_name = :labName AND elective.el_name = :electiveName AND practice.pr_name = :practiceName);";

    private static final String SQL_UPDATE =
            "UPDATE student_info SET s_group = :group, course = :course, lab_id = query.lab_id, " +
                    "elective_id = query.el_id, practice_id = query.pr_id, leader_id = :leaderId, user_id = :userId " +
                    "FROM (SELECT lab.lab_id, elective.el_id, practice.pr_id FROM " +
                    "lab, elective, practice WHERE lab.lab_name = :labName AND elective.el_name = :electiveName " +
                    "AND practice.pr_name = :practiceName) AS query " +
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
        return (Student) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new StudentMapper());
    }

    public void insert(Student student) {
        Map<String, Object> params = new HashMap<>();
        params.put("group", student.getGroup());
        params.put("course", student.getCourse());
        params.put("labName", student.getLab());
        params.put("electiveName", student.getElective());
        params.put("practiceName", student.getPractice());
        params.put("leaderId", student.getTeacher().getId());
        params.put("userId", student.getuId());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);

    }

    public void update(Student student, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("group", student.getGroup());
        params.put("course", student.getCourse());
        params.put("labName", student.getLab());
        params.put("electiveName", student.getElective());
        params.put("practiceName", student.getPractice());
        params.put("leaderId", student.getTeacher().getId());
        params.put("userId", student.getuId());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
