package ru.itis.inform.services.impl.admin;

import org.springframework.stereotype.Component;
import ru.itis.inform.models.Lab;
import ru.itis.inform.services.interfaces.admin.AdminLabService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminLabServiceImpl implements AdminLabService {

    @Override
    public List<Lab> getAllLabs(String token) {
        return null;
    }

    @Override
    public Lab getLabById(String token, long id) {
        return null;
    }

    @Override
    public void addLab(String token, Lab lab) {

    }

    @Override
    public void updateLab(String token, Lab lab) {

    }

    @Override
    public void deleteLab(String token, long id) {

    }
}
