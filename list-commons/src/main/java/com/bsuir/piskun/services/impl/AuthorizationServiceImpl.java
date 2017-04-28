package com.bsuir.piskun.services.impl;

import com.bsuir.piskun.beans.User;
import com.bsuir.piskun.dao.AuthorizationDao;
import com.bsuir.piskun.exceptions.DaoException;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private AuthorizationDao authorizationDao;

    @Override
    public User select(String login) throws ServiceException {
        try {
            return authorizationDao.select(login);
        } catch (DaoException e) {
            throw new ServiceException (e);
        }
    }

    @Override
    public User select(String login, String password) throws ServiceException {
        try {
            return authorizationDao.select(login, password);
        } catch (DaoException e) {
            throw new ServiceException (e);
        }
    }

    @Override
    public List<User> select() throws ServiceException {
        try {
            return authorizationDao.select();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void insert(User data) throws ServiceException {
        try {
            authorizationDao.insert(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> select(User data) throws ServiceException {
        try {
            return authorizationDao.select(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void delete(User data) throws ServiceException {
        try {
            authorizationDao.delete(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void update(User data) throws ServiceException {
        try {
            authorizationDao.update(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> select(int startRecordNumber, int recordsNumber) throws ServiceException {
        try {
            return authorizationDao.select(startRecordNumber, recordsNumber);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getEntriesNumber() throws ServiceException {
        try {
            return authorizationDao.getEntriesNumber();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
