package com.bsuir.piskun.dao;

import com.bsuir.piskun.beans.Room;
import com.bsuir.piskun.exceptions.DaoException;

import java.util.List;

public interface RoomDao extends BasicDao<Room> {

    List<Room> select() throws DaoException;

    Room select(String roomNumber) throws DaoException;

}
