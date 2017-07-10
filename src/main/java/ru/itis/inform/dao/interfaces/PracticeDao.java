package ru.itis.inform.dao.interfaces;

import ru.itis.inform.model.Practice;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface PracticeDao {

    List<Practice> findAll();

    Practice findById(long id);

    Practice insert(Practice Practice);

    Practice update(Practice Practice, long id);

    void delete(long id);

}
