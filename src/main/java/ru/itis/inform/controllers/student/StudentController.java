package ru.itis.inform.controllers.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.ProfileDto;
import ru.itis.inform.dto.RequestDto;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.dto.response.QueryResultDto;
import ru.itis.inform.models.Request;
import ru.itis.inform.services.interfaces.StudentService;

import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponseGetAndDelete;
import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponsePostAndPut;

/**
 * Created by Kamil Karimov on 06.07.2017.
 */
@Controller
public class StudentController {

    @Autowired
    StudentService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> login(@RequestParam("login") String login,
                                                @RequestParam("password") String password) {
        UserDto userDto = service.login(login, password);
        return buildResponsePostAndPut(userDto);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> profile(@RequestHeader("Auth-Token") String token) {
        ProfileDto profileDto = service.getProfile(token);
        return buildResponseGetAndDelete(profileDto);
    }

//    @RequestMapping(value = "/request/all", method = RequestMethod.GET)
//    public ResponseEntity<QueryResultDto> getAllRequests(@RequestHeader("Auth-Token") String token) {
//        RequestListDto requestListDto = service.getMyRequests(token);
//        return buildResponseGetAndDelete(requestListDto);
//    }

    @RequestMapping(value = "/request/{id}", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> requestById(@RequestHeader("Auth-Token") String token,
                                                      @PathVariable(value = "id") long id) {
        Request request = service.getRequestById(token, id);
        return buildResponseGetAndDelete(request);
    }

    @RequestMapping(value = "/request/new", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> addRequest(@RequestHeader("Auth-Token") String token,
                                                     @RequestBody RequestDto requestDto) {
        service.addRequest(token, requestDto);
        return buildResponsePostAndPut(Data.EMPTY_DTO());
    }

    @RequestMapping(value = "/request/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<QueryResultDto> deleteRequestById(@RequestHeader("Auth-Token") String token,
                                                            @PathVariable(value = "id") long id) {
        service.deleteRequest(token, id);
        return buildResponseGetAndDelete(Data.EMPTY_DTO());
    }
}
