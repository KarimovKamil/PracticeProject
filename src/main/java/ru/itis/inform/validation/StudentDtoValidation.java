package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.StudentDao;
import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.exceptions.IncorrectDataException;

/**
 * Created by Kamil Karimov on 15.07.2017.
 */
@Component
public class StudentDtoValidation {

    @Autowired
    StudentDao studentDao;
    @Autowired
    ValidationFactory validationFactory;

    public void verifyStudentDto(StudentDto studentDto) {
        if (studentDto.getFirstName() == null && studentDto.getFirstName().length() < 1 &&
                studentDto.getFirstName().length() > 30) {
            throw new IncorrectDataException("Incorrect first name");
        }

        if (studentDto.getMiddleName() == null && studentDto.getMiddleName().length() < 1 &&
                studentDto.getMiddleName().length() > 30) {
            throw new IncorrectDataException("Incorrect middle name");
        }

        validationFactory.verifyCourse(studentDto.getCourse());

        if (studentDto.getTeacherId() != 0) {
            validationFactory.teacherExistenceById(studentDto.getTeacherId());
        }

        if (studentDto.getLabId() != 0) {
            validationFactory.labExistenceById(studentDto.getLabId());
        }

        if (studentDto.getElectiveId() != 0) {
            validationFactory.electiveExistenceById(studentDto.getElectiveId());
        }

        if (studentDto.getPracticeId() != 0) {
            validationFactory.practiceExistenceById(studentDto.getPracticeId());
        }
    }
}
