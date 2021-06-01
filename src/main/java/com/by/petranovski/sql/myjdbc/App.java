package com.by.petranovski.sql.myjdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.by.petranovski.sql.myjdbc.config.JisAtLocal.getConnection;

public class App {

    public static final String CREATE_TABLE_GIRLS = "" +
            "CREATE TABLE j_girls (" +
            "girls_id INT(2) NOT NULL AUTO_INCREMENT," +
            "girl_name VARCHAR(50) DEFAULT NULL," +
            "PRIMARY KEY (girls_id)" +
            ");";

    public static final String DROP_TABLE_GIRLS = "" +
            "DROP TABLE j_girls;";

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        Statement st = connection.createStatement();
        st.execute(DROP_TABLE_GIRLS);
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE_GIRLS);
    }
}
