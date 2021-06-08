package com.by.petranovski.sql.myjdbc.service;

import com.by.petranovski.sql.myjdbc.bean.UbUser;
import com.by.petranovski.sql.myjdbc.dao.Dao;

import java.util.List;

public class UbUserService {

    Dao userDao;

    public UbUserService(Dao userDao) {
        this.userDao = userDao;
    }

    public void saveNewUser(UbUser user) {
        userDao.save(user);
    }

    List<UbUser> selectAllUsers() {
        return userDao.findAll();
    }

    UbUser selectUserById(Integer id) {
        return (UbUser) userDao.findById(id);
    }

    void deleteUser(UbUser user) {
        if (userDao.findById(user.getId()) != null) {
            userDao.delete(user);
        }
    }
}
