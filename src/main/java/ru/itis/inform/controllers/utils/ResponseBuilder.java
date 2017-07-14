package ru.itis.inform.controllers.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.response.QueryResultDto;
import ru.itis.inform.dto.response.QueryResultInfoDto;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * 13.07.2017.
 *
 * @author Maxim Romanov
 */
public class ResponseBuilder {

    public static ResponseEntity<QueryResultDto> buildResponseGetAndDelete(Data data) {
        HttpHeaders headers = HeaderCreator.createHttpHeaders();
        QueryResultInfoDto responseInfo = new QueryResultInfoDto("200", "success");
        QueryResultDto queryResultDto = new QueryResultDto(responseInfo, data);
        return new ResponseEntity<>(queryResultDto, headers, HttpStatus.OK);
    }

    public static ResponseEntity<QueryResultDto> buildResponsePostAndPut(Data data) {
        HttpHeaders headers = HeaderCreator.createHttpHeaders();
        QueryResultInfoDto responseInfo = new QueryResultInfoDto("201", "success");
        QueryResultDto queryResultDto = new QueryResultDto(responseInfo, data);
        return new ResponseEntity<>(queryResultDto, headers, CREATED);
    }

}
