package com.by.petranovski.sql.myjdbc.dao;

import com.by.petranovski.sql.myjdbc.bean.UbUser;

import java.sql.Connection;
import java.sql.Statement;

import static com.by.petranovski.sql.myjdbc.config.JisAtLocal.getConnection;
import static com.by.petranovski.sql.myjdbc.dao.Queries.UPDATE_NAME_AND_LIKES_BY_ID;

public class UserDao implements Dao<UbUser, Integer>{

    @Override
    public void save(UbUser ubUser) {
        String id = null;
        if (ubUser.getId() != null) {
            id = ubUser.getId().toString();
        }
        String sql = String.format(UPDATE_NAME_AND_LIKES_BY_ID,
                ubUser.getName(), ubUser.getLikes(), id);
        try (Connection connection = getConnection();
             Statement st = connection.createStatement()) {
            int rowsUpdated = st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public UbUser findAll() {
        return null;
    }

    @Override
    public UbUser findById(Integer id) {
        return null;
    }

    @Override
    public void delete(UbUser ubUser) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
