package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.dto.TeacherDto;
import ru.itis.inform.dto.lists.TeacherListDto;
import ru.itis.inform.models.Teacher;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminTeacherService {

    TeacherListDto getAllTeachers();

    Teacher getTeachersById(long id);

    void addTeacher(TeacherDto teacherDto);

    void updateTeacher(TeacherDto teacherDto, long id);

    void deleteTeacher(long id);

}
