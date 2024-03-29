package com.example.igo.model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SqliteJDBC {
    public static ArrayList<Transactions> viewTransactions(int userId) {
        ArrayList<Transactions> transactionsList = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/igo/db/iGoData.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM transactions where userId="+ userId +";");
            while(rs.next()){
                int id = rs.getInt("userId");
                int txnid = rs.getInt("transaction_id");
                double amount = rs.getDouble("amount");
                Date transactionDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("transaction_date"));
                String paymentMode = rs.getString("payment_mode");

                transactionsList.add(new Transactions(txnid, id, amount, transactionDate, paymentMode));
            }

            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }finally {
            return transactionsList;
        }

    }

    public static User authenticateUser(String id, String pass){

        User u = null;
        Connection conn = null;
        Statement stmt = null;
        int roleId = 0;

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
                String address = rs.getString("address");
                roleId = rs.getInt("role_id");

                u = new User(userId, email, name, password, dob, address);

            }
            rs.close();
            stmt.close();

            // Get role
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM roles where role_id=" + roleId + ";");

            if(rs.next()){
                String r_title = rs.getString("role_title");
                String r_desc = rs.getString("role_description");
                u.setRoleId(roleId);
                u.setRoleTitle(r_title);
                u.setRoleDescription(r_desc);
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

    public static ArrayList<Ticket> viewAvailableTickets(int userId) {
        ArrayList<Ticket> ticketList = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/igo/db/iGoData.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tickets where ticket_customer_id="+ userId +";");
            while(rs.next()){
                int t_id = rs.getInt("ticket_id");
                int t_cust_id = rs.getInt("ticket_customer_id");
                Date t_date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("ticket_date"));
                String t_type = rs.getString("ticket_type");
                String t_desc = rs.getString("ticket_desc");
                String t_valid = rs.getString("validity");

                ticketList.add(new Ticket(t_id, t_date, t_desc, t_type, t_cust_id, t_valid));
            }

            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }finally {
            return ticketList;
        }

    }

    public static ArrayList<Fare> showAvailableFares(int userId, String roleTitle){
        ArrayList<Fare> fareList = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/igo/db/iGoData.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = null;
            if(roleTitle == null){
                rs = stmt.executeQuery("SELECT * FROM fares;");
            }
            else{
                rs = stmt.executeQuery("SELECT * FROM fares WHERE fare_type = \'" + roleTitle + "\' ;");
            }

            while(rs.next()){
                int f_id = rs.getInt("fare_id");
                double f_amt = rs.getDouble("fare_amount");
                String f_title = rs.getString("fare_title");
                String f_desc = rs.getString("fare_desc");
                String f_type = rs.getString("fare_type");

                fareList.add(new Fare(f_id, f_amt, f_title, f_desc, f_type));
            }

            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }finally {
            return fareList;
        }
    }

    public static boolean processTicket(int userId, Fare fare, String paymentType){

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pre_stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/igo/db/iGoData.db");
            String query = "INSERT INTO tickets (ticket_date, ticket_desc, ticket_type, ticket_customer_id, validity) VALUES (DATE('now'), ?, ?, ?, ?)";
            pre_stmt = conn.prepareStatement(query);
            pre_stmt.setString(1, fare.getFareDescription());
            pre_stmt.setString(2, fare.getFareTitle());
            pre_stmt.setInt(3, userId);
            pre_stmt.setString(4, "valid");

            pre_stmt.executeUpdate();
            pre_stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        pre_stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/igo/db/iGoData.db");
            String query = "INSERT INTO transactions (userId, amount, transaction_date, payment_mode) VALUES (?, ?, DATE('now'), ?)";
            pre_stmt = conn.prepareStatement(query);

            pre_stmt.setInt(1, userId);
            pre_stmt.setDouble(2, fare.getFareAmount());
            pre_stmt.setString(3, paymentType);

            pre_stmt.executeUpdate();
            pre_stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
