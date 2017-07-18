package ru.itis.inform.validation;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Kamil Karimov on 15.07.2017.
 */
@Component
public class DataValidation {

    public boolean verifyCourse(int course) {
        return (course > 0 && course < 7);
    }

    public boolean verifyName(String name) {
        return (name != null && !name.isEmpty());
    }

    public boolean verifyDate(Date startDate, Date endDate) {
        return (startDate.before(endDate) && startDate.after(new Date()));
    }
}
