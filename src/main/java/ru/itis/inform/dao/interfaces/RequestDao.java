package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Request;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface RequestDao {

    List<Request> findAll();

    List<Request> findAllActive();

    List<Request> findAllLabReq();

    List<Request> findAllElectiveReq();

    List<Request> findAllPracticeReq();

    List<Request> findAllLeaderReq();

    List<Request> findAllStudentReq(String token);

    Request findById(long id);

    void insert(Request request);

    void update(Request request, long id);

    void delete(long id);

}
