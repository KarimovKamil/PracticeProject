package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.ConversionListResultFactory;
import ru.itis.inform.conversion.ConversionResultFactory;
import ru.itis.inform.dao.interfaces.*;
import ru.itis.inform.dto.ProfileDto;
import ru.itis.inform.dto.RequestDto;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.dto.lists.RequestListDto;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.*;
import ru.itis.inform.services.interfaces.StudentService;
import ru.itis.inform.utils.HashGenerator;
import ru.itis.inform.utils.TokenGenerator;
import ru.itis.inform.validation.ValidationFactory;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    UserDao userDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    RequestDao requestDao;
    @Autowired
    LabDao labDao;
    @Autowired
    PracticeDao practiceDao;
    @Autowired
    ElectiveDao electiveDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ValidationFactory validationFactory;
    @Autowired
    ConversionResultFactory conversionResultFactory;
    @Autowired
    HashGenerator hashGenerator;
    @Autowired
    TokenGenerator tokenGenerator;
    @Autowired
    ConversionListResultFactory conversionListResultFactory;

    @Override
    public UserDto login(String login, String password) {
        validationFactory.userExistenceByLogin(login);
        User user = userDao.findByLogin(login);
        if (hashGenerator.match(password, user.getHashPassword())) {
            user.setToken(tokenGenerator.generateToken());
            userDao.update(user, user.getuId());
            return new UserDto(user.getuId(), user.getToken());
        } else {
            throw new IncorrectDataException("Incorrect login or password");
        }
    }

    @Override
    public ProfileDto getProfile(String token) {
        validationFactory.userExistenceByToken(token);
        Student student = studentDao.findByToken(token);
        return conversionResultFactory.studentToProfileDto(student);
    }

    @Override
    public RequestListDto getMyRequests(String token) {
        validationFactory.userExistenceByToken(token);
        RequestListDto requestListDto = conversionListResultFactory.requestsToRequestListDto(requestDao.findAllStudentReq(token));
        return requestListDto;
    }

    @Override
    public Request getRequestById(String token, long id) {
        validationFactory.userExistenceByToken(token);
        validationFactory.requestExistenceById(id);
        Student student = studentDao.findByToken(token);
        validationFactory.checkIfRequestBelongToStudent(id, student.getId());
        return requestDao.findById(id);
    }

    @Override
    public void addRequest(String token, RequestDto requestDto) {
        validationFactory.userExistenceByToken(token);
        Student student = studentDao.findByToken(token);
        String message = student.getLastName() + " "
                + student.getFirstName() + " "
                + student.getMiddleName() + " из "
                + student.getGroup() + " группы хочет поменять ";
        requestDto.setType(requestDto.getType().toUpperCase());
        long aId = requestDto.getAttributeId();
        switch (requestDto.getType()) {
            case "LAB":
                validationFactory.labExistenceById(aId);
                Lab lab = labDao.findById(aId);
                message += "лабораторию на " + lab.getName();
                break;
            case "ELECTIVE":
                validationFactory.electiveExistenceById(aId);
                validationFactory.electiveRequestCheck(student.getId(), aId);
                Elective elective = electiveDao.findById(aId);
                message += "курс по выбору на " + elective.getName();
                break;
            case "PRACTICE":
                validationFactory.practiceExistenceById(aId);
                validationFactory.practiceRequestCheck(student.getId(), aId);
                Practice practice = practiceDao.findById(aId);
                message += "место проведения практики на " + practice.getName();
                break;
            case "LEADER":
                validationFactory.teacherExistenceById(aId);
                Teacher teacher = teacherDao.findById(aId);
                message += "научного руководителя на "
                        + teacher.getLastName() + " "
                        + teacher.getFirstName() + " "
                        + teacher.getMiddleName();
                break;
            default:
                throw new IncorrectDataException("Incorrect request type");
        }
        Request request = conversionResultFactory.requestDtoToRequest(requestDto);
        request.setReqMessage(message);
        requestDao.insert(request);
    }

    @Override
    public void deleteRequest(String token, long id) {
        validationFactory.userExistenceByToken(token);
        validationFactory.requestExistenceById(id);
        Student student = studentDao.findByToken(token);
        validationFactory.checkIfRequestBelongToStudent(id, student.getId());
        requestDao.delete(id);
    }
}
