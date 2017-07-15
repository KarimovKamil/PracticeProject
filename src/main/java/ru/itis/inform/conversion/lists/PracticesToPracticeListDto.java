package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.PracticeDto;
import ru.itis.inform.models.Practice;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yoko on 15.07.2017.
 */
public class PracticesToPracticeListDto {

    private static volatile PracticesToPracticeListDto instance;

    public static PracticesToPracticeListDto getInstance() {
        PracticesToPracticeListDto localInstance = instance;
        if (localInstance == null) {
            synchronized (PracticesToPracticeListDto.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PracticesToPracticeListDto();
                }
            }
        }
        return localInstance;
    }

    public List<PracticeDto.Builder> convert(List<Practice> practices, List<PracticeDto.Builder> builders){
        Iterator<Practice> iterator = practices.iterator();
        builders.forEach(builder -> {
            Practice practice = iterator.next();
            builder = builder
                    .name(practice.getName())
                    .course(practice.getCourse())
                    .startDate(practice.getStartDate())
                    .endDate(practice.getEndDate())
                    .teacher(practice.getTeacher().getId());
        });
        return builders;
    }
}
