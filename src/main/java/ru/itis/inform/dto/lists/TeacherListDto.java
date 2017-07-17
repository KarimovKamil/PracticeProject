package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.models.Teacher;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class TeacherListDto implements Data {

    List<Teacher> teacherList;

    public TeacherListDto() {
    }

    public TeacherListDto(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherListDto that = (TeacherListDto) o;
        return Objects.equals(teacherList, that.teacherList);
    }
}
