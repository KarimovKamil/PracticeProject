package ru.itis.inform.dao.interfaces;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface RequestDao {

    List<Request> findAll();

    Request findById(long id);

    Request insert(Request Request);

    Request update(Request Request, long id);

    void delete(long id);

}
