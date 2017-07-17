package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.dto.UserDto;
import ru.itis.inform.dto.lists.RequestListDto;
import ru.itis.inform.models.*;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminService {

    UserDto login(String login, String password);

    User profile(String token);

    RequestListDto getAllRequests();

    RequestListDto getActiveRequests();

    RequestListDto getLabRequests();

    RequestListDto getPracticeRequests();

    RequestListDto getElectiveRequests();

    RequestListDto getLeaderRequests();

    Request getRequestById(long id);

    void acceptRequest(long id, String resMessage);

    void declineRequest(long id, String resMessage);

}
