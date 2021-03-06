package ru.itis.inform.services.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.TeacherDao;
import ru.itis.inform.dto.TeacherDto;
import ru.itis.inform.models.Teacher;
import ru.itis.inform.services.interfaces.admin.AdminTeacherService;
import ru.itis.inform.validation.ValidationFactory;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
@Component
public class AdminTeacherServiceImpl implements AdminTeacherService {

    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ValidationFactory validationFactory;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.findAll();
    }

    @Override
    public List<Teacher> getAllWithoutEmpty() {
        List<Teacher> electives = teacherDao.findAll();
        electives.remove(0);
        return electives;
    }

    @Override
    public Teacher getTeachersById(long id) {
        validationFactory.teacherExistenceById(id);
        return teacherDao.findById(id);
    }

    @Override
    public void addTeacher(TeacherDto teacherDto) {
        teacherDao.insert(teacherDto);
    }

    @Override
    public void updateTeacher(TeacherDto teacherDto, long id) {
        validationFactory.teacherExistenceById(id);
        teacherDao.update(teacherDto, id);
    }

    @Override
    public void deleteTeacher(long id) {
        validationFactory.teacherExistenceById(id);
        teacherDao.delete(id);
    }
}
