package ru.itis.inform.configs;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itis.inform.controllers.admin.*;
import ru.itis.inform.controllers.student.StudentController;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.exceptions.PermissionException;
import ru.itis.inform.security.TokenAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kamil Karimov on 18.07.2017.
 */
@ControllerAdvice(assignableTypes = {
        AdminController.class, AdminElectiveController.class, AdminLabController.class,
        AdminPracticeController.class, AdminStudentController.class, AdminTeacherController.class,
        StudentController.class
})
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IncorrectDataException.class)
    public ModelAndView incorrectData(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        Map<String, String> params = new HashMap<>();
        params.put("message", e.getMessage());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @ExceptionHandler(PermissionException.class)
    public ModelAndView permitError(Exception e) {
        return incorrectData(e);
    }
}
