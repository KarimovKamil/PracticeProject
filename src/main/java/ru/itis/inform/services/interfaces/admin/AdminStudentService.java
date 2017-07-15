package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Student;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminStudentService {

    //TODO: сделать генерацию паролей и логинов

    List<Student> getAllStudents();

    Student getStudentById(long id);

    void addStudent(StudentDto studentDto);

    void updateStudent(StudentDto studentDto, long id);

    void deleteStudent(long id);

}
