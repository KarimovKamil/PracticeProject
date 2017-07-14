package ru.itis.inform.conversion;

import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.dto.personalinfo.StudentToProfileConverter;
import ru.itis.inform.dto.ProfileDto;
import ru.itis.inform.models.Student;

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
}
