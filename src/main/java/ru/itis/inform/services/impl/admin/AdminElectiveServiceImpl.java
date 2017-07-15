package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.conversion.ConversionListResultFactory;
import ru.itis.inform.dao.interfaces.ElectiveDao;
import ru.itis.inform.dto.ElectiveDto;
import ru.itis.inform.dto.lists.ElectiveListDto;
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
    @Autowired
    ConversionListResultFactory conversionListResultFactory;

    @Override
    public ElectiveListDto getAllElectives() {
        List<Elective> electiveList = electiveDao.findAll();
        ElectiveListDto electiveListDto = conversionListResultFactory.electivesToElectiveListDto(electiveList);
        return electiveListDto;
    }

    @Override
    public Elective getElectiveById(long id) {
        validationFactory.electiveExistenceById(id);
        return electiveDao.findById(id);
    }

    @Override
    public void addElective(ElectiveDto electiveDto) {
        validationFactory.verifyCourse(electiveDto.getCourse());
        validationFactory.verifyName(electiveDto.getName());
        electiveDao.insert(electiveDto);
    }

    @Override
    public void updateElective(ElectiveDto electiveDto, long id) {
        validationFactory.electiveExistenceById(id);
        validationFactory.verifyCourse(electiveDto.getCourse());
        validationFactory.verifyName(electiveDto.getName());
        electiveDao.update(electiveDto, id);
    }

    @Override
    public void deleteElective(long id) {
        validationFactory.electiveExistenceById(id);
        electiveDao.delete(id);
    }
}
