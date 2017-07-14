package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.*;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminService {

    String login(String login, String password);

    User profile(String token);

    List<Request> getAllRequests();

    List<Request> getActiveRequests();

    List<Request> getLabRequests();

    List<Request> getPracticeRequests();

    List<Request> getElectiveRequests();

    List<Request> getLeaderRequests();

    Request getRequestById(long id);

    void acceptRequest(long id, String resMessage);

    void declineRequest(long id, String resMessage);

}
