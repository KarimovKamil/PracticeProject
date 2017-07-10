package ru.itis.inform.dao.interfaces;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface LabDao {

    List<Lab> findAll();

    Lab findById(long id);

    Lab insert(Lab Lab);

    Lab update(Lab Lab, long id);

    void delete(long id);

}
