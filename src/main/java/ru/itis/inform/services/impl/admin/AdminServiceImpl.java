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
    public List<Request> getAllRequests() {
        return null;
    }

    @Override
    public List<Request> getActiveRequests() {
        return null;
    }

    @Override
    public List<Request> getLabRequests() {
        return null;
    }

    @Override
    public List<Request> getPracticeRequests() {
        return null;
    }

    @Override
    public List<Request> getElectiveRequests() {
        return null;
    }

    @Override
    public List<Request> getLeaderRequests() {
        return null;
    }

    @Override
    public Request getRequestById(long id) {
        return null;
    }

    @Override
    public void acceptRequest(long id, String resMessage) {

    }

    @Override
    public void declineRequest(long id, String resMessage) {

    }
}
