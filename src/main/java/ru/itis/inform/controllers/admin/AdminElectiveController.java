package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.response.QueryResultDto;
import ru.itis.inform.models.Elective;
import ru.itis.inform.services.interfaces.admin.AdminElectiveService;

import java.util.List;

import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponseGetAndDelete;
import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponsePostAndPut;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/elective")
public class AdminElectiveController {

    @Autowired
    AdminElectiveService service;

    //TODO: DTO для ЛИСТА ЭЛЕКТИВОВ
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getAllElectives() {
        List<Elective> electiveList = service.getAllElectives();
        return buildResponseGetAndDelete(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getElectiveById(@PathVariable(value = "id") long id) {
        Elective elective = service.getElectiveById(id);
        return buildResponseGetAndDelete(elective);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> addElective(@RequestBody Elective elective) {
        service.addElective(elective);
        return buildResponsePostAndPut(elective);
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<QueryResultDto> updateElectiveById(@RequestBody Elective elective,
                                                             @PathVariable(value = "id") long id) {
        elective.setId(id);
        service.updateElective(elective);
        return buildResponsePostAndPut(elective);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<QueryResultDto> deleteElectiveById(@PathVariable(value = "id") long id) {
        service.deleteElective(id);
        return buildResponseGetAndDelete(Data.EMPTY_DTO());
    }

}
