package com.bsuir.piskun.dao;

import com.bsuir.piskun.beans.Group;
import com.bsuir.piskun.beans.GroupSchedule;
import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.beans.Room;
import com.bsuir.piskun.beans.Teacher;
import com.bsuir.piskun.constants.LessonType;
import com.bsuir.piskun.exceptions.DaoException;

public interface ScheduleDao extends BasicDao<GroupSchedule> {

    GroupSchedule select(String groupNumber) throws DaoException;

    void addLesson(String dateTime, Group group, Teacher teacher, Lesson lesson, Room room) throws DaoException;

    void removeLesson(Group group, String dateTime) throws DaoException;

}
