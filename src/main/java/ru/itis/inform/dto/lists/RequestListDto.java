package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.models.Request;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 17.07.2017.
 */
public class RequestListDto implements Data {

    List<Request> requestList;

    public RequestListDto() {
    }

    public RequestListDto(List<Request> requestList) {
        this.requestList = requestList;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestListDto that = (RequestListDto) o;
        return Objects.equals(requestList, that.requestList);
    }
}
