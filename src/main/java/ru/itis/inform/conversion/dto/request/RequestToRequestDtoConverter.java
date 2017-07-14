package ru.itis.inform.conversion.dto.request;

import ru.itis.inform.dto.RequestDto;
import ru.itis.inform.models.Request;

/**
 * Created by artur on 14.07.2017.
 */
public class RequestToRequestDtoConverter {

    private static volatile RequestToRequestDtoConverter instance;

    public static RequestToRequestDtoConverter getInstance() {
        RequestToRequestDtoConverter localInstance = instance;
        if (localInstance == null) {
            synchronized (RequestToRequestDtoConverter.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RequestToRequestDtoConverter();
                }
            }
        }
        return localInstance;
    }

    public RequestDto.Builder convert(Request request, RequestDto.Builder builder) {
        return builder
                .student(request.getStudent())
                .type(request.getType())
                .attributeId(request.getAttributeId());
    }
}
