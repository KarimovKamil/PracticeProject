package ru.itis.inform.controllers.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kamil Karimov on 06.07.2017.
 */
@Controller
public class StudentController {

    @ResponseBody
    @RequestMapping("/hi")
    public String gg() {
        return "hi";
    }
}
