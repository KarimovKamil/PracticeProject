package ru.itis.inform.dao.interfaces;

import ru.itis.inform.model.Student;

import java.util.List;

/**
 * Created by Kamil Karimov on 06.07.2017.
 */
public interface StudentDao {

    List<Student> findAll();

    Student findById(long id);

    void insert(Student student);

    void update(Student student, long id);

    void delete(long id);

}
