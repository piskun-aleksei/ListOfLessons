package com.bsuir.piskun.services;

import com.bsuir.piskun.beans.Group;
import com.bsuir.piskun.beans.Student;
import com.bsuir.piskun.exceptions.ServiceException;

import java.util.List;

public interface GroupService extends BasicService<Group> {

    List<String> select() throws ServiceException;

    Group select(String groupNumber) throws ServiceException;

    void removeStudent(Group group, Student student) throws ServiceException;

    void addStudent(Group group, Student student) throws ServiceException;

}
