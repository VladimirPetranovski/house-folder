package com.by.petranovski.sql.myjdbc.dao;

import com.by.petranovski.sql.myjdbc.bean.LightWeightUbUser;
import com.by.petranovski.sql.myjdbc.bean.UbUser;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.by.petranovski.sql.myjdbc.config.JisAtLocal.getConnection;
import static com.by.petranovski.sql.myjdbc.dao.Queries.*;

public class UserDaoSyntaxExample {

    public List<UbUser> jdbcSyntax() {
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

    public void updateNameAndLikesById(int id, String name, int likes) {
        try (Connection connection = getConnection();
        Statement st = connection.createStatement()) {
            int rowsUpdated = st.executeUpdate(String.format(UPDATE_NAME_AND_LIKES_BY_ID, name, likes, id));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<UbUser> getAllFromUbUser() throws SQLException {
        Connection connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(SELECT_ALL_FROM_USER);
        List<UbUser> users = new ArrayList<>();
        try {
            while (rs.next()) {
                System.out.println("rs.getRow() = " + rs.getRow());
                    UbUser user = mapResultSetToUser(rs);
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

    public UbUser findById(int id) {
        UbUser user = null;
        try (Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(String.format(SELECT_USER_FND_BY_ID, id))) {
            while (rs.next()) {
                System.out.println("rs.getRow() = " + rs.getRow());
                user = mapResultSetToUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public UbUser preparedFindById(int id) {
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

    public LightWeightUbUser findByIdLazy(int id) {
        LightWeightUbUser user = null;
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall(CALL_USER_BY_ID)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("rs.getRow() = " + rs.getRow());
                user = mapResultSetToLightWeightUbUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public List<UbUser> getDeveloper() throws SQLException {
        Connection connection = getConnection();
        Statement st2 = connection.createStatement();
        ResultSet rs = st2.executeQuery(SELECT_DEVELOPER_FROM_UBUSER);
        List<UbUser> users = new ArrayList<>();
        while (rs.next()) {
            System.out.println("rs.getRow() = " + rs.getRow());
            UbUser user = mapResultSetToUser(rs);
            users.add(user);
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
                UbUser user = mapResultSetToUser(rs);
                users.add(user);
        }
        return users;
    }

    public void movingCursor() {
        try (Connection connection = getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_FROM_USER)) {
            List<UbUser> users = new ArrayList<>();
            while (rs.next()) {
                UbUser user = mapResultSetToUser(rs);
                users.add(user);
            }
            rs.afterLast(); // можно установить курсор в конец и пройтись от конца к началу, но для этого нужно установить 5-ую версию драйвера mysql
            while (rs.previous()) {
                UbUser user = mapResultSetToUser(rs);
                users.add(user);
            }
            System.out.println("elements = " + users.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectAndUpdate() {
        try (Connection connection = getConnection();
             PreparedStatement st = connection.prepareStatement(SELECT_ALL_FROM_USER,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = st.executeQuery(SELECT_ALL_FROM_USER);

            rs.last(); // можно установить курсор в конец и пройтись от конца к началу, но для этого нужно установить 5-ую версию драйвера mysql
            rs.updateString("name", "Ilon Mask");
            rs.updateInt("likes", 999);
            rs.updateRow();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void saveAllBatch(List<UbUser> users) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER_LAZY)) {
            for (UbUser user : users) {
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getName());
                statement.setInt(3, user.getLikes());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void saveAll(List<UbUser> users) {
        try (Connection connection = getConnection()) {
            for (UbUser user : users) {
                try (PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER_LAZY)) {

                    statement.setString(1, user.getLogin());
                    statement.setString(2, user.getName());
                    statement.setInt(3, user.getLikes());
                    statement.executeUpdate();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
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

    private LightWeightUbUser mapResultSetToLightWeightUbUser(ResultSet rs) throws SQLException {
        return LightWeightUbUser.builder()
                .id(rs.getInt("id"))
                .login(rs.getString("login"))
                .name(rs.getString("name"))
                .likes(rs.getInt("likes"))
                .build();
    }
}
