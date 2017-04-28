package com.bsuir.piskun.dao;

import com.bsuir.piskun.beans.User;
import com.bsuir.piskun.exceptions.DaoException;

import java.util.List;

public interface AuthorizationDao extends BasicDao<User> {
    User select(String login) throws DaoException;

    User select(String login, String password) throws DaoException;

    List<User> select() throws DaoException;
}
