package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Lab;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminLabService {

    List<Lab> getAllLabs(String token);

    Lab getLabById(String token, long id);

    void addLab(String token, Lab lab);

    void updateLab(String token, Lab lab);

    void deleteLab(String token, long id);

}
