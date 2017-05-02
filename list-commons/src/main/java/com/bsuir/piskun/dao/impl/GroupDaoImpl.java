package com.bsuir.piskun.dao.impl;

import com.bsuir.piskun.beans.Group;
import com.bsuir.piskun.beans.Student;
import com.bsuir.piskun.constants.RowValues;
import com.bsuir.piskun.dao.GroupDao;
import com.bsuir.piskun.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    private static final String INSERT_INTO_GROUP = "INSERT INTO groups" +
            " (group_number, student_id) VALUES" +
            " (?)";
    private static final String SELECT_BY_GROUP_NUMBER_FROM_GROUP = "SELECT student_id FROM groups WHERE group_number = ?";
    private static final String SELECT_ALL_GROUP_NUMBERS = "SELECT id, lesson_name, lesson_type FROM lesson";

    @Autowired
    private DataSource dataSource;

    public void insert(Group data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public List<Group> select(Group data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Transactional
    public Group select(String groupNumber) throws DaoException {
        PreparedStatement preparedStatement = null;
        Group group = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();


            /////TODO IMPLEMENT ALL METHODS - THis one is Transactional to get usernames;

            group = new Group();
            group.setGroupNumber(groupNumber);
            preparedStatement = connection.prepareStatement(SELECT_ALL_GROUP_NUMBERS);
            preparedStatement.setString(1, groupNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                group = addUserToGroup(new Group(), rs);
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
        return group;
    }

    @Override
    public void removeStudent(Group group, Student student) throws DaoException {

    }

    @Override
    public void addStudent(Group group, Student student) throws DaoException {

    }

    public List<String> select() throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ArrayList<String> groups = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_GROUP_NUMBERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                groups.add(rs.getString(RowValues.GROUP_NAME));
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
        return groups;
    }

    public void delete(Group data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public void update(Group data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Group> select(int startRecordNumber, int recordsNumber) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getEntriesNumber() throws DaoException {
        throw new UnsupportedOperationException();
    }

    private Group addUserToGroup(Group group, ResultSet resultSet) throws SQLException {
        ///group.addStudent(resultSet.getString(RowValues.GROUP_NAME));

        //TODO IMPLEMENT RIGHT
        return group;
    }
}
