package com.example.igo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
}
