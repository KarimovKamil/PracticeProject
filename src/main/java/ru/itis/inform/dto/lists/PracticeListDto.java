package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.PracticeDto;
import ru.itis.inform.models.Practice;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class PracticeListDto implements Data {

    List<Practice> practiceList;

    public PracticeListDto() {
    }

    public PracticeListDto(List<Practice> practiceDtoList) {
        this.practiceList = practiceDtoList;
    }

    public List<Practice> getPracticeList() {
        return practiceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeListDto that = (PracticeListDto) o;
        return Objects.equals(practiceList, that.practiceList);
    }
}
