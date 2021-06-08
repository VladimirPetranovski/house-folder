package com.by.petranovski.sql.myjdbc.dao;

import com.by.petranovski.sql.myjdbc.bean.LightWeightUbUser;
import com.by.petranovski.sql.myjdbc.bean.UbUser;
import junit.framework.TestCase;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserDaoTest extends TestCase {

    public void testUpdateNameAndLikesById() {
        UserDao userDao = new UserDao();
        userDao.updateNameAndLikesById(2, "misha", 23);
        UbUser user = userDao.findById(2);
        assertEquals(java.util.Optional.of(23), Optional.of(user.getLikes()));
        assertEquals("misha", user.getName());
    }

    public void testPreparedFindById() {
        UserDao userDao = new UserDao();

        LocalDateTime timeStamp1 = LocalDateTime.now();
        for (int i = 0; i < 1000; i++) {
            userDao.findById(3);
        }
        LocalDateTime timeStamp2 = LocalDateTime.now();

        for (int i = 0; i < 1000; i++) {
            userDao.preparedFindById(3);
        }
        LocalDateTime timeStamp3 = LocalDateTime.now();

        System.out.println("Common " + Duration.between(timeStamp1, timeStamp2).toSeconds());
        System.out.println("Prepare " + Duration.between(timeStamp2, timeStamp3).toSeconds());
        System.out.println("Common/Prepare " + (Duration.between(timeStamp2, timeStamp3).toNanos())/(Duration.between(timeStamp2, timeStamp3).toNanos()));
    }

    public void testFindByIdLazy() {
        UserDao userDao = new UserDao();
        LightWeightUbUser user = userDao.findByIdLazy(1);
        System.out.println("user = " + user);
    }

    public void testMovingCursor() {
        UserDao userDao = new UserDao();
        userDao.movingCursor();
    }
}