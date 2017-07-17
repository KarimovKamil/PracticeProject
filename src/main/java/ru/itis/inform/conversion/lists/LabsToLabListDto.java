package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.lists.LabListDto;
import ru.itis.inform.models.Lab;

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

    public LabListDto convert(List<Lab> labs){
        return new LabListDto(labs);
    }
}
