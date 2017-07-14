package ru.itis.inform.services.impl.admin;

import org.springframework.stereotype.Component;
import ru.itis.inform.models.Elective;
import ru.itis.inform.services.interfaces.admin.AdminElectiveService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminElectiveServiceImpl implements AdminElectiveService {

    @Override
    public List<Elective> getAllElectives(String token) {
        return null;
    }

    @Override
    public Elective getElectiveById(String token, long id) {
        return null;
    }

    @Override
    public void addElective(String token, Elective elective) {

    }

    @Override
    public void updateElective(String token, Elective elective) {

    }

    @Override
    public void deleteElective(String token, long id) {

    }
}
