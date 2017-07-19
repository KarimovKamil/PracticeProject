package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.PracticeDao;
import ru.itis.inform.dto.PracticeDto;
import ru.itis.inform.models.Practice;
import ru.itis.inform.services.interfaces.admin.AdminPracticeService;
import ru.itis.inform.validation.ValidationFactory;

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
    public List<Practice> getAllWithoutEmpty() {
        List<Practice> electives = practiceDao.findAll();
        electives.remove(0);
        return electives;
    }

    @Override
    public Practice getPracticeById(long id) {
        validationFactory.practiceExistenceById(id);
        return practiceDao.findById(id);
    }

    @Override
    public void addPractice(PracticeDto practiceDto) {
        validationFactory.teacherExistenceById(practiceDto.getTeacherId());
        validationFactory.verifyCourse(practiceDto.getCourse());
        validationFactory.verifyName(practiceDto.getName());
        validationFactory.verifyDate(practiceDto.getStartDate(), practiceDto.getEndDate());
        if (practiceDto.getTeacherId() != 0) {
            validationFactory.teacherExistenceById(practiceDto.getTeacherId());
        }
        practiceDao.insert(practiceDto);
    }

    @Override
    public void updatePractice(PracticeDto practiceDto, long id) {
        validationFactory.practiceExistenceById(id);
        validationFactory.teacherExistenceById(practiceDto.getTeacherId());
        validationFactory.verifyCourse(practiceDto.getCourse());
        validationFactory.verifyName(practiceDto.getName());
        validationFactory.verifyDate(practiceDto.getStartDate(), practiceDto.getEndDate());
        if (practiceDto.getTeacherId() != 0) {
            validationFactory.teacherExistenceById(practiceDto.getTeacherId());
        }
        practiceDao.update(practiceDto, id);
    }

    @Override
    public void deletePractice(long id) {
        validationFactory.practiceExistenceById(id);
        practiceDao.delete(id);
    }
}
