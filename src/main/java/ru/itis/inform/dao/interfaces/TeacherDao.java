package ru.itis.inform.dao.interfaces;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface TeacherDao {

    List<Teacher> findAll();

    Teacher findById(long id);

    Teacher insert(Teacher Teacher);

    Teacher update(Teacher Teacher, long id);

    void delete(long id);

}
