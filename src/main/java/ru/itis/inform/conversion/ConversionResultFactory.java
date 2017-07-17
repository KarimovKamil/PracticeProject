package ru.itis.inform.conversion;

import org.springframework.stereotype.Component;
import ru.itis.inform.dto.ProfileDto;
import ru.itis.inform.dto.RequestDto;
import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Request;
import ru.itis.inform.models.Student;
import ru.itis.inform.models.User;

/**
 * 13.07.2017.
 *
 * @author Maxim Romanov
 */
@Component
public class ConversionResultFactory {

    public ProfileDto studentToProfileDto(Student student) {
        ProfileDto.Builder builder = new ProfileDto.Builder();
        builder = StudentToProfileConverter.getInstance().convert(student, builder);
        return builder.build();
    }

    public Request requestDtoToRequest(RequestDto requestDto) {
        Request.Builder builder = new Request.Builder();
        builder = RequestDtoToRequestConverter.getInstance().convert(requestDto, builder);
        return builder.build();
    }

    public User studentDtoToUser(StudentDto studentDto) {
        User.Builder builder = new User.Builder();
        builder = StudentDtoToUserConverter.getInstance().convert(studentDto, builder);
        return builder.build();
    }

    public Student studentDtoToStudent(StudentDto studentDto) {
        Student.Builder builder = new Student.Builder();
        builder = StudentDtoToStudentConverter.getInstance().convert(studentDto, builder);
        return builder.build();
    }
}
