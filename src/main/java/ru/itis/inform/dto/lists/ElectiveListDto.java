package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.models.Elective;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class ElectiveListDto implements Data {

    List<Elective> electiveList;

    public ElectiveListDto() {
    }

    public ElectiveListDto(List<Elective> electiveList) {
        this.electiveList = electiveList;
    }

    public List<Elective> getElectiveList() {
        return electiveList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectiveListDto that = (ElectiveListDto) o;
        return Objects.equals(electiveList, that.electiveList);
    }
}
