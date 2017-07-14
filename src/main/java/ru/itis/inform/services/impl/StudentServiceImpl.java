package ru.itis.inform.services.impl;

import org.springframework.stereotype.Component;
import ru.itis.inform.dto.ProfileDto;
import ru.itis.inform.dto.RequestDto;
import ru.itis.inform.models.Request;
import ru.itis.inform.services.interfaces.StudentService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class StudentServiceImpl implements StudentService {

    @Override
    public String login(String login, String password) {
        return null;
    }

    @Override
    public ProfileDto getProfile(String token) {
        return null;
    }

    @Override
    public List<Request> getMyRequests(String token) {
        return null;
    }

    @Override
    public Request getRequestById(String token, long id) {
        return null;
    }

    @Override
    public void addRequest(String token, RequestDto requestDto) {

    }

    @Override
    public void deleteRequest(String token, long id) {

    }
}
