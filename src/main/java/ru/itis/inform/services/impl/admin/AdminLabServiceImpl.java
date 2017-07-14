package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.LabDao;
import ru.itis.inform.dto.LabDto;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.Lab;
import ru.itis.inform.services.interfaces.admin.AdminLabService;
import ru.itis.inform.validation.ValidationFactory;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminLabServiceImpl implements AdminLabService {

    @Autowired
    LabDao labDao;
    @Autowired
    ValidationFactory validationFactory;

    @Override
    public List<Lab> getAllLabs() {
        return labDao.findAll();
    }

    @Override
    public Lab getLabById(long id) {
        validationFactory.labExistenceById(id);
        return labDao.findById(id);
    }

    @Override
    public void addLab(LabDto labDto) {
        validationFactory.teacherExistenceById(labDto.getTeacherId());
        if (labDto.getName() == null || labDto.getName().isEmpty()) {
            throw new IncorrectDataException("Incorrect name");
        }
        labDao.insert(labDto);
    }

    @Override
    public void updateLab(LabDto labDto, long id) {
        validationFactory.labExistenceById(id);
        validationFactory.teacherExistenceById(labDto.getTeacherId());
        if (labDto.getName() == null || labDto.getName().isEmpty()) {
            throw new IncorrectDataException("Incorrect name");
        }
        labDao.update(labDto, id);
    }

    @Override
    public void deleteLab(long id) {
        validationFactory.labExistenceById(id);
        labDao.delete(id);
    }
}
