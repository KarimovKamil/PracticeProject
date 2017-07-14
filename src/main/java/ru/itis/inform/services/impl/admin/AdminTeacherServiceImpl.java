package ru.itis.inform.services.impl.admin;

import org.springframework.stereotype.Component;
import ru.itis.inform.dto.TeacherDto;
import ru.itis.inform.models.Teacher;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminTeacherServiceImpl implements AdminTeacherService {

    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }

    @Override
    public Teacher getTeachersById(long id) {
        return null;
    }

    @Override
    public void addTeacher(TeacherDto teacherDto) {

    }

    @Override
    public void updateTeacher(TeacherDto teacherDto, long id) {

    }

    @Override
    public void deleteTeacher(long id) {

    }
}
