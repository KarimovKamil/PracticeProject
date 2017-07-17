package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.ConversionListResultFactory;
import ru.itis.inform.dao.interfaces.LabDao;
import ru.itis.inform.dto.LabDto;
import ru.itis.inform.dto.lists.LabListDto;
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
    @Autowired
    ConversionListResultFactory conversionListResultFactory;

    @Override
    public LabListDto getAllLabs() {
        List<Lab> labList = labDao.findAll();
        LabListDto labListDto = conversionListResultFactory.labsToLabListDto(labList);
        return labListDto;
    }

    @Override
    public Lab getLabById(long id) {
        validationFactory.labExistenceById(id);
        return labDao.findById(id);
    }

    @Override
    public void addLab(LabDto labDto) {
        validationFactory.teacherExistenceById(labDto.getTeacherId());
        validationFactory.verifyName(labDto.getName());
        if (labDto.getTeacherId() != 0) {
            validationFactory.teacherExistenceById(labDto.getTeacherId());
        }
        labDao.insert(labDto);
    }

    @Override
    public void updateLab(LabDto labDto, long id) {
        validationFactory.labExistenceById(id);
        validationFactory.teacherExistenceById(labDto.getTeacherId());
        validationFactory.verifyName(labDto.getName());
        if (labDto.getTeacherId() != 0) {
            validationFactory.teacherExistenceById(labDto.getTeacherId());
        }
        labDao.update(labDto, id);
    }

    @Override
    public void deleteLab(long id) {
        validationFactory.labExistenceById(id);
        labDao.delete(id);
    }
}
