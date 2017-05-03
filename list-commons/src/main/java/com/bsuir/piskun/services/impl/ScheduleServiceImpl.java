package com.bsuir.piskun.services.impl;

import com.bsuir.piskun.beans.*;
import com.bsuir.piskun.dao.ScheduleDao;
import com.bsuir.piskun.exceptions.DaoException;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void insert(GroupSchedule data) throws ServiceException {
        try {
            scheduleDao.insert(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<GroupSchedule> select(GroupSchedule data) throws ServiceException {
        try {
            return scheduleDao.select(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void delete(GroupSchedule data) throws ServiceException {
        try {
            scheduleDao.delete(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void update(GroupSchedule data) throws ServiceException {
        try {
            scheduleDao.update(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<GroupSchedule> select(int startRecordNumber, int recordsNumber) throws ServiceException {
        try {
            return scheduleDao.select(startRecordNumber, recordsNumber);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getEntriesNumber() throws ServiceException {
        try {
            return scheduleDao.getEntriesNumber();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public GroupSchedule select(String groupNumber) throws ServiceException {
        try {
            return scheduleDao.select(groupNumber);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addLesson(String dateTime, Group group, Teacher teacher, Lesson lesson, Room room) throws ServiceException {
        try {
            scheduleDao.addLesson(dateTime, group, teacher, lesson, room);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeLesson(Group group, String dateTime) throws ServiceException {
        try {
            scheduleDao.removeLesson(group, dateTime);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
