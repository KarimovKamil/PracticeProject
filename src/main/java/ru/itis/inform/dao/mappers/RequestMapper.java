package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Request;
import ru.itis.inform.models.Student;
import ru.itis.inform.models.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 10.07.2017.
 */
public class RequestMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = (Student) new Student.Builder()
                .id(resultSet.getLong("st_id"))
                .group(resultSet.getString("s_group"))
                .course(resultSet.getInt("course"))
                .uId(resultSet.getLong("u_id"))
                .login(resultSet.getString("login"))
                .hashPassword(resultSet.getString("hash_password"))
                .token(resultSet.getString("token"))
                .firstName(resultSet.getString("first_name"))
                .middleName(resultSet.getString("middle_name"))
                .lastName(resultSet.getString("last_name"))
                .role(resultSet.getString("role"))
                .build();
        return new Request.Builder()
                .id(resultSet.getLong("req_id"))
                .reqMessage(resultSet.getString("req_message"))
                .resMessage(resultSet.getString("res_message"))
                .date(resultSet.getDate("req_date"))
                .student(student)
                .type(resultSet.getString("req_type"))
                .attributeId(resultSet.getLong("attribute_id"))
                .status(resultSet.getString("req_status"))
                .build();
    }
}