package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Practice;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminPracticeService {

    List<Practice> getAllPractices(String token);

    Practice getPracticeById(String token, long id);

    void addPractice(String token, Practice practice);

    void updatePractice(String token, Practice practice);

    void deletePractice(String token, long id);

}
