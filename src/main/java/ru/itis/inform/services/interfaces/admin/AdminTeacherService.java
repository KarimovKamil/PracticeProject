package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Teacher;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminTeacherService {

    List<Teacher> getAllTeachers(String token);

    Teacher getTeachersById(String token, long id);

    void addTeacher(String token, Teacher teacher);

    void updateTeacher(String token, Teacher teacher);

    void deleteTeacher(String token, long id);

}
