package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.models.Elective;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminElectiveService {

    List<Elective> getAllElectives();

    List<Elective> getAllWithoutEmpty();

    Elective getElectiveById(long id);

    void addElective(ElectiveDto electiveDto);

    void updateElective(ElectiveDto electiveDto, long id);

    void deleteElective(long id);

}
