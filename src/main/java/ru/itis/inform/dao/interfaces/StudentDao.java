package ru.itis.inform.dao.interfaces;

import ru.itis.inform.model.Student;

import java.util.List;

/**
 * Created by Kamil Karimov on 06.07.2017.
 */
public interface StudentDao {

    List<Student> findAll();

    Student findById(long id);

    Student insert(Student Student);

    Student update(Student Student, long id);

    void delete(long id);

}
