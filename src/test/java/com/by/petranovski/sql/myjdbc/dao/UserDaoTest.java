package com.by.petranovski.sql.myjdbc.dao;

import com.by.petranovski.sql.myjdbc.bean.UbUser;
import junit.framework.TestCase;

import java.util.Optional;

public class UserDaoTest extends TestCase {

    public void testUpdateNameAndLikesById() {
        UserDao userDao = new UserDao();
        userDao.updateNameAndLikesById(2, "misha", 23);
        UbUser user = userDao.findById(2);
        assertEquals(java.util.Optional.of(23), Optional.of(user.getLikes()));
        assertEquals("misha", user.getName());
    }
}