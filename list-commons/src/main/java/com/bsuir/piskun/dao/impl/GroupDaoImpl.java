package com.bsuir.piskun.dao.impl;

import com.bsuir.piskun.beans.Group;
import com.bsuir.piskun.beans.Student;
import com.bsuir.piskun.constants.RowValues;
import com.bsuir.piskun.dao.GroupDao;
import com.bsuir.piskun.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    private static final String SELECT_BY_GROUP_NUMBER_FROM_GROUP =
            "SELECT student.id, student.username, student.surname, student.student_card_number FROM groups"
                    + " INNER JOIN student ON groups.student_id = student.id WHERE groups.group_number = ?";
    private static final String SELECT_ALL_GROUP_NUMBERS = "SELECT id, lesson_name, lesson_type FROM lesson";
    private static final String ADD_STUDENT_TO_GROUP = "INSERT INTO groups (group_number, student_id) VALUES (?,?)";
    private static final String REMOVE_STUDENT_FROM_GROUP = "DELETE FROM groups WHERE group_number = ? AND student_id = ?";

    @Autowired
    private DataSource dataSource;

    public void insert(Group data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public List<Group> select(Group data) throws DaoException {
        throw new UnsupportedOperationException();
    }
    
    public Group select(String groupNumber) throws DaoException {
        PreparedStatement preparedStatement = null;
        Group group = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            group = new Group();
            group.setGroupNumber(groupNumber);
            preparedStatement = connection.prepareStatement(SELECT_BY_GROUP_NUMBER_FROM_GROUP);
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
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            group = new Group();
            preparedStatement = connection.prepareStatement(REMOVE_STUDENT_FROM_GROUP);
            preparedStatement.setString(1, group.getGroupNumber());
            preparedStatement.setInt(2, student.getStudentId());
            preparedStatement.executeUpdate();
            group.removeStudent(student);
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
    }

    @Override
    public void addStudent(Group group, Student student) throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            group = new Group();
            preparedStatement = connection.prepareStatement(ADD_STUDENT_TO_GROUP);
            preparedStatement.setString(1, group.getGroupNumber());
            preparedStatement.setInt(2, student.getStudentId());
            preparedStatement.executeUpdate();
            group.addStudent(student);
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
                groups.add(rs.getString(RowValues.GROUP_NUMBER));
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
        Student student = new Student();
        student.setUserId(resultSet.getInt(RowValues.ID));
        student.setStudentCardNumber(resultSet.getString(RowValues.STUDENT_CARD_NUMBER));
        student.setStudentName(resultSet.getString(RowValues.USERNAME));
        student.setStudentSurname(resultSet.getString(RowValues.SURNAME));
        group.addStudent(student);
        return group;
    }
}
