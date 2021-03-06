package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.ElectiveDao;
import ru.itis.inform.dao.interfaces.PracticeDao;
import ru.itis.inform.dao.interfaces.RequestDao;
import ru.itis.inform.dao.interfaces.StudentDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by artur on 10.07.2017.
 */
@Component
public class Validation {

    private static final String USER_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT u_id FROM u_user WHERE u_id = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String USER_BY_TOKEN =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT token FROM u_user WHERE token = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String USER_BY_LOGIN =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT login FROM u_user WHERE login = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String STUDENT_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT st_id FROM student_info WHERE st_id = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String ELECTIVE_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT el_id FROM elective WHERE el_id = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String LAB_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT lab_id FROM lab WHERE lab_id = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String PRACTICE_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT pr_id FROM practice WHERE pr_id = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String REQUEST_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT req_id FROM request WHERE req_id = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String TEACHER_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT t_id FROM teacher WHERE t_id = ?) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String REQUEST_STUDENT_BELONG =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT req_id FROM request WHERE req_id = :requestId " +
                    "AND student_id = :studentId) " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String PRACTICE_REQUEST_CHECK =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT * FROM practice, student_info WHERE practice_id = :practiceId " +
                    "AND student_info.course = practice.course AND student_info.st_id = :studentId " +
                    "AND practice.start_date > now() + 14 * INTERVAL '1 day') " +
                    "THEN TRUE ELSE FALSE END;";

    private static final String ELECTIVE_REQUEST_CHECK =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT * FROM elective, student_info WHERE elective_id = :electiveId " +
                    "AND student_info.course = elective.course AND student_info.st_id = :studentId ) " +
                    "THEN TRUE ELSE FALSE END;";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Validation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean userExistenceById(long id) {
        return jdbcTemplate.queryForObject(USER_BY_ID, Boolean.class, id);
    }

    public boolean userExistenceByToken(String token) {
        return jdbcTemplate.queryForObject(USER_BY_TOKEN, Boolean.class, token);
    }

    public boolean userExistenceByLogin(String login) {
        return jdbcTemplate.queryForObject(USER_BY_LOGIN, Boolean.class, login);
    }

    public boolean studentExistenceById(long id) {
        return jdbcTemplate.queryForObject(STUDENT_BY_ID, Boolean.class, id);
    }

    public boolean electiveExistenceById(long id) {
        return jdbcTemplate.queryForObject(ELECTIVE_BY_ID, Boolean.class, id);
    }

    public boolean labExistenceById(long id) {
        return jdbcTemplate.queryForObject(LAB_BY_ID, Boolean.class, id);
    }

    public boolean practiceExistenceById(long id) {
        return jdbcTemplate.queryForObject(PRACTICE_BY_ID, Boolean.class, id);
    }

    public boolean requestExistenceById(long id) {
        return jdbcTemplate.queryForObject(REQUEST_BY_ID, Boolean.class, id);
    }

    public boolean teacherExistenceById(long id) {
        return jdbcTemplate.queryForObject(TEACHER_BY_ID, Boolean.class, id);
    }

    public boolean practiceRequestCheck(long studentId, long practiceId) {
        Map<String, Object> params = new HashMap<>();
        params.put("practiceId", practiceId);
        params.put("studentId", studentId);
        return namedParameterJdbcTemplate.queryForObject(PRACTICE_REQUEST_CHECK, params, Boolean.class);
    }

    public boolean electiveRequestCheck(long studentId, long electiveId) {
        Map<String, Object> params = new HashMap<>();
        params.put("electiveId", electiveId);
        params.put("studentId", studentId);
        return namedParameterJdbcTemplate.queryForObject(ELECTIVE_REQUEST_CHECK, params, Boolean.class);
    }

    public boolean requestCheck(long requestId, long studentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("requestId", requestId);
        params.put("studentId", studentId);
        return namedParameterJdbcTemplate.queryForObject(REQUEST_STUDENT_BELONG, params, Boolean.class);
    }
}
