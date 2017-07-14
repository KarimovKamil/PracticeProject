package ru.itis.inform.services.impl.admin;

import org.springframework.stereotype.Component;
import ru.itis.inform.models.Teacher;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminTeacherServiceImpl implements AdminTeacherService {

    @Override
    public List<Teacher> getAllTeachers(String token) {
        return null;
    }

    @Override
    public Teacher getTeachersById(String token, long id) {
        return null;
    }

    @Override
    public void addTeacher(String token, Teacher teacher) {

    }

    @Override
    public void updateTeacher(String token, Teacher teacher) {

    }

    @Override
    public void deleteTeacher(String token, long id) {

    }
}
