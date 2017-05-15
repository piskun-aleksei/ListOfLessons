package com.bsuir.piskun.dao;

import com.bsuir.piskun.beans.Group;
import com.bsuir.piskun.beans.Student;
import com.bsuir.piskun.exceptions.DaoException;

import java.util.List;

public interface GroupDao extends BasicDao<Group> {

    List<String> select() throws DaoException;

    Group select(String groupNumber) throws DaoException;

    void removeStudent(Group group, Student student) throws DaoException;

    void addStudent(Group group, Student student) throws DaoException;
}
