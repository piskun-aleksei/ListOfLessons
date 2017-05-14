package com.bsuir.piskun.dao.impl;

import com.bsuir.piskun.beans.*;
import com.bsuir.piskun.constants.LessonType;
import com.bsuir.piskun.constants.RowValues;
import com.bsuir.piskun.dao.ScheduleDao;
import com.bsuir.piskun.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScheduleDaoImpl implements ScheduleDao {

    private static final String SELECT_BY_GROUP_NUMBER_FROM_GROUP =
            "SELECT schedule_id, date_time, group_number, teacher.id as teacher_id, teacher.position, teacher.username, teacher.surname," +
                    "room.room_number, lesson.id as lesson_id, lesson.lesson_name," +
                    "lesson.lesson_type FROM schedule " +
                    "INNER JOIN teacher ON teacher.id = schedule.teacher_id " +
                    "INNER JOIN room ON room.id = schedule.room_id INNER JOIN lesson ON " +
                    "lesson.id = schedule.lesson_id WHERE group_number = ?";
    private static final String SELECT_BY_GROUP_NUMBER_AND_LESSON_ID_FROM_GROUP =
            "SELECT schedule_id, date_time, group_number, teacher.id as teacher_id, teacher.position, teacher.username, teacher.surname," +
                    "room.room_number, lesson.id as lesson_id, lesson.lesson_name," +
                    "lesson.lesson_type FROM schedule " +
                    "INNER JOIN teacher ON teacher.id = schedule.teacher_id " +
                    "INNER JOIN room ON room.id = schedule.room_id INNER JOIN lesson ON " +
                    "lesson.id = schedule.lesson_id WHERE group_number = ? AND schedule.lesson_id = ?";
    private static final String ADD_LESSON_TO_SCHEDULE = "INSERT INTO schedule (date_time, group_number," +
            " teacher_id, room_id, lesson_id) VALUES (?,?,?,?,?)";
    private static final String REMOVE_LESSON_FROM_SCHEDULE = "DELETE FROM schedule WHERE group_number = ?" +
            " AND date_time = ?";
    private static final String GET_STUDENT_IDS_BY_GROUP = "SELECT student_id, username, surname FROM groups INNER JOIN student ON groups.student_id = student.id WHERE group_number = ? ";
    private static final String GET_STUDENTS_MARK = "SELECT student_id, mark, absent FROM marks WHERE schedule_id = ?";

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

    @Override
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

    @Override
    public GroupSchedule select(String groupNumber, int lessonId) throws DaoException {
        PreparedStatement preparedStatement = null;
        PreparedStatement nestedStatement = null;
        GroupSchedule groupSchedule = new GroupSchedule();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(GET_STUDENT_IDS_BY_GROUP);
            preparedStatement.setString(1, groupNumber);
            ResultSet rs = preparedStatement.executeQuery();
            Map<Integer, StudentMarks> studentsMarks = new LinkedHashMap<>();
            while (rs.next()) {
                int id = rs.getInt(RowValues.STUDENT_ID);
                StudentMarks marks = new StudentMarks();
                marks.setStudentId(id);
                marks.setStudentName(rs.getString(RowValues.USERNAME));
                marks.setStudentSurname(rs.getString(RowValues.SURNAME));
                studentsMarks.put(id, marks);
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            preparedStatement = connection.prepareStatement(SELECT_BY_GROUP_NUMBER_AND_LESSON_ID_FROM_GROUP);
            preparedStatement.setString(1, groupNumber);
            preparedStatement.setInt(2, lessonId);
            rs = preparedStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                groupSchedule = addInfoToSchedule(groupSchedule, rs);
                nestedStatement = connection.prepareStatement(GET_STUDENTS_MARK);
                nestedStatement.setInt(1, groupSchedule.getCalendarLessons().get(i).getScheduleId());
                ResultSet nestedRs = nestedStatement.executeQuery();
                while (nestedRs.next()) {
                    StudentMarks marks = studentsMarks.get(nestedRs.getInt(RowValues.STUDENT_ID));
                    marks.addMark(nestedRs.getInt(RowValues.MARK), nestedRs.getBoolean(RowValues.ABSENT));
                }
                for (Map.Entry<Integer, StudentMarks> entry : studentsMarks.entrySet())
                {
                    StudentMarks value = entry.getValue();

                    if (value.getMarks().size() == i || value.getAbsents().size() == i) {
                        value.addMark(null, false);
                    }
                }
                i ++;
            }
            for (Integer key : studentsMarks.keySet()) {
                groupSchedule.addStudentMarks(studentsMarks.get(key));
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

    @Override
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

    @Override
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

        CalendarLesson calendarLesson = new CalendarLesson();
        calendarLesson.setScheduleId(resultSet.getInt(RowValues.SCHEDULE_ID));
        calendarLesson.setDate(resultSet.getDate(RowValues.DATE_TIME));
        calendarLesson.setGroupNumber(RowValues.GROUP_NUMBER);
        calendarLesson.setLesson(lesson);
        calendarLesson.setTeacher(teacher);
        calendarLesson.setRoomNumber(resultSet.getString(RowValues.ROOM_NUMBER));

        groupSchedule.addCalendarLesson(calendarLesson);
        return groupSchedule;
    }

}
