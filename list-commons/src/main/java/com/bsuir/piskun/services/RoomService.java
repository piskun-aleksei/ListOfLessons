package com.bsuir.piskun.services;

import com.bsuir.piskun.beans.Room;
import com.bsuir.piskun.exceptions.ServiceException;

import java.util.List;

public interface RoomService extends BasicService<Room> {

    List<Room> select() throws ServiceException;

    Room select(String roomNumber) throws ServiceException;
}
