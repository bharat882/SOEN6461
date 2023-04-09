package com.example.igo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SqliteJDBC {
    public static void testSelect() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/igo/db/iGoData.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");

            if (!rs.next()) {
                System.out.println("No data");
            } else {
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("ADDRESS"));

            }
            rs.close();
            stmt.close();
            c.close();

            System.out.println("Operation done successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public static void viewTransactions(String userID) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/igo/db/iGoData.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");

            if (!rs.next()) {
                System.out.println("No data");
            } else {
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("ADDRESS"));

            }
            rs.close();
            stmt.close();
            c.close();

            System.out.println("Operation done successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public static User authenticateUser(String id, String pass){

        User u = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/igo/db/iGoData.db");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users where email=\'" + id + "\' AND password=\'"+ pass+ "\' LIMIT 1;");

            if (!rs.next()) {
                return u;
            } else {
                int userId = rs.getInt("userId");
                String email = rs.getString("email");
                String name = rs.getString("Name");
                String password = rs.getString("password");
                Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dob"));
                //Date dob = rs.getDate("dob");
                String address = rs.getString("address");

                u = new User(userId, email, name, password, dob, address);

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        finally {
            return u;
        }
    }
}
