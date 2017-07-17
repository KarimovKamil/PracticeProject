package ru.itis.inform.conversion.lists;

import ru.itis.inform.dto.lists.ElectiveListDto;
import ru.itis.inform.models.Elective;

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

    public ElectiveListDto convert(List<Elective> electives){
        return new ElectiveListDto(electives);
    }
}
