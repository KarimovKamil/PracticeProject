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
import ru.itis.inform.models.Student;
import ru.itis.inform.services.interfaces.admin.AdminStudentService;

import java.util.List;

import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponseGetAndDelete;
import static ru.itis.inform.controllers.utils.ResponseBuilder.buildResponsePostAndPut;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/student")
public class AdminStudentController {

    @Autowired
    AdminStudentService service;

    //TODO: DTO для ЛИСТА СТУДЕНТОВ
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getAllStudents() {
        List<Student> studentList = service.getAllStudents();
        return buildResponseGetAndDelete(null);
    }

    //TODO: DTO DLYA STUDENTA
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QueryResultDto> getStudentById(@PathVariable(value = "id") long id) {
        Student student = service.getStudentById(id);
        return buildResponseGetAndDelete(null);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<QueryResultDto> addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return buildResponsePostAndPut(null);
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<QueryResultDto> updateStudentById(@RequestBody Student student,
                                                             @PathVariable(value = "id") long id) {
        student.setId(id);
        service.updateStudent(student);
        return buildResponsePostAndPut(null);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<QueryResultDto> deleteStudentById(@PathVariable(value = "id") long id) {
        service.deleteStudent(id);
        return buildResponseGetAndDelete(Data.EMPTY_DTO());
    }

}
