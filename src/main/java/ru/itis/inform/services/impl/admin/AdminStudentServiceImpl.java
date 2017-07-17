package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.ConversionListResultFactory;
import ru.itis.inform.conversion.ConversionResultFactory;
import ru.itis.inform.dao.interfaces.StudentDao;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.dto.lists.StudentListDto;
import ru.itis.inform.models.Student;
import ru.itis.inform.services.interfaces.admin.AdminStudentService;
import ru.itis.inform.utils.HashGenerator;
import ru.itis.inform.utils.LoginAndPasswordGenerator;
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
    ConversionListResultFactory conversionListResultFactory;
    @Autowired
    StudentDtoValidation studentDtoValidation;
    @Autowired
    HashGenerator hashGenerator;
    @Autowired
    LoginAndPasswordGenerator loginAndPasswordGenerator;

    @Override
    public StudentListDto getAllStudents() {
        List<Student> studentList = studentDao.findAll();
        StudentListDto studentListDto = conversionListResultFactory.studentsToStudentListDto(studentList);
        return studentListDto;
    }

    @Override
    public Student getStudentById(long id) {
        validationFactory.studentExistenceById(id);
        return studentDao.findById(id);
    }

    //TODO: изменить генерацию пароля и логина
    @Override
    public void addStudent(StudentDto studentDto) {
        studentDtoValidation.verifyStudentDto(studentDto);
        Student student = conversionResultFactory.studentDtoToStudent(studentDto);
        student.setRole("STUDENT");
        long uId = userDao.insert(student);
        String login = loginAndPasswordGenerator.generateLogin(uId);
        String password = loginAndPasswordGenerator.generatePassword(uId);
        String hash = hashGenerator.encode(password);
        student.setLogin(login);
        student.setHashPassword(hash);
        student.setuId(uId);
        userDao.update(student, uId);
        studentDao.insert(student);
    }

    //TODO: добавить проверку на корректность логина и пароля
    @Override
    public void updateStudent(StudentDto studentDto, long id) {
        validationFactory.studentExistenceById(id);
        studentDtoValidation.verifyStudentDto(studentDto);
        Student student = conversionResultFactory.studentDtoToStudent(studentDto);
        long uId = studentDao.findById(id).getuId();
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
