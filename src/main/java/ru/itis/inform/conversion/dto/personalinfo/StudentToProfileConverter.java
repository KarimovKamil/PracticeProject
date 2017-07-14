package ru.itis.inform.conversion.dto.personalinfo;

import ru.itis.inform.dto.ProfileDto;
import ru.itis.inform.models.Student;

/**
 * Created by artur on 14.07.17.
 */
public class StudentToProfileConverter {

    private static volatile StudentToProfileConverter instance;

    public static StudentToProfileConverter getInstance() {
        StudentToProfileConverter localInstance = instance;
        if (localInstance == null) {
            synchronized (StudentToProfileConverter.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new StudentToProfileConverter();
                }
            }
        }
        return localInstance;
    }

    public ProfileDto.Builder convert(Student student, ProfileDto.Builder builder) {
        return builder
                .id(student.getuId())
                .firstName(student.getFirstName())
                .middleName(student.getMiddleName())
                .lastName(student.getLastName())
                .group(student.getGroup())
                .course(student.getCourse())
                .lab(student.getLab())
                .elective(student.getElective())
                .practice(student.getPractice())
                .teachersFirstName(student.getTeacher().getFirstName())
                .teachersLastName(student.getTeacher().getLastName());
    }
}
