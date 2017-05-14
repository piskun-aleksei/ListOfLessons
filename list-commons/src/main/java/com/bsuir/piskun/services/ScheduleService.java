package com.bsuir.piskun.services;

import com.bsuir.piskun.beans.*;
import com.bsuir.piskun.exceptions.ServiceException;

public interface ScheduleService extends BasicService<GroupSchedule> {
    GroupSchedule select(String groupNumber) throws ServiceException;

    void addLesson(String dateTime, Group group, Teacher teacher, Lesson lesson, Room room) throws ServiceException;

    void removeLesson(Group group, String dateTime) throws ServiceException;

    GroupSchedule select(String groupNumber, int lessonId) throws ServiceException;
}
