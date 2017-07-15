package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.PracticeDto;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class PracticeListDto implements Data {

    List<PracticeDto> practiceDtoList;

    public PracticeListDto() {
    }

    public PracticeListDto(List<PracticeDto> practiceDtoList) {
        this.practiceDtoList = practiceDtoList;
    }

    public List<PracticeDto> getPracticeDtoList() {
        return practiceDtoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeListDto that = (PracticeListDto) o;
        return Objects.equals(practiceDtoList, that.practiceDtoList);
    }
}
