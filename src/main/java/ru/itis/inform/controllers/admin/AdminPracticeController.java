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
import ru.itis.inform.models.Practice;
import ru.itis.inform.services.interfaces.admin.AdminPracticeService;

import java.util.List;

import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponseGetAndDelete;
import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponsePostAndPut;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/practice")
public class AdminPracticeController {

    @Autowired
    AdminPracticeService service;

    //TODO: DTO для ЛИСТА ПРАКТИК
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getAllPractices() {
        List<Practice> practiceList = service.getAllPractices();
        return buildResponseGetAndDelete(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getPracticeById(@PathVariable(value = "id") long id) {
        Practice practice = service.getPracticeById(id);
        return buildResponseGetAndDelete(practice);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> addPractice(@RequestBody Practice practice) {
        service.addPractice(practice);
        return buildResponsePostAndPut(practice);
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<QueryResultDto> updatePracticeById(@RequestBody Practice practice,
                                                             @PathVariable(value = "id") long id) {
        practice.setId(id);
        service.updatePractice(practice);
        return buildResponsePostAndPut(practice);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<QueryResultDto> deletePracticeById(@PathVariable(value = "id") long id) {
        service.deletePractice(id);
        return buildResponseGetAndDelete(Data.EMPTY_DTO());
    }

}
