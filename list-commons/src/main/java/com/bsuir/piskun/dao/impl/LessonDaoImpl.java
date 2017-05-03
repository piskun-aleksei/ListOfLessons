package com.bsuir.piskun.dao.impl;

import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.constants.LessonType;
import com.bsuir.piskun.constants.RowValues;
import com.bsuir.piskun.dao.LessonDao;
import com.bsuir.piskun.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LessonDao {

    private static final String INSERT_INTO_LESSON = "INSERT INTO lesson" +
            " (lesson_name, lesson_type) VALUES" +
            " (?,?)";
    private static final String SELECT_ALL_FROM_LESSON = "SELECT id, lesson_name, lesson_type FROM lesson";
    private static final String UPDATE_LESSON_BY_ID = "UPDATE lesson SET (lesson_name, lesson_type) VALUES" +
            " (?,?) WHERE id = ?";

    @Autowired
    private DataSource dataSource;

    public void insert(Lesson data) throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INTO_LESSON);
            preparedStatement.setString(1, data.getLessonName());
            preparedStatement.setString(2, data.getLessonType().toString());
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

    public List<Lesson> select(Lesson data) throws DaoException {
        throw new UnsupportedOperationException();
    }


    public List<Lesson> select() throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ArrayList<Lesson> lessons = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_LESSON);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                lessons.add(setLesson(new Lesson(), rs));
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
        return lessons;
    }

    public void delete(Lesson data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public void update(Lesson data) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_LESSON_BY_ID);
            preparedStatement.setString(1, data.getLessonName());
            preparedStatement.setString(2, data.getLessonType().toString());
            preparedStatement.setInt(3, data.getLessonId());
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
    public List<Lesson> select(int startRecordNumber, int recordsNumber) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getEntriesNumber() throws DaoException {
        throw new UnsupportedOperationException();
    }

    private Lesson setLesson(Lesson lesson, ResultSet resultSet) throws SQLException {
        lesson.setLessonId(resultSet.getInt(RowValues.ID));
        lesson.setLessonName(resultSet.getString(RowValues.LESSON_NAME));
        lesson.setLessonType(LessonType.getLessonTypeByValue(resultSet.getString(RowValues.LESSON_TYPE)));
        return lesson;
    }
}
