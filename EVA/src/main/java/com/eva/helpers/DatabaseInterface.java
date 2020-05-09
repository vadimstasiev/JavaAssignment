package com.eva.helpers;


import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

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

    public static Map dbExecuteQuery(String query) throws SQLException {
        DBconnect();
        try {
            res = st.executeQuery(query);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw e;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.out.println("Error in Query: " + query);
        }
        Map dataMap = new HashMap();
        ResultSetMetaData rsmd = res.getMetaData();
        int columnCount = rsmd.getColumnCount();
        while (res.next()) {
            if(res.getString("hashed_password")!="") {
                int resSize = res.getFetchSize();
                for(int i=1;i<=columnCount;i++) {
                    dataMap.put(rsmd.getColumnName(i), res.getString(i));
                    //System.out.println("Column: "+ rsmd.getColumnName(i)+"  Value: "+ res.getString(i));
                }
            }
        }
        DBdisconnect();
        return dataMap;
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
