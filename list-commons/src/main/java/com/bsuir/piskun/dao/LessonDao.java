package com.bsuir.piskun.dao;

import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.exceptions.DaoException;

import java.util.List;

public interface LessonDao extends BasicDao<Lesson> {

    List<Lesson> select() throws DaoException;

}
