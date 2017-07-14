package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Elective;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminElectiveService {

    List<Elective> getAllElectives();

    Elective getElectiveById(long id);

    void addElective(Elective elective);

    void updateElective(Elective elective);

    void deleteElective(long id);

}
