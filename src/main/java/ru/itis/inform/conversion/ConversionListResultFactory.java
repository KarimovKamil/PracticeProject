package ru.itis.inform.conversion;

import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.lists.*;
import ru.itis.inform.dto.*;
import ru.itis.inform.dto.lists.*;
import ru.itis.inform.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoko on 15.07.2017.
 */
@Component
public class ConversionListResultFactory {

    public ElectiveListDto electivesToElectiveListDto(List<Elective> electiveList) {
        List<ElectiveDto.Builder> builders = new ArrayList<>();
        List<ElectiveDto> electiveDtoList = new ArrayList<>();
        for (int i = 0; i < electiveList.size(); i++) {
            builders.add(new ElectiveDto.Builder());
        }
        builders = ElectivesToElectiveListDto.getInstance().convert(electiveList, builders);
        for (int i = 0; i < builders.size(); i++) {
            electiveDtoList.add(builders.get(i).build());
        }
        return new ElectiveListDto(electiveDtoList);
    }

    public LabListDto labsToLabListDto(List<Lab> labList) {
        List<LabDto.Builder> builders = new ArrayList<>();
        List<LabDto> labDtoList = new ArrayList<>();
        for (int i = 0; i < labList.size(); i++) {
            builders.add(new LabDto.Builder());
        }
        builders = LabsToLabListDto.getInstance().convert(labList, builders);
        for (int i = 0; i < builders.size(); i++) {
            labDtoList.add(builders.get(i).build());
        }
        return new LabListDto(labDtoList);
    }

    public PracticeListDto practicesToPracticeListDto(List<Practice> practiceList) {
        List<PracticeDto.Builder> builders = new ArrayList<>();
        List<PracticeDto> practiceDtoList = new ArrayList<>();
        for (int i = 0; i < practiceList.size(); i++) {
            builders.add(new PracticeDto.Builder());
        }
        builders = PracticesToPracticeListDto.getInstance().convert(practiceList, builders);
        for (int i = 0; i < builders.size(); i++) {
            practiceDtoList.add(builders.get(i).build());
        }
        return new PracticeListDto(practiceDtoList);
    }

    public StudentListDto studentsToStudentListDto(List<Student> studentList) {
        List<StudentDto.Builder> builders = new ArrayList<>();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            builders.add(new StudentDto.Builder());
        }
        builders = StudentsToStudentListDto.getInstance().convert(studentList, builders);
        for (int i = 0; i < builders.size(); i++) {
            studentDtoList.add(builders.get(i).build());
        }
        return new StudentListDto(studentDtoList);
    }

    public TeacherListDto teachersToTeacherListDto(List<Teacher> teacherList) {
        List<TeacherDto.Builder> builders = new ArrayList<>();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        for (int i = 0; i < teacherList.size(); i++) {
            builders.add(new TeacherDto.Builder());
        }
        builders = TeachersToTeacherListDto.getInstance().convert(teacherList, builders);
        for (int i = 0; i < builders.size(); i++) {
            teacherDtoList.add(builders.get(i).build());
        }
        return new TeacherListDto(teacherDtoList);
    }

    public RequestListDto requestsToRequestListDto(List<Request> requestList) {
        return RequestsToRequestListDto.getInstance().convert(requestList);
    }

}
