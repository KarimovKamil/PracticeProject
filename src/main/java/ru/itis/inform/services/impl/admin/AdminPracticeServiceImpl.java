package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.ConversionListResultFactory;
import ru.itis.inform.dao.interfaces.PracticeDao;
import ru.itis.inform.dto.PracticeDto;
import ru.itis.inform.dto.lists.PracticeListDto;
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
    @Autowired
    ConversionListResultFactory conversionListResultFactory;

    @Override
    public PracticeListDto getAllPractices() {
        List<Practice> practiceList = practiceDao.findAll();
        PracticeListDto practiceListDto = conversionListResultFactory.practicesToPracticeListDto(practiceList);
        return practiceListDto;
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
        practiceDao.insert(practiceDto);
    }

    @Override
    public void updatePractice(PracticeDto practiceDto, long id) {
        validationFactory.practiceExistenceById(id);
        validationFactory.teacherExistenceById(practiceDto.getTeacherId());
        validationFactory.verifyCourse(practiceDto.getCourse());
        validationFactory.verifyName(practiceDto.getName());
        validationFactory.verifyDate(practiceDto.getStartDate(), practiceDto.getEndDate());
        practiceDao.insert(practiceDto);
    }

    @Override
    public void deletePractice(long id) {
        validationFactory.practiceExistenceById(id);
        practiceDao.delete(id);
    }
}
