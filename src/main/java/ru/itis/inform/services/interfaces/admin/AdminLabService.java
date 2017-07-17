package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.dto.LabDto;
import ru.itis.inform.models.Lab;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminLabService {

    List<Lab> getAllLabs();

    Lab getLabById(long id);

    void addLab(LabDto labDto);

    void updateLab(LabDto labDto, long id);

    void deleteLab(long id);

}
