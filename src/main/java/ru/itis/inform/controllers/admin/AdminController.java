package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.dto.lists.RequestListDto;
import ru.itis.inform.dto.response.QueryResultDto;
import ru.itis.inform.models.Request;
import ru.itis.inform.models.User;
import ru.itis.inform.services.interfaces.admin.AdminService;

import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponseGetAndDelete;
import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponsePostAndPut;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> login(@RequestParam("login") String login,
                                                @RequestParam("password") String password) {
        UserDto userDto = service.login(login, password);
        return buildResponsePostAndPut(userDto);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> profile(@RequestHeader("Auth-Token") String token) {
        User user = service.profile(token);
        return buildResponseGetAndDelete(user);
    }

    @RequestMapping(value = "/request/all", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getAllRequests() {
        RequestListDto requestListDto = service.getAllRequests();
        return buildResponseGetAndDelete(requestListDto);
    }

    @RequestMapping(value = "/request/lab", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getLabRequests() {
        RequestListDto requestListDto = service.getLabRequests();
        return buildResponseGetAndDelete(requestListDto);
    }

    @RequestMapping(value = "/request/practice", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getPracticeRequests() {
        RequestListDto requestListDto = service.getPracticeRequests();
        return buildResponseGetAndDelete(requestListDto);
    }

    @RequestMapping(value = "/request/elective", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getElectiveRequests() {
        RequestListDto requestListDto = service.getElectiveRequests();
        return buildResponseGetAndDelete(requestListDto);
    }

    @RequestMapping(value = "/request/leader", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getLeaderRequests() {
        RequestListDto requestListDto = service.getLeaderRequests();
        return buildResponseGetAndDelete(requestListDto);
    }

    @RequestMapping(value = "/request/{id}", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> requestById(@PathVariable(value = "id") long id) {
        Request request = service.getRequestById(id);
        return buildResponseGetAndDelete(request);
    }

    @RequestMapping(value = "/request/{id}/accept", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> acceptRequest(@PathVariable(value = "id") long id,
                                                        @RequestParam("message") String message) {
        service.acceptRequest(id, message);
        return buildResponsePostAndPut(Data.EMPTY_DTO());
    }

    @RequestMapping(value = "/request/{id}/decline", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> declineRequest(@PathVariable(value = "id") long id,
                                                         @RequestParam("message") String message) {
        service.declineRequest(id, message);
        return buildResponsePostAndPut(Data.EMPTY_DTO());
    }

}
