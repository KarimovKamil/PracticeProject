package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.LabDto;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class LabListDto implements Data {

    List<LabDto> labDtoList;

    public LabListDto() {
    }

    public LabListDto(List<LabDto> labDtoList) {
        this.labDtoList = labDtoList;
    }

    public List<LabDto> getLabDtoList() {
        return labDtoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabListDto that = (LabListDto) o;
        return Objects.equals(labDtoList, that.labDtoList);
    }
}
