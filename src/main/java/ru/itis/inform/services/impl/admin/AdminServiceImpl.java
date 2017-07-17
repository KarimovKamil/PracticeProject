package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.RequestDao;
import ru.itis.inform.dao.interfaces.StudentDao;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.dto.AdminDto;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.Request;
import ru.itis.inform.models.Student;
import ru.itis.inform.models.User;
import ru.itis.inform.services.interfaces.admin.AdminService;
import ru.itis.inform.utils.HashGenerator;
import ru.itis.inform.utils.TokenGenerator;
import ru.itis.inform.validation.ValidationFactory;

import java.util.List;

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
    public List<Request> getAllRequests() {
        return requestDao.findAll();
    }

    @Override
    public List<Request> getActiveRequests() {
        return requestDao.findAllActive();
    }

    @Override
    public List<Request> getLabRequests() {
        return requestDao.findAllLabReq();
    }

    @Override
    public List<Request> getPracticeRequests() {
        return requestDao.findAllPracticeReq();
    }

    @Override
    public List<Request> getElectiveRequests() {
        return requestDao.findAllElectiveReq();
    }

    @Override
    public List<Request> getLeaderRequests() {
        return requestDao.findAllLeaderReq();
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

    //TODO: PROVERIT~ LOGIN I PASS NA KORR
    @Override
    public void addNewAdmin(AdminDto adminDto) {
        User user = new User.Builder()
                .firstName(adminDto.getFirstName())
                .lastName(adminDto.getLastName())
                .middleName(adminDto.getMiddleName())
                .role("ADMIN")
                .login(adminDto.getLogin())
                .hashPassword(hashGenerator.encode(adminDto.getPassword()))
                .build();
        userDao.insert(user);
    }
}
