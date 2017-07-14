package ru.itis.inform.conversion;

import ru.itis.inform.dto.RequestDto;
import ru.itis.inform.models.Request;
import ru.itis.inform.models.Student;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class RequestDtoToRequestConverter {

    private static volatile RequestDtoToRequestConverter instance;

    public static RequestDtoToRequestConverter getInstance() {
        RequestDtoToRequestConverter localInstance = instance;
        if (localInstance == null) {
            synchronized (RequestDtoToRequestConverter.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RequestDtoToRequestConverter();
                }
            }
        }
        return localInstance;
    }

    public Request.Builder convert(RequestDto requestDto, Request.Builder builder) {
        Student student = new Student.Builder()
                .id(requestDto.getStudentId())
                .build();
        return builder
                .student(student)
                .type(requestDto.getType())
                .attributeId(requestDto.getAttributeId());
    }
}
