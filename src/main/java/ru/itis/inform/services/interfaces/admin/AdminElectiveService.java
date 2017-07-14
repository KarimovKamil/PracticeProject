package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Elective;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminElectiveService {

    List<Elective> getAllElectives(String token);

    Elective getElectiveById(String token, long id);

    void addElective(String token, Elective elective);

    void updateElective(String token, Elective elective);

    void deleteElective(String token, long id);

}
