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
import ru.itis.inform.models.User;
import ru.itis.inform.services.interfaces.StudentService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ModelAndView login(@RequestParam("login") String login,
                              @RequestParam("password") String password,
                              HttpServletResponse response) {
        UserDto userDto = service.login(login, password);
        Cookie cookie = new Cookie("Auth-Token", userDto.getToken());
        response.addCookie(cookie);
        return new ModelAndView("redirect:/profile");
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

    @RequestMapping(value = "/request/all", method = RequestMethod.GET)
    public ModelAndView getAllRequests(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("student/requests");
        String token = cookieGetter(request);
        List<Request> requestList = service.getMyRequests(token);
        Map<String, List<Request>> params = new HashMap<>();
        params.put("requests", requestList);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/{id}", method = RequestMethod.GET)
    public ModelAndView requestById(@PathVariable(value = "id") long id,
                                    HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView("student/request");
        String token = cookieGetter(req);
        Request request = service.getRequestById(token, id);
        Map<String, Request> params = new HashMap<>();
        params.put("request", request);
        modelAndView.addAllObjects(params);
        return modelAndView;
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

    public String cookieGetter(HttpServletRequest request) {
        String token = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("Auth-Token".equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        return token;
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public ModelAndView exit(HttpServletRequest req,
                             HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("Auth-Token".equals(cookie.getName())) {
                service.clearCookie(cookie.getValue());
            }
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        return new ModelAndView("redirect:/login");
    }
}
