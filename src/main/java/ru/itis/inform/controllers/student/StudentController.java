package ru.itis.inform.controllers.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.RequestDto;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.models.Request;
import ru.itis.inform.services.interfaces.StudentService;
import ru.itis.inform.services.interfaces.admin.AdminElectiveService;
import ru.itis.inform.services.interfaces.admin.AdminLabService;
import ru.itis.inform.services.interfaces.admin.AdminPracticeService;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 06.07.2017.
 */
@Controller
public class StudentController {

    @Autowired
    StudentService service;
    @Autowired
    AdminLabService adminLabService;
    @Autowired
    AdminPracticeService adminPracticeService;
    @Autowired
    AdminElectiveService adminElectiveService;
    @Autowired
    AdminTeacherService adminTeacherService;

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
        return new ModelAndView("student/login");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(@CookieValue("Auth-Token") String token) {
        ModelAndView modelAndView = new ModelAndView("student/profile");
        Map<String, Object> params = new HashMap<>();
        params.put("profileDto", service.getProfile(token));
        modelAndView.addAllObjects(params);
        return modelAndView;
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

    @RequestMapping(value = "/request/lab", method = RequestMethod.GET)
    public ModelAndView addLabRequest() {
        ModelAndView modelAndView = new ModelAndView("student/changeLab");
        Map<String, Object> params = new HashMap<>();
        params.put("attributes", adminLabService.getAllWithoutEmpty());
        params.put("requestDto", new RequestDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/lab", method = RequestMethod.POST)
    public ModelAndView addLabRequest(@CookieValue("Auth-Token") String token,
                                      @ModelAttribute RequestDto requestDto) {
        requestDto.setType("LAB");
        service.addRequest(token, requestDto);
        return new ModelAndView("redirect:/request/all");
    }

    @RequestMapping(value = "/request/elective", method = RequestMethod.GET)
    public ModelAndView addElectiveRequest() {
        ModelAndView modelAndView = new ModelAndView("student/changeElective");
        Map<String, Object> params = new HashMap<>();
        params.put("attributes", adminElectiveService.getAllWithoutEmpty());
        params.put("requestDto", new RequestDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/elective", method = RequestMethod.POST)
    public ModelAndView addElectiveRequest(@CookieValue("Auth-Token") String token,
                                           @ModelAttribute RequestDto requestDto) {
        requestDto.setType("ELECTIVE");
        service.addRequest(token, requestDto);
        return new ModelAndView("redirect:/request/all");
    }

    @RequestMapping(value = "/request/practice", method = RequestMethod.GET)
    public ModelAndView addPracticeRequest() {
        ModelAndView modelAndView = new ModelAndView("student/changePractice");
        Map<String, Object> params = new HashMap<>();
        params.put("attributes", adminPracticeService.getAllWithoutEmpty());
        params.put("requestDto", new RequestDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/practice", method = RequestMethod.POST)
    public ModelAndView addPracticeRequest(@CookieValue("Auth-Token") String token,
                                           @ModelAttribute RequestDto requestDto) {
        requestDto.setType("PRACTICE");
        service.addRequest(token, requestDto);
        return new ModelAndView("redirect:/request/all");
    }

    @RequestMapping(value = "/request/teacher", method = RequestMethod.GET)
    public ModelAndView addTeacherRequest() {
        ModelAndView modelAndView = new ModelAndView("student/changeTeacher");
        Map<String, Object> params = new HashMap<>();
        params.put("attributes", adminTeacherService.getAllWithoutEmpty());
        params.put("requestDto", new RequestDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/teacher", method = RequestMethod.POST)
    public ModelAndView addTeacherRequest(@CookieValue("Auth-Token") String token,
                                          @ModelAttribute RequestDto requestDto) {
        requestDto.setType("LEADER");
        service.addRequest(token, requestDto);
        return new ModelAndView("redirect:/request/all");
    }

    @RequestMapping(value = "/request/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteRequestById(@CookieValue("Auth-Token") String token,
                                          @PathVariable(value = "id") long id) {
        service.deleteRequest(token, id);
        return new ModelAndView("redirect:/request/all");
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
                service.removeToken(cookie.getValue());
            }
            cookie.setMaxAge(0);
            cookie.setValue(null);
            resp.addCookie(cookie);
        }
        return new ModelAndView("redirect:/login");
    }
}
