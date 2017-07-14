package ru.itis.inform.dao.interfaces;

import ru.itis.inform.dto.LabDto;
import ru.itis.inform.models.Lab;

import java.util.List;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
public interface LabDao {

    List<Lab> findAll();

    Lab findById(long id);

    void insert(LabDto labDto);

    void update(LabDto labDto, long id);

    void delete(long id);

}
