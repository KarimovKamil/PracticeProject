package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Teacher;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminTeacherService {

    List<Teacher> getAllTeachers();

    Teacher getTeachersById(long id);

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(long id);

}
