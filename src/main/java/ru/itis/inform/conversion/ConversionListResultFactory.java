package ru.itis.inform.conversion;

import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.lists.*;
import ru.itis.inform.dto.lists.*;
import ru.itis.inform.models.*;

import java.util.List;

/**
 * Created by Yoko on 15.07.2017.
 */
@Component
public class ConversionListResultFactory {

    public ElectiveListDto electivesToElectiveListDto(List<Elective> electiveList) {
        return ElectivesToElectiveListDto.getInstance().convert(electiveList);
    }

    public LabListDto labsToLabListDto(List<Lab> labList) {
        return LabsToLabListDto.getInstance().convert(labList);
    }

    public PracticeListDto practicesToPracticeListDto(List<Practice> practiceList) {
        return PracticesToPracticeListDto.getInstance().convert(practiceList);
    }

    public StudentListDto studentsToStudentListDto(List<Student> studentList) {
        return StudentsToStudentListDto.getInstance().convert(studentList);
    }

    public TeacherListDto teachersToTeacherListDto(List<Teacher> teacherList) {
        return TeachersToTeacherListDto.getInstance().convert(teacherList);
    }

    public RequestListDto requestsToRequestListDto(List<Request> requestList) {
        return RequestsToRequestListDto.getInstance().convert(requestList);
    }

}
