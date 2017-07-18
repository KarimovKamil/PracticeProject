package ru.itis.inform.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Student;
import ru.itis.inform.services.interfaces.admin.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by The silly end on 7/14/2017.
 */
@Controller
@RequestMapping(value = "/admin/student")
public class AdminStudentController {

    @Autowired
    AdminStudentService service;
    @Autowired
    AdminTeacherService adminTeacherService;
    @Autowired
    AdminElectiveService adminElectiveService;
    @Autowired
    AdminLabService adminLabService;
    @Autowired
    AdminPracticeService adminPracticeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllStudents() {
        List<Student> studentList = service.getAllStudents();
        ModelAndView modelAndView = new ModelAndView("adminStudent/all");
        Map<String, List<Student>> params = new HashMap<>();
        params.put("students", studentList);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getStudentById(@PathVariable(value = "id") long id) {
        Student student = service.getStudentById(id);
        ModelAndView modelAndView = new ModelAndView("adminStudent/byId");
        Map<String, Student> params = new HashMap<>();
        params.put("student", student);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addStudentGet() {
        ModelAndView modelAndView = new ModelAndView("adminStudent/add");
        Map<String, Object> params = new HashMap<>();
        params.put("teachers", adminTeacherService.getAllTeachers());
        params.put("labs", adminLabService.getAllLabs());
        params.put("electives", adminElectiveService.getAllElectives());
        params.put("practices", adminPracticeService.getAllPractices());
        params.put("studentDto", new StudentDto());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addStudentPost(@ModelAttribute StudentDto studentDto) {
        service.addStudent(studentDto);
        return new ModelAndView("redirect:/admin/student/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updatePracticeGet(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("adminStudent/update");
        Map<String, Object> params = new HashMap<>();
        params.put("teachers", adminTeacherService.getAllTeachers());
        params.put("labs", adminLabService.getAllLabs());
        params.put("electives", adminElectiveService.getAllElectives());
        params.put("practices", adminPracticeService.getAllPractices());
        Student student = service.getStudentById(id);
        StudentDto studentDto = new StudentDto.Builder()
                .firstName(student.getFirstName())
                .middleName(student.getMiddleName())
                .lastName(student.getLastName())
                .group(student.getGroup())
                .course(student.getCourse())
                .electiveId(student.getElectiveId())
                .practiceId(student.getPracticeId())
                .labId(student.getLabId())
                .teacherId(student.getTeacher().getId())
                .login(student.getLogin())
                .password(student.getHashPassword())
                .build();
        params.put("studentDto", studentDto);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateStudentById(@ModelAttribute StudentDto studentDto,
                                          @PathVariable(value = "id") long id) {
        service.updateStudent(studentDto, id);
        return new ModelAndView("redirect:/admin/student/" + id);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteStudentById(@PathVariable(value = "id") long id) {
        service.deleteStudent(id);
        return new ModelAndView("redirect:/admin/student/all");
    }
}
