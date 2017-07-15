package ru.itis.inform.conversion;

import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.User;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class StudentDtoToUserConverter {
    private static volatile StudentDtoToUserConverter instance;

    public static StudentDtoToUserConverter getInstance() {
        StudentDtoToUserConverter localInstance = instance;
        if (localInstance == null) {
            synchronized (StudentDtoToUserConverter.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new StudentDtoToUserConverter();
                }
            }
        }
        return localInstance;
    }

    public User.Builder convert(StudentDto studentDto, User.Builder builder) {
        return builder
                .firstName(studentDto.getFirstName())
                .middleName(studentDto.getMiddleName())
                .lastName(studentDto.getLastName());
    }
}
