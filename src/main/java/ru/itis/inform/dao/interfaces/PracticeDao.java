package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Practice;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface PracticeDao {

    List<Practice> findAll();

    Practice findById(long id);

    void insert(Practice practice);

    void update(Practice practice, long id);

    void delete(long id);

}
