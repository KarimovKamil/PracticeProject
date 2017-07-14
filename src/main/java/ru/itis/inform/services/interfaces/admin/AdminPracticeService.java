package ru.itis.inform.services.interfaces.admin;

import ru.itis.inform.models.Practice;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public interface AdminPracticeService {

    List<Practice> getAllPractices();

    Practice getPracticeById(long id);

    void addPractice(Practice practice);

    void updatePractice(Practice practice);

    void deletePractice(long id);

}
