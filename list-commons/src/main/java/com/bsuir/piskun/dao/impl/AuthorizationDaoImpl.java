package com.bsuir.piskun.dao.impl;

import com.bsuir.piskun.beans.User;
import com.bsuir.piskun.constants.RowValues;
import com.bsuir.piskun.dao.AuthorizationDao;
import com.bsuir.piskun.exceptions.DaoException;
import com.bsuir.piskun.exceptions.HashCreationException;
import com.bsuir.piskun.util.HashCreator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationDaoImpl implements AuthorizationDao {

    private static final String INSERT_INTO_USERS = "INSERT INTO user" +
            " (login, password, username, surname, rank) VALUES" +
            " (?,?,?,?,?)";
    private static final String SELECT_BY_LOGIN_FROM_USERS = "SELECT id, login, password, username, surname, rank from user WHERE login = ?";
    private static final String SELECT_BY_LOGIN_AND_PASS_FROM_USERS = "SELECT id, login, password, username, surname, rank from user WHERE login = ? AND password = ?";
    private static final String SELECT_ALL_FROM_USERS = "SELECT id, login, password, username, surname, rank from user";
    private static final String UPDATE_USERS_BY_LOGIN = "UPDATE user SET (login, password, username, surname, rank) VALUES" +
            " (?,?,?,?,?) WHERE login = ?";

    @Autowired
    private DataSource dataSource;

    public void insert(User data) throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INTO_USERS);
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, HashCreator.encryptWithMD5(data.getPassword()));
            preparedStatement.setString(3, data.getName());
            preparedStatement.setString(4, data.getSurname());
            preparedStatement.setInt(5, data.getRank());
            preparedStatement.executeUpdate();
        } catch (SQLException | HashCreationException e) {
            throw new DaoException("SQl OR HASH CREATION FAILED", e);
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

    public List<User> select(User data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public User select(String login) throws DaoException {
        PreparedStatement preparedStatement = null;
        User user = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_LOGIN_FROM_USERS);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = setUser(new User(), rs);
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
        return user;
    }

    public User select(String login, String password) throws DaoException {
        PreparedStatement preparedStatement = null;
        User user = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_LOGIN_AND_PASS_FROM_USERS);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, HashCreator.encryptWithMD5(password));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = setUser(new User(), rs);
            }
        } catch (SQLException | HashCreationException e) {
            throw new DaoException("SQl OR HASH CREATION FAILED", e);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                //TODO.. Log this
            }
        }
        return user;
    }

    public List<User> select() throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ArrayList<User> users = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(setUser(new User(), rs));
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
        return users;
    }

    public void delete(User data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public void update(User data) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_USERS_BY_LOGIN);
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, HashCreator.encryptWithMD5(data.getPassword()));
            preparedStatement.setString(3, data.getName());
            preparedStatement.setString(4, data.getSurname());
            preparedStatement.setInt(5, data.getRank());
            preparedStatement.setString(6, data.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException | HashCreationException e) {
            throw new DaoException("SQl OR HASH CREATION FAILED", e);
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
    public List<User> select(int startRecordNumber, int recordsNumber) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getEntriesNumber() throws DaoException {
        throw new UnsupportedOperationException();
    }

    private User setUser(User user, ResultSet resultSet) throws SQLException {
        user.setUserId(resultSet.getInt(RowValues.USER_ID));
        user.setLogin(resultSet.getString(RowValues.LOGIN));
        user.setPassword(resultSet.getString(RowValues.PASSWORD));
        user.setName(resultSet.getString(RowValues.NAME));
        user.setSurname(resultSet.getString(RowValues.SURNAME));
        user.setRank(resultSet.getInt(RowValues.RANK));
        return user;
    }
}
