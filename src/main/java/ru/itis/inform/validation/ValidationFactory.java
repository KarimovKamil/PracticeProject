package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.exceptions.IncorrectDataException;

/**
 * Created by artur on 12.07.2017.
 */
@Component
public class ValidationFactory {

    @Autowired
    Validation validation;

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
}
