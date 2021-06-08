package com.by.petranovski.sql.myjdbc.dao;

import com.by.petranovski.sql.myjdbc.bean.UbUser;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.by.petranovski.sql.myjdbc.config.JisAtLocal.getConnection;
import static com.by.petranovski.sql.myjdbc.dao.Queries.*;

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
    public List<UbUser> findAll() {

        List<UbUser> users = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_FROM_USER)) {
            while (rs.next()) {
                System.out.println("rs.getRow() = " + rs.getRow());
                UbUser user = mapResultSetToUser(rs);
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public UbUser findById(Integer id) {
        UbUser user = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(PREPARED_SELECT_USER_FIND_BY_ID)) {
            statement.setInt(1, 23);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("rs.getRow() = " + rs.getRow());
                user = mapResultSetToUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public void delete(UbUser ubUser) {
        deleteById(ubUser.getId());
    }

    @Override
    public void deleteById(Integer id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(PREPARED_DELETE_USER_BY_ID)) {
            statement.setInt(1, 23);
            ResultSet rs = statement.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private UbUser mapResultSetToUser(ResultSet rs) throws SQLException {
        return UbUser.builder()
                .id(rs.getInt("id"))
                .login(rs.getString("login"))
                .name(rs.getString("name"))
                .bio(rs.getString("bio"))
                .image(rs.getBytes("image"))
                .birth(LocalDate.parse(rs.getDate("birth").toString()))
                .registered(rs.getObject("registered", LocalDateTime.class))
                .updated(rs.getTimestamp("updated").toLocalDateTime())
                .gender(rs.getString("gender").charAt(0))
                .likes(rs.getInt("likes"))
                .credit(rs.getDouble("credit"))
                .active(rs.getBoolean("active"))
                .build();
    }
}
