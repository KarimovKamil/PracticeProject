package ru.itis.inform.dao.interfaces;

import ru.itis.inform.model.Teacher;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface TeacherDao {

    List<Teacher> findAll();

    void findById(long id);

    void insert(Teacher teacher);

    void update(Teacher teacher, long id);

    void delete(long id);

}
