package ru.itis.inform.services.impl.admin;

import org.springframework.stereotype.Component;
import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Student;
import ru.itis.inform.services.interfaces.admin.AdminStudentService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminStudentServiceImpl implements AdminStudentService {

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentById(long id) {
        return null;
    }

    @Override
    public void addStudent(StudentDto studentDto) {

    }

    @Override
    public void updateStudent(StudentDto studentDto, long id) {

    }

    @Override
    public void deleteStudent(long id) {

    }
}
