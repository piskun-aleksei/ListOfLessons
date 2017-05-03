package com.bsuir.piskun.services.impl;


import com.bsuir.piskun.beans.Room;
import com.bsuir.piskun.dao.RoomDao;
import com.bsuir.piskun.exceptions.DaoException;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;


    @Override
    public List<Room> select() throws ServiceException {
        try {
            return roomDao.select();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Room select(String roomNumber) throws ServiceException {
        try {
            return roomDao.select(roomNumber);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void insert(Room data) throws ServiceException {
        try {
            roomDao.insert(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Room> select(Room data) throws ServiceException {
        try {
            return roomDao.select(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void delete(Room data) throws ServiceException {
        try {
            roomDao.delete(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public void update(Room data) throws ServiceException {
        try {
            roomDao.update(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Room> select(int startRecordNumber, int recordsNumber) throws ServiceException {
        try {
            return roomDao.select(startRecordNumber, recordsNumber);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getEntriesNumber() throws ServiceException {
        try {
            return roomDao.getEntriesNumber();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
