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
    public List<Practice> getAllPractices() {
        return null;
    }

    @Override
    public Practice getPracticeById(long id) {
        return null;
    }

    @Override
    public void addPractice(Practice practice) {

    }

    @Override
    public void updatePractice(Practice practice) {

    }

    @Override
    public void deletePractice(long id) {

    }
}
