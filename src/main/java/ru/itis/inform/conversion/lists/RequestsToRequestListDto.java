package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.lists.RequestListDto;
import ru.itis.inform.models.Request;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yoko on 17.07.2017.
 */
public class RequestsToRequestListDto {

    private static volatile RequestsToRequestListDto instance;

    public static RequestsToRequestListDto getInstance() {
        RequestsToRequestListDto localInstance = instance;
        if (localInstance == null) {
            synchronized (RequestsToRequestListDto.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RequestsToRequestListDto();
                }
            }
        }
        return localInstance;
    }

    public RequestListDto convert(List<Request> requests){
        return new RequestListDto(requests);
    }

}
