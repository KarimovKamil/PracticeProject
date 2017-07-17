package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.lists.PracticeListDto;
import ru.itis.inform.models.Practice;

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

    public PracticeListDto convert(List<Practice> practices){
        return new PracticeListDto(practices);
    }
}
