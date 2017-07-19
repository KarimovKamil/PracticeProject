package ru.itis.inform.services.interfaces;

import ru.itis.inform.dto.ProfileDto;
import ru.itis.inform.dto.RequestDto;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.models.*;

import java.util.List;

/**
 * Created by Kamil Karimov on 06.07.2017.
 */
public interface StudentService {

    UserDto login(String login, String password);

    ProfileDto getProfile(String token);

    List<Request> getMyRequests(String token);

    Request getRequestById(String token, long id);

    void addRequest(String token, RequestDto requestDto);

    void deleteRequest(String token, long id);

    void removeToken(String token);

    List<Lab> getAllLabs();

    List<Practice> getAllPractices();

    List<Elective> getAllElectives();

    List<Teacher> getAllTeachers();

}
