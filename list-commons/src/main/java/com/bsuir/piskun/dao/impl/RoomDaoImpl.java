package com.bsuir.piskun.dao.impl;

import com.bsuir.piskun.beans.Room;
import com.bsuir.piskun.constants.RowValues;
import com.bsuir.piskun.dao.RoomDao;
import com.bsuir.piskun.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    private static final String INSERT_INTO_ROOM = "INSERT INTO room" +
            " (room_number) VALUES (?)";
    private static final String SELECT_BY_NAME_FROM_ROOM = "SELECT id, room_number FROM room WHERE room_number = ?";
    private static final String SELECT_ALL_FROM_ROOM = "SELECT id, room_number FROM room";
    private static final String UPDATE_ROOM_BY_ID = "UPDATE room SET (room_number) VALUES" +
            " (?) WHERE id = ?";

    @Autowired
    private DataSource dataSource;

    @Override
    public void insert(Room data) throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INTO_ROOM);
            preparedStatement.setString(1, data.getRoomNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("SQl FAILED", e);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                //TODO.. Log this
            }
        }
    }

    @Override
    public List<Room> select() throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_ROOM);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                rooms.add(setRoom(new Room(), rs));
            }
        } catch (SQLException e) {
            throw new DaoException("SQL FAILED", e);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                //TODO.. Log this
            }
        }
        return rooms;
    }

    @Override
    public Room select(String roomNumber) throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Room room = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_NAME_FROM_ROOM);
            preparedStatement.setString(1, roomNumber);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                room = setRoom(new Room(), rs);
            }
        } catch (SQLException e) {
            throw new DaoException("SQL FAILED", e);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                //TODO.. Log this
            }
        }
        return room;
    }

    @Override
    public void delete(Room data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Room data) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_ROOM_BY_ID);
            preparedStatement.setString(1, data.getRoomNumber());
            preparedStatement.setInt(2, data.getRoomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("SQl FAILED", e);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                //TODO.. Log this
            }
        }
    }

    @Override
    public List<Room> select(int startRecordNumber, int recordsNumber) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getEntriesNumber() throws DaoException {
        throw new UnsupportedOperationException();
    }

    private Room setRoom(Room room, ResultSet resultSet) throws SQLException {
        room.setRoomId(resultSet.getInt(RowValues.ID));
        room.setRoomNumber(resultSet.getString(RowValues.ROOM_NUMBER));
        return room;
    }
}
