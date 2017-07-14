package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.ElectiveDao;
import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.Elective;
import ru.itis.inform.services.interfaces.admin.AdminElectiveService;
import ru.itis.inform.validation.ValidationFactory;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminElectiveServiceImpl implements AdminElectiveService {

    @Autowired
    ElectiveDao electiveDao;
    @Autowired
    ValidationFactory validationFactory;

    @Override
    public List<Elective> getAllElectives() {
        return electiveDao.findAll();
    }

    @Override
    public Elective getElectiveById(long id) {
        validationFactory.electiveExistenceById(id);
        return electiveDao.findById(id);
    }

    //TODO: уточнить количество курсов
    @Override
    public void addElective(ElectiveDto electiveDto) {
        if (electiveDto.getName() == null || electiveDto.getName().isEmpty() ||
                electiveDto.getCourse() < 0 || electiveDto.getCourse() > 6) {
            throw new IncorrectDataException("Incorrect data");
        }
        electiveDao.insert(electiveDto);
    }

    @Override
    public void updateElective(ElectiveDto electiveDto, long id) {
        validationFactory.electiveExistenceById(id);
        if (electiveDto.getName() == null || electiveDto.getName().isEmpty() ||
                electiveDto.getCourse() < 0 || electiveDto.getCourse() > 6) {
            throw new IncorrectDataException("Incorrect data");
        }
        electiveDao.update(electiveDto, id);
    }

    @Override
    public void deleteElective(long id) {
        validationFactory.electiveExistenceById(id);
        electiveDao.delete(id);
    }
}
