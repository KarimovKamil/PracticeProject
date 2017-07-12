package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Elective;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface ElectiveDao {

    List<Elective> findAll();

    Elective findById(long id);

    void insert(Elective elective);

    void update(Elective elective, long id);

    void delete(long id);

}
