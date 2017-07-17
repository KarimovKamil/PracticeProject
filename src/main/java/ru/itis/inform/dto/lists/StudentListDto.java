package ru.itis.inform.dto.lists;

import ru.itis.inform.dto.Data;
import ru.itis.inform.dto.StudentDto;
import ru.itis.inform.models.Student;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yoko on 15.07.2017.
 */
public class StudentListDto implements Data {

    List<Student> studentList;

    public StudentListDto() {
    }

    public StudentListDto(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentListDto that = (StudentListDto) o;
        return Objects.equals(studentList, that.studentList);
    }
}
