package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.dto.response.QueryResultDto;
import ru.itis.inform.models.Elective;
import ru.itis.inform.models.Teacher;
import ru.itis.inform.services.interfaces.admin.AdminElectiveService;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponsePostAndPut;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addElective() {
        return new ModelAndView("addelective");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addElective(@RequestBody ElectiveDto electiveDto) {
        ModelAndView modelAndView = new ModelAndView("addelective");
        Map<String, List<Teacher>> params = new HashMap<>();
        params.put("teachers", adminTeacherService.getAllTeachers());
        modelAndView.addAllObjects(params);
        service.addElective(electiveDto);
        return new ModelAndView("redirect:/admin/elective/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updateElectiveById() {
        return new ModelAndView("updateelective");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<QueryResultDto> updateElectiveById(@RequestBody ElectiveDto electiveDto,
                                                             @PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("updateelective");
        Map<String, Object> params = new HashMap<>();
        params.put("teachers", adminTeacherService.getAllTeachers());
        params.put("elective", service.getElectiveById(id));
        modelAndView.addAllObjects(params);
        service.updateElective(electiveDto, id);
        return buildResponsePostAndPut(electiveDto);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ModelAndView deleteElectiveById(@PathVariable(value = "id") long id) {
        service.deleteElective(id);
        return new ModelAndView("redirect:/admin/elective/all");
    }

}
