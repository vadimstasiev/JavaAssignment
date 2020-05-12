package com.eva.helpers;


import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseInterface {

    private static Connection con;
    private static Statement st;
    private static ResultSet res;

    private static final String DBNAME = "eva";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/" + DBNAME + "?useTimezone=true&serverTimezone=UTC";

    public static void DBconnect() throws CommunicationsException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            con.setAutoCommit(true);
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

    public static List<Map<String , String>> dbExecuteQuery(String query) throws SQLException {
        DBconnect();
        try {
            res = st.executeQuery(query);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw e;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.out.println("Error in Query: " + query);
        }
        List<Map<String , String>> dataMapList  = new ArrayList<>();
        ResultSetMetaData rsmd = res.getMetaData();
        int columnCount = rsmd.getColumnCount();
        int j = 0;
        while (res.next()) {
            Map<String,String> dataMap = new HashMap<String, String>();
            int resSize = res.getFetchSize();
            for(int i=1;i<=columnCount;i++) {
                dataMap.put( rsmd.getColumnName(i), res.getString(i));
            }
            dataMapList.add(j,dataMap);
            j++;
        }
        DBdisconnect();
        return dataMapList;
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
        DBdisconnect();
    }
}
