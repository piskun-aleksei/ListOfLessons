package com.bsuir.piskun.services;

import com.bsuir.piskun.exceptions.ServiceException;

import java.util.List;

public interface BasicService <T> {
    void insert(T data) throws ServiceException;

    List<T> select(T data) throws ServiceException;

    void delete(T data) throws ServiceException;

    void update(T data) throws ServiceException;

    List <T> select (int startRecordNumber, int recordsNumber) throws ServiceException;

    int getEntriesNumber() throws ServiceException;
}
