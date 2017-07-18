package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.ConversionResultFactory;
import ru.itis.inform.dao.interfaces.StudentDao;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Student;
import ru.itis.inform.services.interfaces.admin.AdminStudentService;
import ru.itis.inform.utils.HashGenerator;
import ru.itis.inform.validation.StudentDtoValidation;
import ru.itis.inform.validation.ValidationFactory;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminStudentServiceImpl implements AdminStudentService {

    @Autowired
    UserDao userDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ValidationFactory validationFactory;
    @Autowired
    ConversionResultFactory conversionResultFactory;
    @Autowired
    StudentDtoValidation studentDtoValidation;
    @Autowired
    HashGenerator hashGenerator;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        validationFactory.studentExistenceById(id);
        return studentDao.findById(id);
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        studentDtoValidation.verifyStudentDto(studentDto);
        String hashPassword = hashGenerator.encode(studentDto.getPassword());
        Student student = conversionResultFactory.studentDtoToStudent(studentDto, hashPassword);
        student.setRole("STUDENT");
        long uId = userDao.insert(student);
        student.setuId(uId);
        studentDao.insert(student);
    }

    //TODO: добавить проверку на корректность логина и пароля
    @Override
    public void updateStudent(StudentDto studentDto, long id) {
        validationFactory.studentExistenceById(id);
        studentDtoValidation.verifyStudentDto(studentDto);
        String hashPassword = hashGenerator.encode(studentDto.getPassword());
        Student student = conversionResultFactory.studentDtoToStudent(studentDto, hashPassword);
        long uId = studentDao.findById(id).getuId();
        student.setRole("STUDENT");
        userDao.update(student, uId);
        studentDao.update(student, id);
    }

    @Override
    public void deleteStudent(long id) {
        validationFactory.studentExistenceById(id);
        Student student = studentDao.findById(id);
        studentDao.delete(id);
        userDao.delete(student.getuId());
    }
}
