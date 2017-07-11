package ru.itis.inform.dao.interfaces;

import ru.itis.inform.model.Request;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface RequestDao {

    List<Request> findAll();

    Request findById(long id);

    void insert(Request request);

    void update(Request request, long id);

    void delete(long id);

}
