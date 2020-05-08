package com.eva.model;

import com.eva.helpers.DatabaseInterface;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.beans.property.*;
import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    public static void updateUser() {
        // update any given property

    }
    public static void createUser(
           Integer id,
           String first_name,
           String last_name,
           String gender,
           String address_line,
           String town,
           String county,
           String postcode,
           String dob,
           Boolean isOrganizer,
           String hashed_password
    ) throws SQLException {
            String query = "INSERT INTO `users` " +
                    "(`id`, `first_name`, `last_name`, `gender`, `address_line`, `town`, " +
                    "`county`, `postcode`, `dob`, `isOrganizer`, `hashed_password`)" +
                    " VALUES " +
                    "('" + id +
                    "', '" + first_name +
                    "', '" + last_name +
                    "', '" + gender +
                    "', '" + address_line +
                    "', '" + town +
                    "', '" + county +
                    "', '" + postcode +
                    "', '" + dob +
                    "', '" + (isOrganizer ? 1 : 0) +
                    "', '" + hashed_password +"');";
        DatabaseInterface.dbExecuteUpdate(query);
    }
    public static String getUserHashedPassword(int _id) throws CommunicationsException {
        String hashed_password = "";
        String query = "SELECT hashed_password FROM users WHERE id = " + _id;
        try {
            ResultSet res = DatabaseInterface.dbExecuteQuery(query);
            while (res.next()) {
                hashed_password = res.getString("hashed_password");
            }
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getUserHashedPassword() in User ");
            System.out.println("Error: " + e);
        }
        return hashed_password;
    }
    public static Map getUserData(int _id) throws CommunicationsException {


        Map dataArray = new HashMap();
        String query = "SELECT * FROM users WHERE id = " + _id;
        try {
            ResultSet res = DatabaseInterface.dbExecuteQuery(query);
            ResultSetMetaData rsmd = res.getMetaData();
            int columnCount = rsmd.getColumnCount();


            while (res.next()) {
                if(res.getString("hashed_password")!="") {
                    int resSize = res.getFetchSize();
                    for(int i=1;i<=columnCount;i++) {
                        dataArray.put(rsmd.getColumnName(i), res.getString(i));
                        //System.out.println("Column: "+ rsmd.getColumnName(i)+"  Value: "+ res.getString(i));
                    }
                }
            }

        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getUserHashedPassword() in User ");
            System.out.println("Error: " + e);
        }
        return dataArray;
    }
    public static void deleteUser(int _id) throws SQLException {
        DatabaseInterface.getData();
        String query = "DELETE FROM users WHERE id = " + _id;
        DatabaseInterface.dbExecuteUpdate(query);
        DatabaseInterface.getData();
    }
}
