package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.model.Elective;
import ru.itis.inform.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 10.07.2017.
 */
public class ElectiveMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Teacher teacher = new Teacher.Builder()
                .id(resultSet.getLong("t_id"))
                .firstName(resultSet.getString("t_first_name"))
                .middleName(resultSet.getString("t_middle_name"))
                .lastName(resultSet.getString("t_last_name"))
                .build();
        return new Elective.Builder()
                .id(resultSet.getLong("el_id"))
                .name(resultSet.getString("el_name"))
                .teacher(teacher)
                .course(resultSet.getInt("course"))
                .build();
    }
}
