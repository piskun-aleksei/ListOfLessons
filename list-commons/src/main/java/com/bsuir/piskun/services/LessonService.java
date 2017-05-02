package com.bsuir.piskun.services;

import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.exceptions.ServiceException;

import java.util.List;

public interface LessonService extends BasicService<Lesson> {

    List<Lesson> select() throws ServiceException;
}
