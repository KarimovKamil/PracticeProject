package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.LabDto;
import ru.itis.inform.models.Lab;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yoko on 15.07.2017.
 */
public class LabsToLabListDto {

    private static volatile LabsToLabListDto instance;

    public static LabsToLabListDto getInstance() {
        LabsToLabListDto localInstance = instance;
        if (localInstance == null) {
            synchronized (LabsToLabListDto.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new LabsToLabListDto();
                }
            }
        }
        return localInstance;
    }

    public List<LabDto.Builder> convert(List<Lab> labs, List<LabDto.Builder> builders){
        Iterator<Lab> iterator = labs.iterator();
        builders.forEach(builder -> {
            Lab lab = iterator.next();
            builder = builder
                    .teacherId(lab.getTeacher().getId())
                    .name(lab.getName());
        });
        return builders;
    }
}
