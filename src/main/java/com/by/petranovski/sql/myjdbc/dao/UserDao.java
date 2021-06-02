package com.by.petranovski.sql.myjdbc.dao;

import com.by.petranovski.sql.myjdbc.bean.UbUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.by.petranovski.sql.myjdbc.config.JisAtLocal.getConnection;
import static com.by.petranovski.sql.myjdbc.dao.Queries.*;

public class UserDao {

    public List<UbUser> jdbcSyntax() {
        List<UbUser> users = new ArrayList<>();
        try (Connection connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(SELECT_ALL_FROM_USER)) {
            while (rs.next()) {
                System.out.println("rs.getRow() = " + rs.getRow());
                UbUser user = UbUser.builder()
                        .id(rs.getInt(1))
                        .login(rs.getString(2))
                        .name(rs.getString(3))
                        .bio(rs.getString(4))
//                    .image(rs.getBlob(5))
                        .birth(LocalDate.parse(rs.getDate(6).toString()))
                        .registered(rs.getObject(7, LocalDateTime.class))
                        .updated(rs.getTimestamp("updated").toLocalDateTime())
                        .gender(rs.getString(9).charAt(0))
                        .likes(rs.getInt(10))
                        .credit(rs.getDouble(11))
                        .active(rs.getBoolean(12))
                        .build();
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public List<UbUser> getAllFromUbUser() throws SQLException {
        Connection connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(SELECT_ALL_FROM_USER);
        List<UbUser> users = new ArrayList<>();
        try {
            while (rs.next()) {
                System.out.println("rs.getRow() = " + rs.getRow());
                    UbUser user = UbUser.builder()
                            .id(rs.getInt(1))
                            .login(rs.getString(2))
                            .name(rs.getString(3))
                            .bio(rs.getString(4))
//                    .image(rs.getBlob(5))
                            .birth(LocalDate.parse(rs.getDate(6).toString()))
                            .registered(rs.getObject(7, LocalDateTime.class))
                            .updated(rs.getTimestamp("updated").toLocalDateTime())
                            .gender(rs.getString(9).charAt(0))
                            .likes(rs.getInt(10))
                            .credit(rs.getDouble(11))
                            .active(rs.getBoolean(12))
                            .build();
                    users.add(user);
            }
        } catch (Exception ex) {
        ex.printStackTrace();
        System.out.println("error in row " + rs.getInt(1));
    } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return users;
    }

    public List<UbUser> getDeveloper() throws SQLException {
        Connection connection = getConnection();
        Statement st2 = connection.createStatement();
        ResultSet rs = st2.executeQuery(SELECT_DEVELOPER_FROM_UBUSER);
        List<UbUser> users = new ArrayList<>();
        while (rs.next()) {
            System.out.println("rs.getRow() = " + rs.getRow());
//            try {
            UbUser user = UbUser.builder()
                    .id(rs.getInt(1))
                    .login(rs.getString(2))
                    .name(rs.getString(3))
                    .bio(rs.getString(4))
//                    .image(rs.getBlob(5))
                    .birth(LocalDate.parse(rs.getDate(6).toString()))
                    .registered(rs.getObject(7, LocalDateTime.class))
                    .updated(rs.getTimestamp("updated").toLocalDateTime())
                    .gender(rs.getString(9).charAt(0))
                    .likes(rs.getInt(10))
                    .credit(rs.getDouble(11))
                    .active(rs.getBoolean(12))
                    .build();
            users.add(user);

//            } catch (Exception ex) {
//                ex.printStackTrace();
//                System.out.println("error in row " + rs.getInt(1));
//            }
//            users.add(user);
        }
        return users;
    }

    public List<UbUser> getMentor() throws SQLException {
        Connection connection = getConnection();
        Statement st2 = connection.createStatement();
        ResultSet rs = st2.executeQuery(SELECT_MENTOR_FROM_UBUSER);
        List<UbUser> users = new ArrayList<>();
        while (rs.next()) {
            System.out.println("rs.getRow() = " + rs.getRow());
//            try {
                UbUser user = UbUser.builder()
                        .id(rs.getInt(1))
                        .login(rs.getString(2))
                        .name(rs.getString(3))
                        .bio(rs.getString(4))
//                    .image(rs.getBytes(5))
                        .birth(LocalDate.parse(rs.getDate(6).toString()))
                        .registered(rs.getObject(7, LocalDateTime.class))
                        .updated(rs.getTimestamp("updated").toLocalDateTime())
                        .gender(rs.getString(9).charAt(0))
                        .likes(rs.getInt(10))
                        .credit(rs.getDouble(11))
                        .active(rs.getBoolean(12))
                        .build();
                users.add(user);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                System.out.println("error in row " + rs.getInt(1));
//            }
        }
        return users;
    }
}
