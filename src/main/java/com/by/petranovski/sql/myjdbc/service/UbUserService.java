package com.by.petranovski.sql.myjdbc.service;

import com.by.petranovski.sql.myjdbc.dao.Dao;

public class UbUserService {

    Dao userDao;

    public UbUserService(Dao userDao) {
        this.userDao = userDao;
    }
}
