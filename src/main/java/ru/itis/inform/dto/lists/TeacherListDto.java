package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.TeacherDto;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class TeacherListDto implements Data {

    List<TeacherDto> teacherDtoList;

    public TeacherListDto() {
    }

    public TeacherListDto(List<TeacherDto> teacherDtoList) {
        this.teacherDtoList = teacherDtoList;
    }

    public List<TeacherDto> getTeacherDtoList() {
        return teacherDtoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherListDto that = (TeacherListDto) o;
        return Objects.equals(teacherDtoList, that.teacherDtoList);
    }
}
