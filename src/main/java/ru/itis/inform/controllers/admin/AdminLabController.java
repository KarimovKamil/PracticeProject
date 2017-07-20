package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dao.interfaces.LabDao;
import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.LabDto;
import ru.itis.inform.dto.response.QueryResultDto;
import ru.itis.inform.models.Lab;
import ru.itis.inform.services.interfaces.admin.AdminLabService;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponseGetAndDelete;
import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponsePostAndPut;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/lab")
public class AdminLabController {

    @Autowired
    AdminLabService service;
    @Autowired
    AdminTeacherService adminTeacherService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllLabs() {
        List<Lab> labList = service.getAllWithoutEmpty();
        ModelAndView modelAndView = new ModelAndView("adminLab/labs");
        Map<String, List<Lab>> params = new HashMap<>();
        params.put("labs", labList);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getLabById(@PathVariable(value = "id") long id) {
        Lab lab = service.getLabById(id);
        ModelAndView modelAndView = new ModelAndView("adminLab/lab");
        Map<String, Lab> params = new HashMap<>();
        params.put("lab", lab);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addLabGet() {
        ModelAndView modelAndView = new ModelAndView("adminLab/addLab");
        Map<String, Object> params = new HashMap<>();
        params.put("teachers", adminTeacherService.getAllTeachers());
        params.put("labDto", new LabDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addLabPost(@ModelAttribute LabDto labDto) {
        service.addLab(labDto);
        return new ModelAndView("redirect:/admin/lab/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updateLabGet(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("adminLab/updateLab");
        Map<String, Object> params = new HashMap<>();
        Lab lab = service.getLabById(id);
        LabDto labDto = new LabDto.Builder()
                .name(lab.getName())
                .teacherId(lab.getTeacher().getId())
                .build();
        params.put("teachers", adminTeacherService.getAllTeachers());
        params.put("labDto", labDto);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateLabPost(@ModelAttribute LabDto labDto,
                                      @PathVariable(value = "id") long id) {
        service.updateLab(labDto, id);
        return new ModelAndView("redirect:/admin/lab/" + id);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteLabById(@PathVariable(value = "id") long id) {
        service.deleteLab(id);
        return new ModelAndView("redirect:/admin/lab/all");
    }

}
