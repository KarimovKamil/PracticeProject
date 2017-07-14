package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Student;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminStudentService {

    List<Student> getAllStudents(String token);

    Student getStudentById(String token, long id);

    void addStudent(String token, Student student);

    void updateStudent(String token, Student student);

    void deleteStudent(String token, long id);

}
