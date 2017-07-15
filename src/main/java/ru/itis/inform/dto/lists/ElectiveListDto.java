package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.ElectiveDto;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class ElectiveListDto implements Data {

    List<ElectiveDto> electiveDtoList;

    public ElectiveListDto() {
    }

    public ElectiveListDto(List<ElectiveDto> electiveDtoList) {
        this.electiveDtoList = electiveDtoList;
    }

    public List<ElectiveDto> getElectiveDtoList() {
        return electiveDtoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectiveListDto that = (ElectiveListDto) o;
        return Objects.equals(electiveDtoList, that.electiveDtoList);
    }
}
