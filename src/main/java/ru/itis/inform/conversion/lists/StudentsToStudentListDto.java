package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Student;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yoko on 15.07.2017.
 */
public class StudentsToStudentListDto {

    private static volatile StudentsToStudentListDto instance;

    public static StudentsToStudentListDto getInstance() {
        StudentsToStudentListDto localInstance = instance;
        if (localInstance == null) {
            synchronized (StudentsToStudentListDto.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new StudentsToStudentListDto();
                }
            }
        }
        return localInstance;
    }

    public List<StudentDto.Builder> convert(List<Student> students, List<StudentDto.Builder> builders){
        Iterator<Student> iterator = students.iterator();
        builders.forEach(builder -> {
            Student student = iterator.next();
            builder = builder
                    .course(student.getCourse())
                    .teacherId(student.getTeacher().getId())
                    .electiveId(student.getElectiveId())
                    .firstName(student.getFirstName())
                    .group(student.getGroup())
                    .labId(student.getLabId())
                    .lastName(student.getLastName())
                    .middleName(student.getMiddleName())
                    .practiceId(student.getPracticeId());
        });
        return builders;
    }
}
