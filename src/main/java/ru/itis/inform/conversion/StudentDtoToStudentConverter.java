package ru.itis.inform.conversion;

import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Student;
import ru.itis.inform.models.Teacher;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class StudentDtoToStudentConverter {
    private static volatile StudentDtoToStudentConverter instance;

    public static StudentDtoToStudentConverter getInstance() {
        StudentDtoToStudentConverter localInstance = instance;
        if (localInstance == null) {
            synchronized (StudentDtoToStudentConverter.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new StudentDtoToStudentConverter();
                }
            }
        }
        return localInstance;
    }

    public Student.Builder convert(StudentDto studentDto, Student.Builder builder, String hashPassword) {
        Teacher teacher = new Teacher.Builder()
                .id(studentDto.getTeacherId())
                .build();
        return (Student.Builder) builder
                .group(studentDto.getGroup())
                .course(studentDto.getCourse())
                .labId(studentDto.getLabId())
                .electiveId(studentDto.getElectiveId())
                .practiceId(studentDto.getPracticeId())
                .teacher(teacher)
                .firstName(studentDto.getFirstName())
                .middleName(studentDto.getMiddleName())
                .lastName(studentDto.getLastName())
                .login(studentDto.getLogin())
                .hashPassword(hashPassword);
    }
}
