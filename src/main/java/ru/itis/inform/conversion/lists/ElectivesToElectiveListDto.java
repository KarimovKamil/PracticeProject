package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.models.Elective;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yoko on 15.07.2017.
 */
public class ElectivesToElectiveListDto {

    private static volatile ElectivesToElectiveListDto instance;

    public static ElectivesToElectiveListDto getInstance() {
        ElectivesToElectiveListDto localInstance = instance;
        if (localInstance == null) {
            synchronized (ElectivesToElectiveListDto.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ElectivesToElectiveListDto();
                }
            }
        }
        return localInstance;
    }

    public List<ElectiveDto.Builder> convert(List<Elective> electives, List<ElectiveDto.Builder> builders){
        Iterator<Elective> iterator = electives.iterator();
        builders.forEach(builder -> {
            Elective elective = iterator.next();
            builder = builder
                    .course(elective.getCourse())
                    .name(elective.getName())
                    .teacherId(elective.getTeacher().getId());
        });
        return builders;
    }
}
