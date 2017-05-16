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

    private static final String INSERT_INTO_USERS = "INSERT INTO users" +
            " (login, password, rank) VALUES" +
            " (?,?,?)";
    private static final String SELECT_BY_LOGIN_FROM_USERS = "SELECT id, login, password, rank from users WHERE login = ?";
    private static final String SELECT_BY_LOGIN_AND_PASS_FROM_USERS = "SELECT id, login, password, rank from users WHERE login = ? AND password = ?";
    private static final String SELECT_ALL_FROM_USERS = "SELECT id, login, password, rank from users";
    private static final String UPDATE_USERS_BY_LOGIN = "UPDATE users SET (login, password, rank) VALUES" +
            " (?,?,?) WHERE login = ?";

    @Autowired
    private DataSource dataSource;

    @Override
    public void insert(User data) throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INTO_USERS);
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, HashCreator.encryptWithMD5(data.getPassword()));
            preparedStatement.setInt(3, data.getRank());
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

    @Override
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

    @Override
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

    @Override
    public void delete(User data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(User data) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_USERS_BY_LOGIN);
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, HashCreator.encryptWithMD5(data.getPassword()));
            preparedStatement.setInt(3, data.getRank());
            preparedStatement.setString(4, data.getLogin());
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
        user.setUserId(resultSet.getInt(RowValues.ID));
        user.setLogin(resultSet.getString(RowValues.LOGIN));
        user.setPassword(resultSet.getString(RowValues.PASSWORD));
        user.setRank(resultSet.getInt(RowValues.RANK));
        return user;
    }
}
