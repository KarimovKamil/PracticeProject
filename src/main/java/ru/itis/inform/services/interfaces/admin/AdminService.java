package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.*;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminService {

    String login(String login, String password);

    User profile(String token);

    List<Request> getAllRequests(String token);

    List<Request> getActiveRequests(String token);

    List<Request> getLabRequests(String token);

    List<Request> getPracticeRequests(String token);

    List<Request> getElectiveRequests(String token);

    List<Request> getLeaderRequests(String token);

    Request getRequestById(String token, long id);

    void acceptRequest(String token, long id, String resMessage);

    void declineRequest(String token, long id, String resMessage);

}
