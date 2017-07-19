package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.RequestDao;
import ru.itis.inform.dao.mappers.RequestMapper;
import ru.itis.inform.models.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Repository
public class RequestDaoImpl implements RequestDao {

    private static final String SQL_FIND_ALL =
            "SELECT * FROM request r INNER JOIN student_info s ON (r.student_id = s.st_id) " +
                    "INNER JOIN u_user u ON (u.u_id = s.user_id);";

    private static final String SQL_FIND_ALL_ACTIVE =
            "SELECT * FROM request r INNER JOIN student_info s ON (r.student_id = s.st_id) " +
                    "INNER JOIN u_user u ON (u.u_id = s.user_id) " +
                    "WHERE r.req_status = 'ACTIVE';";

    private static final String SQL_FIND_ALL_LAB_REQ =
            "SELECT * FROM request r INNER JOIN student_info s ON (r.student_id = s.st_id) " +
                    "INNER JOIN u_user u ON (u.u_id = s.user_id) " +
                    "WHERE r.req_type = 'LAB';";

    private static final String SQL_FIND_ALL_ELECTIVE_REQ =
            "SELECT * FROM request r INNER JOIN student_info s ON (r.student_id = s.st_id) " +
                    "INNER JOIN u_user u ON (u.u_id = s.user_id) " +
                    "WHERE r.req_type = 'ELECTIVE';";

    private static final String SQL_FIND_ALL_PRACTICE_REQ =
            "SELECT * FROM request r INNER JOIN student_info s ON (r.student_id = s.st_id) " +
                    "INNER JOIN u_user u ON (u.u_id = s.user_id) " +
                    "WHERE r.req_type = 'PRACTICE';";

    private static final String SQL_FIND_ALL_LEADER_REQ =
            "SELECT * FROM request r INNER JOIN student_info s ON (r.student_id = s.st_id) " +
                    "INNER JOIN u_user u ON (u.u_id = s.user_id) " +
                    "WHERE r.req_type = 'LEADER';";

    private static final String SQL_FIND_ALL_STUDENT_REQ =
            "SELECT * FROM request r INNER JOIN student_info s ON (r.student_id = s.st_id) " +
                    "INNER JOIN u_user u ON (u.u_id = s.user_id) " +
                    "WHERE u.token = :token;";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM request r INNER JOIN student_info s ON (r.student_id = s.st_id) " +
                    "INNER JOIN u_user u ON (u.u_id = s.user_id) " +
                    "WHERE req_id = :id;";

    private static final String SQL_INSERT =
            "INSERT INTO request (req_message, req_date, student_id, req_type, attribute_id) " +
                    "VALUES (:reqMessage, :reqDate, :studentId, :reqType, :attributeId);";

    private static final String SQL_UPDATE =
            "UPDATE request SET (req_message, res_message, req_status) " +
                    "= (:reqMessage, :resMessage, :reqStatus) WHERE req_id = :id;";

    private static final String SQL_DELETE =
            "DELETE FROM request WHERE req_id = :id;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Request> findAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new RequestMapper());
    }

    public List<Request> findAllActive() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_ACTIVE, new RequestMapper());
    }

    public List<Request> findAllLabReq() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_LAB_REQ, new RequestMapper());
    }

    public List<Request> findAllElectiveReq() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_ELECTIVE_REQ, new RequestMapper());
    }

    public List<Request> findAllPracticeReq() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_PRACTICE_REQ, new RequestMapper());
    }

    public List<Request> findAllLeaderReq() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_LEADER_REQ, new RequestMapper());
    }

    public List<Request> findAllStudentReq(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return namedParameterJdbcTemplate.query(SQL_FIND_BY_ID, params, new RequestMapper());
    }

    public Request findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return (Request) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new RequestMapper());
    }

    public void insert(Request request) {
        Map<String, Object> params = new HashMap<>();
        params.put("reqMessage", request.getReqMessage());
        params.put("reqDate", request.getDate());
        params.put("studentId", request.getStudent().getuId());
        params.put("reqType", request.getType());
        params.put("attributeId", request.getAttributeId());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    public void update(Request request, long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("reqMessage", request.getReqMessage());
        params.put("resMessage", request.getResMessage());
        params.put("reqStatus", request.getStatus());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    public void delete(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }
}
