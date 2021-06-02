package com.by.petranovski.sql.myjdbc.dao;

import com.sun.source.tree.SynchronizedTree;

public class Queries {

    public static final String CREATE_TABLE_GIRLS = "" +
            "CREATE TABLE j_girls (" +
            "girls_id INT(2) NOT NULL AUTO_INCREMENT," +
            "girl_name VARCHAR(50) DEFAULT NULL," +
            "PRIMARY KEY (girls_id)" +
            ");";

    public static final String DROP_TABLE_GIRLS = "" +
            "DROP TABLE j_girls;";

    public static final String SELECT_FROM_UBUSER = "" +
            "SELECT * FROM ubuser;";

    public static final String SELECT_DEVELOPER_FROM_UBUSER = "" +
            "SELECT * FROM ubuser WHERE bio LIKE '%Dev%';";

    public static final String SELECT_MENTOR_FROM_UBUSER = "" +
            "SELECT * FROM ubuser WHERE bio LIKE '%Men%';";

    public static final String SELECT_ALL_FROM_USER = "" +
            "SELECT bio FROM ubuser;";
}
