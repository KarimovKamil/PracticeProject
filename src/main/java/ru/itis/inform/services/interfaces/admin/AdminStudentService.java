package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Student;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminStudentService {

    List<Student> getAllStudents();

    Student getStudentById(long id);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(long id);

}
