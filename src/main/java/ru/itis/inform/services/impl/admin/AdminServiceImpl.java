package ru.itis.inform.services.impl.admin;

import org.springframework.stereotype.Component;
import ru.itis.inform.models.Request;
import ru.itis.inform.models.User;
import ru.itis.inform.services.interfaces.admin.AdminService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminServiceImpl implements AdminService {

    @Override
    public String login(String login, String password) {
        return null;
    }

    @Override
    public User profile(String token) {
        return null;
    }

    @Override
    public List<Request> getAllRequests(String token) {
        return null;
    }

    @Override
    public List<Request> getActiveRequests(String token) {
        return null;
    }

    @Override
    public List<Request> getLabRequests(String token) {
        return null;
    }

    @Override
    public List<Request> getPracticeRequests(String token) {
        return null;
    }

    @Override
    public List<Request> getElectiveRequests(String token) {
        return null;
    }

    @Override
    public List<Request> getLeaderRequests(String token) {
        return null;
    }

    @Override
    public Request getRequestById(String token, long id) {
        return null;
    }

    @Override
    public void acceptRequest(String token, long id, String resMessage) {

    }

    @Override
    public void declineRequest(String token, long id, String resMessage) {

    }
}
