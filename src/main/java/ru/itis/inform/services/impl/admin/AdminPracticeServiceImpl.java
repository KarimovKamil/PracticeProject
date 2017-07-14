package ru.itis.inform.services.impl.admin;

import org.springframework.stereotype.Component;
import ru.itis.inform.models.Practice;
import ru.itis.inform.services.interfaces.admin.AdminPracticeService;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminPracticeServiceImpl implements AdminPracticeService {

    @Override
    public List<Practice> getAllPractices(String token) {
        return null;
    }

    @Override
    public Practice getPracticeById(String token, long id) {
        return null;
    }

    @Override
    public void addPractice(String token, Practice practice) {

    }

    @Override
    public void updatePractice(String token, Practice practice) {

    }

    @Override
    public void deletePractice(String token, long id) {

    }
}
