package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.models.Elective;
import ru.itis.inform.services.interfaces.admin.AdminElectiveService;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/elective")
public class AdminElectiveController {

    @Autowired
    AdminElectiveService service;
    @Autowired
    AdminTeacherService adminTeacherService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllElectives() {
        ModelAndView modelAndView = new ModelAndView("electives");
        Map<String, List<Elective>> params = new HashMap<>();
        params.put("electives", service.getAllElectives());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getElectiveById(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("elective");
        Map<String, Elective> params = new HashMap<>();
        params.put("elective", service.getElectiveById(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public ModelAndView addElective() {
//        ModelAndView modelAndView = new ModelAndView("addelective");
//        Map<String, Object> params = new HashMap<>();
//        params.put("teachers", adminTeacherService.getAllTeachers());
//        params.put("electiveDto", new ElectiveDto());
//        modelAndView.addAllObjects(params);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ModelAndView addElective(@ModelAttribute("electiveDto") ElectiveDto electiveDto) {
//        service.addElective(electiveDto);
//        return new ModelAndView("redirect:/admin/elective/all");
//    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addElective(Model model) {
        model.addAttribute("electiveDto", new ElectiveDto());
        model.addAttribute("teachers", adminTeacherService.getAllTeachers());
        return "addelective";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addElective1(@ModelAttribute("electiveDto") ElectiveDto electiveDto,
                              Model model) {
        service.addElective(electiveDto);
        return "redirect:/admin/elective/all";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updateElectiveById(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("updateelective");
        Map<String, Object> params = new HashMap<>();
        params.put("teachers", adminTeacherService.getAllTeachers());
        params.put("elective", service.getElectiveById(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateElectiveById(@ModelAttribute ElectiveDto electiveDto,
                                           @PathVariable(value = "id") long id) {
        service.updateElective(electiveDto, id);
        return new ModelAndView("redirect:/admin/elective/" + id);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteElectiveById(@PathVariable(value = "id") long id) {
        service.deleteElective(id);
        return new ModelAndView("redirect:/admin/elective/all");
    }

}
