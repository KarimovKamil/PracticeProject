package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.LabDto;
import ru.itis.inform.models.Lab;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class LabListDto implements Data {

    List<Lab> labList;

    public LabListDto() {
    }

    public LabListDto(List<Lab> labList) {
        this.labList = labList;
    }

    public List<Lab> getLabList() {
        return labList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabListDto that = (LabListDto) o;
        return Objects.equals(labList, that.labList);
    }
}
