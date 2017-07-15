package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.dto.lists.ElectiveListDto;
import ru.itis.inform.models.Elective;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminElectiveService {

    ElectiveListDto getAllElectives();

    Elective getElectiveById(long id);

    void addElective(ElectiveDto electiveDto);

    void updateElective(ElectiveDto electiveDto, long id);

    void deleteElective(long id);

}
