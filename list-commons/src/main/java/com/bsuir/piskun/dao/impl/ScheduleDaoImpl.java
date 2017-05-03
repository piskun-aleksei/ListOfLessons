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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {

    private static final String SELECT_BY_GROUP_NUMBER_FROM_GROUP =
            "SELECT student.id, student.username, student.surname, student.student_card_number FROM groups"
                    + " INNER JOIN student ON groups.student_id = student.id WHERE groups.group_number = ?";
    private static final String SELECT_ALL_GROUP_NUMBERS = "SELECT id, lesson_name, lesson_type FROM lesson";
    private static final String ADD_STUDENT_TO_GROUP = "INSERT INTO groups (group_number, student_id) VALUES (?,?)";
    private static final String REMOVE_STUDENT_FROM_GROUP = "DELETE FROM groups WHERE group_number = ? AND student_id = ?";

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

    }

    @Override
    public void update(GroupSchedule data) throws DaoException {

    }


    public GroupSchedule select(String groupNumber) throws DaoException {
        return new GroupSchedule();
    }

    public void addLesson(Group group, Teacher teacher, Lesson lesson, LessonType lessonType, Room room) {

    }

    public void removeLesson(Group group, String dateTime) throws DaoException {

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

    private Group addUserToGroup(Group group, ResultSet resultSet) throws SQLException {
        /*Student student = new Student();
        student.setUserId(resultSet.getInt(RowValues.ID));
        student.setStudentCardNumber(resultSet.getString(RowValues.STUDENT_CARD_NUMBER));
        student.setStudentName(resultSet.getString(RowValues.USERNAME));
        student.setStudentSurname(resultSet.getString(RowValues.SURNAME));
        group.addStudent(student);
        */

        //TODO Implement all. Rework schedule bean.

        return group;
    }

}
