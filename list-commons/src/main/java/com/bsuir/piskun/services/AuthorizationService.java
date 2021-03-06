package com.bsuir.piskun.services;

import com.bsuir.piskun.beans.Student;
import com.bsuir.piskun.beans.Teacher;
import com.bsuir.piskun.beans.User;
import com.bsuir.piskun.exceptions.ServiceException;

import java.util.List;

public interface AuthorizationService extends BasicService <User> {
    User select(String login) throws ServiceException;

    Teacher select(int id) throws ServiceException;

    User select(String login, String password) throws ServiceException;

    List<User> select() throws ServiceException;

    List<Teacher> selectTeachers() throws ServiceException;

    void insertStudent(Student student, String group) throws ServiceException;
}
