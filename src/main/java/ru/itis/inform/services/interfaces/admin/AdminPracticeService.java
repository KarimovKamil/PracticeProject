package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.dto.PracticeDto;
import ru.itis.inform.dto.lists.PracticeListDto;
import ru.itis.inform.models.Practice;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminPracticeService {

    PracticeListDto getAllPractices();

    Practice getPracticeById(long id);

    void addPractice(PracticeDto practiceDto);

    void updatePractice(PracticeDto practiceDto, long id);

    void deletePractice(long id);

}
