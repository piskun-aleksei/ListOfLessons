package com.bsuir.piskun.services.impl;

import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.dao.LessonDao;
import com.bsuir.piskun.exceptions.DaoException;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;


    @Override
    public List<Lesson> select() throws ServiceException {
        try {
            return lessonDao.select();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void insert(Lesson data) throws ServiceException {
        try {
            lessonDao.insert(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void delete(Lesson data) throws ServiceException {
        try {
            lessonDao.delete(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void update(Lesson data) throws ServiceException {
        try {
            lessonDao.update(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Lesson> select(int startRecordNumber, int recordsNumber) throws ServiceException {
        try {
            return lessonDao.select(startRecordNumber, recordsNumber);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getEntriesNumber() throws ServiceException {
        try {
            return lessonDao.getEntriesNumber();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
