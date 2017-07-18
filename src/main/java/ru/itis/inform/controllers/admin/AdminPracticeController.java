package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.PracticeDto;
import ru.itis.inform.models.Practice;
import ru.itis.inform.services.interfaces.admin.AdminPracticeService;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/practice")
public class AdminPracticeController {

    @Autowired
    AdminPracticeService service;
    @Autowired
    AdminTeacherService teacherService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllPractices() {
        List<Practice> practiceList = service.getAllPractices();
        ModelAndView modelAndView = new ModelAndView("adminPractice/all");
        Map<String, List<Practice>> params = new HashMap<>();
        params.put("practices", practiceList);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getPracticeById(@PathVariable(value = "id") long id) {
        Practice practice = service.getPracticeById(id);
        ModelAndView modelAndView = new ModelAndView("adminPractice/byId");
        Map<String, Practice> params = new HashMap<>();
        params.put("practice", practice);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPracticeGet() {
        ModelAndView modelAndView = new ModelAndView("adminPractice/add");
        Map<String, Object> params = new HashMap<>();
        params.put("teachers", teacherService.getAllTeachers());
        params.put("practiceDto", new PracticeDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPracticePost(@ModelAttribute PracticeDto practiceDto) {
        service.addPractice(practiceDto);
        return new ModelAndView("redirect:/admin/practice/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updatePracticeGet(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("adminPractice/update");
        Map<String, Object> params = new HashMap<>();
        params.put("teachers", teacherService.getAllTeachers());
        Practice practice = service.getPracticeById(id);
        PracticeDto practiceDto = new PracticeDto.Builder()
                .course(practice.getCourse())
                .name(practice.getName())
                .startDate(practice.getStartDate())
                .endDate(practice.getEndDate())
                .teacher(practice.getTeacher().getId())
                .build();
        params.put("practiceDto", practiceDto);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updatePracticePost(@ModelAttribute PracticeDto practiceDto,
                                           @PathVariable(value = "id") long id) {
        service.updatePractice(practiceDto, id);
        return new ModelAndView("redirect:/admin/practice/" + id);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deletePracticeById(@PathVariable(value = "id") long id) {
        service.deletePractice(id);
        return new ModelAndView("redirect:/admin/practice/all");
    }
}
