package com.bsuir.piskun.services.impl;

import com.bsuir.piskun.beans.Group;
import com.bsuir.piskun.beans.Student;
import com.bsuir.piskun.dao.GroupDao;
import com.bsuir.piskun.exceptions.DaoException;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<String> select() throws ServiceException {
        try {
            return groupDao.select();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void insert(Group data) throws ServiceException {
        try {
            groupDao.insert(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void delete(Group data) throws ServiceException {
        try {
            groupDao.delete(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void update(Group data) throws ServiceException {
        try {
            groupDao.update(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Group> select(int startRecordNumber, int recordsNumber) throws ServiceException {
        try {
            return groupDao.select(startRecordNumber, recordsNumber);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getEntriesNumber() throws ServiceException {
        try {
            return groupDao.getEntriesNumber();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Group select(String groupNumber) throws ServiceException {
        try {
            return groupDao.select(groupNumber);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeStudent(Group group, Student student) throws ServiceException {
        try {
            groupDao.removeStudent(group, student);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addStudent(Group group, Student student) throws ServiceException {
        try {
            groupDao.addStudent(group, student);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
