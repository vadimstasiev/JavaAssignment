package com.eva;

import java.sql.*;

public class DBconnect {
    private Connection con;
    private Statement st;
    private ResultSet res;

    public DBconnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            st = con.createStatement();
        } catch(Exception error) {
            System.out.println("Error: "+error);
        }
    }
    public void getData(){
        try {
            String query = "SELECT * FROM people";
            res = st.executeQuery(query);
            System.out.println("Records from the Database");
            while(res.next()){
                String name = res.getString("name");
                String age = res.getString("age");
                System.out.println("Name: "+name+"  Age: "+age);
            }
        } catch(Exception error) {
            System.out.println("Error: "+error);
        }
    }

}
