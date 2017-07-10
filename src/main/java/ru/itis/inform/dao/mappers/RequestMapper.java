package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.model.Request;
import ru.itis.inform.model.Student;
import ru.itis.inform.model.Teacher;
import ru.itis.inform.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 10.07.2017.
 */
public class RequestMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Teacher teacher = new Teacher.Builder()
                .id(resultSet.getLong("t_id"))
                .firstName(resultSet.getString("t_first_name"))
                .middleName(resultSet.getString("t_middle_name"))
                .lastName(resultSet.getString("t_last_name"))
                .build();
        Student student = (Student) new Student.Builder()
                .id(resultSet.getLong("st_id"))
                .group(resultSet.getString("s_group"))
                .course(resultSet.getInt("course"))
                .lab(resultSet.getString("lab_name"))
                .elective(resultSet.getString("el_name"))
                .practice(resultSet.getString("pr_name"))
                .teacher(teacher)
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