package com.bsuir.piskun.dao.impl;

import com.bsuir.piskun.beans.Group;
import com.bsuir.piskun.beans.GroupSchedule;
import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.beans.Room;
import com.bsuir.piskun.beans.Teacher;
import com.bsuir.piskun.constants.LessonType;
import com.bsuir.piskun.constants.RowValues;
import com.bsuir.piskun.dao.ScheduleDao;
import com.bsuir.piskun.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {

    private static final String SELECT_BY_GROUP_NUMBER_FROM_GROUP =
            "SELECT date_time, group_number, teacher.id as teacher_id, teacher.position, teacher.username, teacher.surname," +
                    "room.room_number, lesson.id as lesson_id, lesson.lesson_name," +
                    "lesson.lesson_type FROM schedule" +
                    "INNER JOIN teacher ON teacher.id = schedule.teacher_id" +
                    "INNER JOIN room ON room.id = schedule.room_id INNER JOIN lesson ON " +
                    "lesson.id = schedule.lesson_id WHERE group_number = ?";
    private static final String ADD_LESSON_TO_SCHEDULE = "INSERT INTO schedule (date_time, group_number, teacher_id, room_id, lesson_id) VALUES (?,?,?,?,?)";
    private static final String REMOVE_LESSON_FROM_SCHEDULE = "DELETE FROM schedule WHERE group_number = ? AND date_time = ?";

    @Autowired
    private DataSource dataSource;

    @Override
    public void insert(GroupSchedule data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<GroupSchedule> select(GroupSchedule data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(GroupSchedule data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(GroupSchedule data) throws DaoException {
        throw new UnsupportedOperationException();
    }


    public GroupSchedule select(String groupNumber) throws DaoException {
        PreparedStatement preparedStatement = null;
        GroupSchedule groupSchedule = new GroupSchedule();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_GROUP_NUMBER_FROM_GROUP);
            preparedStatement.setString(1, groupNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                groupSchedule = addInfoToSchedule(groupSchedule, rs);
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
        return groupSchedule;
    }

    public void addLesson(String dateTime, Group group, Teacher teacher, Lesson lesson, Room room) throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(ADD_LESSON_TO_SCHEDULE);
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:MM:SS");
            java.util.Date parsed = format.parse(dateTime);
            Date sqlDate = new java.sql.Date(parsed.getTime());
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setString(2, group.getGroupNumber());
            preparedStatement.setInt(3, teacher.getTeacherId());
            preparedStatement.setInt(4, room.getRoomId());
            preparedStatement.setInt(5, lesson.getLessonId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ParseException e) {
            throw new DaoException("SQL OR PARSE FAILED", e);
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

    public void removeLesson(Group group, String dateTime) throws DaoException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(REMOVE_LESSON_FROM_SCHEDULE);
            preparedStatement.setString(1, group.getGroupNumber());
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:MM:SS");
            java.util.Date parsed = format.parse(dateTime);
            Date sqlDate = new java.sql.Date(parsed.getTime());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.executeUpdate();
        } catch (SQLException | ParseException e) {
            throw new DaoException("SQL OR PARSE FAILED", e);
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
        throw new UnsupportedOperationException();
    }

    public void delete(Group data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public void update(Group data) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<GroupSchedule> select(int startRecordNumber, int recordsNumber) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getEntriesNumber() throws DaoException {
        throw new UnsupportedOperationException();
    }

    private GroupSchedule addInfoToSchedule(GroupSchedule groupSchedule, ResultSet resultSet) throws SQLException {
        Teacher teacher = new Teacher();
        Lesson lesson = new Lesson();

        teacher.setTeacherId(resultSet.getInt(RowValues.TEACHER_ID));
        teacher.setPosition(resultSet.getString(RowValues.POSITION));
        teacher.setTeacherName(resultSet.getString(RowValues.USERNAME));
        teacher.setTeacherSurname(resultSet.getString(RowValues.SURNAME));

        lesson.setLessonId(resultSet.getInt(RowValues.LESSON_ID));
        lesson.setLessonName(resultSet.getString(RowValues.LESSON_NAME));
        lesson.setLessonType(LessonType.getLessonTypeByValue(resultSet.getString(RowValues.LESSON_TYPE)));

        groupSchedule.addLesson(resultSet.getString(RowValues.ROOM_NUMBER), teacher, lesson, resultSet.getDate(RowValues.DATE_TIME));
        return groupSchedule;
    }

}
