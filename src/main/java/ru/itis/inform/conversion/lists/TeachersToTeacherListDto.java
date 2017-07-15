package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.TeacherDto;
import ru.itis.inform.models.Teacher;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yoko on 15.07.2017.
 */
public class TeachersToTeacherListDto {

    private static volatile TeachersToTeacherListDto instance;

    public static TeachersToTeacherListDto getInstance() {
        TeachersToTeacherListDto localInstance = instance;
        if (localInstance == null) {
            synchronized (TeachersToTeacherListDto.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TeachersToTeacherListDto();
                }
            }
        }
        return localInstance;
    }

    public List<TeacherDto.Builder> convert(List<Teacher> teachers, List<TeacherDto.Builder> builders){
        Iterator<Teacher> iterator = teachers.iterator();
        builders.forEach(builder -> {
            Teacher teacher = iterator.next();
            builder = builder
                    .middleName(teacher.getMiddleName())
                    .lastName(teacher.getLastName())
                    .firstName(teacher.getFirstName());
        });
        return builders;
    }
}
