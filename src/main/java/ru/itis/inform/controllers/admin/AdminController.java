package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.AdminDto;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.models.User;
import ru.itis.inform.services.interfaces.admin.AdminService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("login") String login,
                              @RequestParam("password") String password,
                              HttpServletResponse response) {
        UserDto userDto = service.login(login, password);
        Cookie cookie = new Cookie("Auth-Token", userDto.getToken());
        response.addCookie(cookie);
        return new ModelAndView("redirect:/admin/profile");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("admin/login");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(@CookieValue("Auth-Token") String token) {
        User user = service.profile(token);
        ModelAndView modelAndView = new ModelAndView("admin/profile");
        Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/all", method = RequestMethod.GET)
    public ModelAndView getAllRequests() {
        ModelAndView modelAndView = new ModelAndView("admin/requests");
        Map<String, Object> params = new HashMap<>();
        params.put("requests", service.getAllRequests());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/active", method = RequestMethod.GET)
    public ModelAndView getActiveRequests() {
        ModelAndView modelAndView = new ModelAndView("admin/requests");
        Map<String, Object> params = new HashMap<>();
        params.put("requests", service.getActiveRequests());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/lab", method = RequestMethod.GET)
    public ModelAndView getLabRequests() {
        ModelAndView modelAndView = new ModelAndView("admin/requests");
        Map<String, Object> params = new HashMap<>();
        params.put("requests", service.getLabRequests());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/practice", method = RequestMethod.GET)
    public ModelAndView getPracticeRequests() {
        ModelAndView modelAndView = new ModelAndView("admin/requests");
        Map<String, Object> params = new HashMap<>();
        params.put("requests", service.getPracticeRequests());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/elective", method = RequestMethod.GET)
    public ModelAndView getElectiveRequests() {
        ModelAndView modelAndView = new ModelAndView("admin/requests");
        Map<String, Object> params = new HashMap<>();
        params.put("requests", service.getElectiveRequests());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/leader", method = RequestMethod.GET)
    public ModelAndView getLeaderRequests() {
        ModelAndView modelAndView = new ModelAndView("admin/requests");
        Map<String, Object> params = new HashMap<>();
        params.put("requests", service.getLeaderRequests());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/{id}", method = RequestMethod.GET)
    public ModelAndView requestById(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("admin/request");
        Map<String, Object> params = new HashMap<>();
        params.put("request", service.getRequestById(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/request/{id}/accept", method = RequestMethod.POST)
    public ModelAndView acceptRequest(@PathVariable(value = "id") long id,
                                      @RequestParam("message") String message) {
        service.acceptRequest(id, message);
        return new ModelAndView("redirect:/admin/request/active");
    }

    @RequestMapping(value = "/request/{id}/decline", method = RequestMethod.POST)
    public ModelAndView declineRequest(@PathVariable(value = "id") long id,
                                       @RequestParam("message") String message) {
        service.declineRequest(id, message);
        return new ModelAndView("redirect:/admin/request/active");
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
    public ModelAndView addNewAdmin() {
        ModelAndView modelAndView = new ModelAndView("admin/addAdmin");
        Map<String, Object> params = new HashMap<>();
        params.put("adminDto", new AdminDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public ModelAndView addNewAdmin(@ModelAttribute AdminDto adminDto) {
        service.addNewAdmin(adminDto);
        return new ModelAndView("redirect:/admin/profile");
    }
}
