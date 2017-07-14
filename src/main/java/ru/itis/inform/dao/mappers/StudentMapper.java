package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Student;
import ru.itis.inform.models.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 10.07.2017.
 */
public class StudentMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Teacher teacher = new Teacher.Builder()
                .id(resultSet.getLong("t_id"))
                .firstName(resultSet.getString("t_first_name"))
                .middleName(resultSet.getString("t_middle_name"))
                .lastName(resultSet.getString("t_last_name"))
                .build();
        return new Student.Builder()
                .id(resultSet.getLong("st_id"))
                .group(resultSet.getString("s_group"))
                .course(resultSet.getInt("course"))
                .lab(resultSet.getString("lab_name"))
                .labId(resultSet.getLong("lab_id"))
                .elective(resultSet.getString("el_name"))
                .electiveId(resultSet.getLong("el_id"))
                .practice(resultSet.getString("pr_name"))
                .practiceId(resultSet.getLong("pr_id"))
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
    }
}