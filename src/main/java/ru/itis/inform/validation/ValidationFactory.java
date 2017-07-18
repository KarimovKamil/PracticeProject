package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.exceptions.IncorrectDataException;

import java.util.Date;

/**
 * Created by artur on 12.07.2017.
 */
@Component
public class ValidationFactory {

    @Autowired
    Validation validation;
    @Autowired
    DataValidation dataValidation;

    public void userExistenceById(long id) {
        if (!validation.userExistenceById(id)) {
            throw new IncorrectDataException("Incorrect user");
        }
    }

    public void userExistenceByToken(String token) {
        if (!validation.userExistenceByToken(token)) {
            throw new IncorrectDataException("Incorrect user");
        }
    }

    public void userExistenceByLogin(String login) {
        if (!validation.userExistenceByLogin(login)) {
            throw new IncorrectDataException("Incorrect user");
        }
    }

    public void userLoginUnique(String login) {
        if (validation.userExistenceByLogin(login)) {
            throw new IncorrectDataException("Login already exists");
        }
    }

    public void studentExistenceById(long id) {
        if (!validation.studentExistenceById(id)) {
            throw new IncorrectDataException("Incorrect student");
        }
    }

    public void electiveExistenceById(long id) {
        if (!validation.electiveExistenceById(id)) {
            throw new IncorrectDataException("Incorrect elective");
        }
    }

    public void labExistenceById(long id) {
        if (!validation.labExistenceById(id)) {
            throw new IncorrectDataException("Incorrect lab");
        }
    }

    public void practiceExistenceById(long id) {
        if (!validation.practiceExistenceById(id)) {
            throw new IncorrectDataException("Incorrect practice");
        }
    }

    public void requestExistenceById(long id) {
        if (!validation.requestExistenceById(id)) {
            throw new IncorrectDataException("Incorrect request");
        }
    }

    public void teacherExistenceById(long id) {
        if (!validation.teacherExistenceById(id)) {
            throw new IncorrectDataException("Incorrect teacher");
        }
    }

    public void practiceRequestCheck(long studentId, long practiceId) {
        if (!validation.practiceRequestCheck(studentId, practiceId)) {
            throw new IncorrectDataException("Incorrect request");
        }
    }

    public void electiveRequestCheck(long studentId, long electiveId) {
        if (!validation.electiveRequestCheck(studentId, electiveId)) {
            throw new IncorrectDataException("Incorrect request");
        }
    }

    public void checkIfRequestBelongToStudent(long requestId, long studentId) {
        if (!validation.requestCheck(requestId, studentId)) {
            throw new IncorrectDataException("Request doesn't belong to student");
        }
    }

    public void verifyCourse(int course) {
        if (!dataValidation.verifyCourse(course)) {
            throw new IncorrectDataException("Incorrect course");
        }
    }

    public void verifyName(String name) {
        if (!dataValidation.verifyName(name)) {
            throw new IncorrectDataException("Incorrect name");
        }
    }

    public void verifyDate(Date startDate, Date endDate) {
        if (!dataValidation.verifyDate(startDate, endDate)) {
            throw new IncorrectDataException("Incorrect date");
        }
    }
}
