package ru.itis.inform.services.impl.admin;

import org.springframework.stereotype.Component;
import ru.itis.inform.models.Student;
import ru.itis.inform.services.interfaces.admin.AdminStudentService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminStudentServiceImpl implements AdminStudentService {

    @Override
    public List<Student> getAllStudents(String token) {
        return null;
    }

    @Override
    public Student getStudentById(String token, long id) {
        return null;
    }

    @Override
    public void addStudent(String token, Student student) {

    }

    @Override
    public void updateStudent(String token, Student student) {

    }

    @Override
    public void deleteStudent(String token, long id) {

    }
}
