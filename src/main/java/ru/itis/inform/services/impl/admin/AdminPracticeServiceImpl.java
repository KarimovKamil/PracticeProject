package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.PracticeDao;
import ru.itis.inform.dto.PracticeDto;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.Practice;
import ru.itis.inform.services.interfaces.admin.AdminPracticeService;
import ru.itis.inform.validation.ValidationFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminPracticeServiceImpl implements AdminPracticeService {

    @Autowired
    PracticeDao practiceDao;
    @Autowired
    ValidationFactory validationFactory;

    @Override
    public List<Practice> getAllPractices() {
        return practiceDao.findAll();
    }

    @Override
    public Practice getPracticeById(long id) {
        validationFactory.practiceExistenceById(id);
        return practiceDao.findById(id);
    }

    @Override
    public void addPractice(PracticeDto practiceDto) {
        validationFactory.teacherExistenceById(practiceDto.getTeacherId());
        if (practiceDto.getName() == null || practiceDto.getName().isEmpty() ||
                practiceDto.getCourse() < 0 || practiceDto.getCourse() > 6 ||
                practiceDto.getStartDate().after(practiceDto.getEndDate()) ||
                practiceDto.getStartDate().before(new Date())) {
            throw new IncorrectDataException("Incorrect data");
        }
        practiceDao.insert(practiceDto);
    }

    @Override
    public void updatePractice(PracticeDto practiceDto, long id) {
        validationFactory.practiceExistenceById(id);
        validationFactory.teacherExistenceById(practiceDto.getTeacherId());
        if (practiceDto.getName() == null || practiceDto.getName().isEmpty() ||
                practiceDto.getCourse() < 0 || practiceDto.getCourse() > 6 ||
                practiceDto.getStartDate().after(practiceDto.getEndDate()) ||
                practiceDto.getStartDate().before(new Date())) {
            throw new IncorrectDataException("Incorrect data");
        }
        practiceDao.insert(practiceDto);
    }

    @Override
    public void deletePractice(long id) {
        validationFactory.practiceExistenceById(id);
        practiceDao.delete(id);
    }
}
