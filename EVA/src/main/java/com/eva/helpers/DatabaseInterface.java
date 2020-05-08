package com.eva.helpers;


import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;

public class DatabaseInterface {

    private static Connection con;
    private static Statement st;
    private static ResultSet res;

    private static final String DBNAME = "eva";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/" + DBNAME + "?useTimezone=true&serverTimezone=UTC";
    private static Object SQLTimeoutException;
    private static Object SQLException;

    public static void DBconnect() throws CommunicationsException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
        } catch (CommunicationsException e) {
            System.out.println("Error: " + e);
            throw e;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No JDBC driver installed");
        }
    }

    public static void DBdisconnect() throws SQLException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (CommunicationsException e) {
            System.out.println("Error: " + e);
            throw e;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

    }

    public static ResultSet dbExecuteQuery(String query) throws SQLException {
        DBconnect();
        try {
            res = st.executeQuery(query);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw e;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.out.println("Error in Query: " + query);
        }
        return res;
    }

    public static void dbExecuteUpdate(String query) throws SQLException {
        DBconnect();
        try {
            st.executeUpdate(query);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw e;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.out.println("Error in Query: " + query);
        }
    }

    public static void getData() {  //just for testing - ignore
        try {
            DBconnect();
            String query = "SELECT * FROM users";
            res = st.executeQuery(query);
            System.out.println("Records from the Database");
            while(res.next()){
                String first_name = res.getString("first_name");
                String last_name = res.getString("last_name");
                String gender = res.getString("gender");
                System.out.println("first_name: "+first_name+"  last_name: "+last_name+"    gender: "+ gender);
            }
        } catch(Exception error) {
            System.out.println("Error: " + error);
        }
    }

    public static void getDataFromTable(String table){  //just for testing - ignore
        try {
            String query = "SELECT * FROM " + table;
            res = st.executeQuery(query);
            System.out.println("Records from the Database");
            while(res.next()){
                String name = res.getString("name");
                String age = res.getString("age");
                System.out.println("Name: " + name + "  Age: "+age);
            }
        } catch(Exception error) {
            System.out.println("Error: " + error);
        }
    }
}
