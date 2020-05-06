package com.eva.helpers;


import java.sql.*;

public class DatabaseInterface {

    private static Connection con;
    private static Statement st;
    private static ResultSet res;

    private static final String DBNAME = "eva";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/" + DBNAME + "?useTimezone=true&serverTimezone=UTC";

    public static void DBconnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    public static void DBdisconnect() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    public static void dbExecuteQuery(String query)  {
        try {
            DBconnect();
            res = st.executeQuery(query);
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    public static void dbExecuteUpdate(String query) {
        try {
            DBconnect();
            st.executeUpdate(query);
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    public void getData(){
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

    public void getDataFromTable(String table){
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