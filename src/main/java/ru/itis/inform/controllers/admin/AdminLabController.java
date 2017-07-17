package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.LabDto;
import ru.itis.inform.dto.response.QueryResultDto;
import ru.itis.inform.models.Lab;
import ru.itis.inform.services.interfaces.admin.AdminLabService;

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

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public ResponseEntity<QueryResultDto> getAllLabs() {
//        LabListDto labListDto = service.getAllLabs();
//        return buildResponseGetAndDelete(labListDto);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getLabById(@PathVariable(value = "id") long id) {
        Lab lab = service.getLabById(id);
        return buildResponseGetAndDelete(lab);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> addLab(@RequestBody LabDto labDto) {
        service.addLab(labDto);
        return buildResponsePostAndPut(labDto);
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<QueryResultDto> updateLabById(@RequestBody LabDto labDto,
                                                             @PathVariable(value = "id") long id) {
        service.updateLab(labDto, id);
        return buildResponsePostAndPut(labDto);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<QueryResultDto> deleteLabById(@PathVariable(value = "id") long id) {
        service.deleteLab(id);
        return buildResponseGetAndDelete(Data.EMPTY_DTO());
    }

}
