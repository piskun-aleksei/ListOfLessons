package com.bsuir.piskun.dao;

import com.bsuir.piskun.exceptions.DaoException;

import java.util.List;

public interface BasicDao<T> {
    void insert(T data) throws DaoException;

    void delete(T data) throws DaoException;

    void update(T data) throws DaoException;

    List <T> select (int startRecordNumber, int recordsNumber) throws DaoException;

    int getEntriesNumber() throws DaoException;
}
