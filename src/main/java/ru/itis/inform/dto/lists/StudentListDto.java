package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.StudentDto;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class StudentListDto implements Data {

    List<StudentDto> studentDtoList;

    public StudentListDto() {
    }

    public StudentListDto(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }

    public List<StudentDto> getStudentDtoList() {
        return studentDtoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentListDto that = (StudentListDto) o;
        return Objects.equals(studentDtoList, that.studentDtoList);
    }
}
