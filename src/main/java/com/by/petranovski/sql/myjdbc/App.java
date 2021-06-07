package com.by.petranovski.sql.myjdbc;

import com.by.petranovski.sql.myjdbc.dao.UserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.by.petranovski.sql.myjdbc.config.JisAtLocal.getConnection;
import static com.by.petranovski.sql.myjdbc.dao.Queries.*;

public class App {

    public static void main(String[] args) throws SQLException {
        // нет таблицы j_girls
        Connection connection = getConnection();
//        Statement st = connection.createStatement();
//        st.execute(DROP_TABLE_GIRLS);
//
//        Statement statement = connection.createStatement();
//        statement.execute(CREATE_TABLE_GIRLS);
//
        Statement st1 = connection.createStatement();
        ResultSet rs = st1.executeQuery(SELECT_FROM_UBUSER);
        while (rs.next()) {
            System.out.println("rs.getRow = " + rs.getRow());
            System.out.println("\t | \t" + rs.getString(1));
            System.out.println("\t | \t" + rs.getString(2));
            System.out.println("\t | \t" + rs.getString(3));
            System.out.println("\t | \t" + rs.getString(4));
            System.out.println("\t | \t" + rs.getString(5));
            System.out.println("\t | \t" + rs.getString(6));
            System.out.println("\t | \t" + rs.getString(7));
            System.out.println("\t | \t" + rs.getString(8));
            System.out.println("\t | \t" + rs.getString(9));
            System.out.println("\t | \t" + rs.getString(10));
            System.out.println("\t | \t" + rs.getBigDecimal(11));
            System.out.println("\t | \t" + rs.getBoolean(12));
        }

        UserDao userDao = new UserDao();
        userDao.getDeveloper().stream()
                .forEach(s -> System.out.println("\n" + s));

        UserDao userDao1 = new UserDao();
        userDao1.getMentor().stream()
                .forEach(s -> System.out.println("\n" + s));

        UserDao userDao2 = new UserDao();
        userDao2.getAllFromUbUser().stream()
                .forEach(s -> System.out.println("\n" + s));

        UserDao userDao3 = new UserDao();
        userDao3.jdbcSyntax().stream()
                .forEach(s -> System.out.println("\n" + s));
    }
}
