package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.TeacherDto;
import ru.itis.inform.models.Teacher;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/teacher")
public class AdminTeacherController {

    @Autowired
    AdminTeacherService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllTeachers() {
        List<Teacher> teacherList = service.getAllWithoutEmpty();
        ModelAndView modelAndView = new ModelAndView("adminTeacher/teachers");
        Map<String, List<Teacher>> params = new HashMap<>();
        params.put("teachers", teacherList);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getTeacherById(@PathVariable(value = "id") long id) {
        Teacher teacher = service.getTeachersById(id);
        ModelAndView modelAndView = new ModelAndView("adminTeacher/teacher");
        Map<String, Teacher> params = new HashMap<>();
        params.put("teacher", teacher);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addTeacherGet() {
        ModelAndView modelAndView = new ModelAndView("adminTeacher/addTeacher");
        Map<String, Object> params = new HashMap<>();
        params.put("teacherDto", new TeacherDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addTeacherPost(@ModelAttribute TeacherDto teacherDto) {
        service.addTeacher(teacherDto);
        return new ModelAndView("redirect:/admin/teacher/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updateTeacherGet(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("adminTeacher/updateTeacher");
        Map<String, Object> params = new HashMap<>();
        Teacher teacher = service.getTeachersById(id);
        TeacherDto teacherDto = new TeacherDto.Builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .middleName(teacher.getMiddleName())
                .build();
        params.put("teacherDto", teacherDto);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateTeacherPost(@ModelAttribute TeacherDto teacherDto,
                                          @PathVariable(value = "id") long id) {
        service.updateTeacher(teacherDto, id);
        return new ModelAndView("redirect:/admin/teacher/" + id);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteTeacherById(@PathVariable(value = "id") long id) {
        service.deleteTeacher(id);
        return new ModelAndView("redirect:/admin/teacher/all");
    }

}
