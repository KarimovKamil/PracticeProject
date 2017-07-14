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
import ru.itis.inform.models.Teacher;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;

import java.util.List;

import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponseGetAndDelete;
import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponsePostAndPut;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/teacher")
public class AdminTeacherController {

    @Autowired
    AdminTeacherService service;

    //TODO: DTO для ЛИСТА TEACHEROV
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getAllTeachers() {
        List<Teacher> teacherList = service.getAllTeachers();
        return buildResponseGetAndDelete(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getTeacherById(@PathVariable(value = "id") long id) {
        Teacher teacher = service.getTeachersById(id);
        return buildResponseGetAndDelete(teacher);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> addTeacher(@RequestBody Teacher teacher) {
        service.addTeacher(teacher);
        return buildResponsePostAndPut(teacher);
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<QueryResultDto> updateTeacherById(@RequestBody Teacher teacher,
                                                             @PathVariable(value = "id") long id) {
        teacher.setId(id);
        service.updateTeacher(teacher);
        return buildResponsePostAndPut(teacher);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<QueryResultDto> deleteTeacherById(@PathVariable(value = "id") long id) {
        service.deleteTeacher(id);
        return buildResponseGetAndDelete(Data.EMPTY_DTO());
    }

}
