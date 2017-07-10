package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.model.Practice;
import ru.itis.inform.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 10.07.2017.
 */
public class PracticeMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Teacher teacher = new Teacher.Builder()
                .id(resultSet.getLong("t_id"))
                .firstName(resultSet.getString("t_first_name"))
                .middleName(resultSet.getString("t_middle_name"))
                .lastName(resultSet.getString("t_last_name"))
                .build();
        return new Practice.Builder()
                .id(resultSet.getLong("pr_id"))
                .name(resultSet.getString("pr_name"))
                .startDate(resultSet.getDate("start_date"))
                .endDate(resultSet.getDate("end_date"))
                .teacher(teacher)
                .course(resultSet.getInt("course"))
                .build();
    }
}