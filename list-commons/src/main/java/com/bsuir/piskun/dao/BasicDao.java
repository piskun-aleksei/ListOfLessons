package com.bsuir.piskun.dao;

import com.bsuir.piskun.exceptions.DaoException;

import java.util.List;

public interface BasicDao<T> {
    public void insert(T data) throws DaoException;

    public List<T> select(T data) throws DaoException;

    public void delete(T data) throws DaoException;

    public void update(T data) throws DaoException;

    public List <T> select (int startRecordNumber, int recordsNumber) throws DaoException;

    public int getEntriesNumber() throws DaoException;
}
