package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.lists.TeacherListDto;
import ru.itis.inform.models.Teacher;

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

    public TeacherListDto convert(List<Teacher> teachers){
        return new TeacherListDto(teachers);
    }
}
