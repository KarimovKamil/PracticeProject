package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean userExistenceById(long id) {
        return jdbcTemplate.queryForObject(USER_BY_ID, Boolean.class, id);
    }

    public boolean userExistenceByToken(String token) {
        return jdbcTemplate.queryForObject(USER_BY_TOKEN, Boolean.class, token);
    }

    public boolean userExistenceByLogin(String login) {
        return jdbcTemplate.queryForObject(USER_BY_LOGIN, Boolean.class, login);
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
}
