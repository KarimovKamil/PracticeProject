package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.lists.StudentListDto;
import ru.itis.inform.models.Student;

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

    public StudentListDto convert(List<Student> students){
        return new StudentListDto(students);
    }
}
