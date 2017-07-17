package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.RequestDao;
import ru.itis.inform.dao.interfaces.StudentDao;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.dto.TeacherDto;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.dto.lists.RequestListDto;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.Request;
import ru.itis.inform.models.Student;
import ru.itis.inform.models.User;
import ru.itis.inform.services.interfaces.admin.AdminService;
import ru.itis.inform.utils.HashGenerator;
import ru.itis.inform.utils.LoginAndPasswordGenerator;
import ru.itis.inform.utils.TokenGenerator;
import ru.itis.inform.validation.ValidationFactory;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    RequestDao requestDao;
    @Autowired
    UserDao userDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ValidationFactory validationFactory;
    @Autowired
    HashGenerator hashGenerator;
    @Autowired
    TokenGenerator tokenGenerator;
    @Autowired
    ConversionListResultFactory conversionListResultFactory;
    @Autowired
    LoginAndPasswordGenerator loginAndPasswordGenerator;

    @Override
    public UserDto login(String login, String password) {
        validationFactory.userExistenceByLogin(login);
        User user = userDao.findByLogin(login);
        if (hashGenerator.match(password, user.getHashPassword())
                && "ADMIN".equals(user.getRole().toUpperCase())) {
            user.setToken(tokenGenerator.generateToken());
            userDao.update(user, user.getuId());
            return new UserDto(user.getuId(), user.getToken());
        } else {
            throw new IncorrectDataException("Incorrect login or password");
        }
    }

    @Override
    public User profile(String token) {
        validationFactory.userExistenceByToken(token);
        return userDao.findByToken(token);
    }

    @Override
    public RequestListDto getAllRequests() {
        RequestListDto requestListDto = conversionListResultFactory.requestsToRequestListDto(requestDao.findAll());
        return requestListDto;
    }

    @Override
    public RequestListDto getActiveRequests() {
        RequestListDto requestListDto = conversionListResultFactory.requestsToRequestListDto(requestDao.findAllActive());
        return requestListDto;
    }

    @Override
    public RequestListDto getLabRequests() {
        RequestListDto requestListDto = conversionListResultFactory.requestsToRequestListDto(requestDao.findAllLabReq());
        return requestListDto;
    }

    @Override
    public RequestListDto getPracticeRequests() {
        RequestListDto requestListDto = conversionListResultFactory.requestsToRequestListDto(requestDao.findAllPracticeReq());
        return requestListDto;
    }

    @Override
    public RequestListDto getElectiveRequests() {
        RequestListDto requestListDto = conversionListResultFactory.requestsToRequestListDto(requestDao.findAllElectiveReq());
        return requestListDto;
    }

    @Override
    public RequestListDto getLeaderRequests() {
        RequestListDto requestListDto = conversionListResultFactory.requestsToRequestListDto(requestDao.findAllLeaderReq());
        return requestListDto;
    }

    @Override
    public Request getRequestById(long id) {
        validationFactory.requestExistenceById(id);
        return requestDao.findById(id);
    }

    @Override
    public void acceptRequest(long id, String resMessage) {
        validationFactory.requestExistenceById(id);
        Request request = requestDao.findById(id);
        request.setResMessage(resMessage);
        request.setStatus("ACCEPTED");
        Student student = request.getStudent();
        switch (request.getType()) {
            case "LAB":
                student.setLabId(request.getAttributeId());
                break;
            case "ELECTIVE":
                student.setElectiveId(request.getAttributeId());
                break;
            case "PRACTICE":
                student.setPracticeId(request.getAttributeId());
                break;
            case "LEADER":
                student.getTeacher().setId(request.getAttributeId());
                break;
        }
        studentDao.update(student, student.getId());
        requestDao.update(request, id);
    }

    @Override
    public void declineRequest(long id, String resMessage) {
        validationFactory.requestExistenceById(id);
        Request request = requestDao.findById(id);
        request.setResMessage(resMessage);
        request.setStatus("DENIED");
        requestDao.update(request, id);
    }

    //TODO: ZAKONCHIT~
    @Override
    public void addNewAdmin(TeacherDto teacherDto) {
        User user = new User.Builder()
                .firstName(teacherDto.getFirstName())
                .lastName(teacherDto.getLastName())
                .middleName(teacherDto.getMiddleName())
                .role("ADMIN")
                .build();
    }
}
