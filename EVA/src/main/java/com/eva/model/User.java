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
           Boolean isAdmin,
           String hashed_password
    ) throws CommunicationsException, SQLIntegrityConstraintViolationException {
        String query = "INSERT INTO `users` " +
                "(`id`, `first_name`, `last_name`, `gender`, `address_line`, `town`, " +
                "`county`, `postcode`, `dob`, `isOrganizer`, `isAdmin`, `hashed_password`)" +
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
                "', '" + (isAdmin ? 1 : 0) +
                "', '" + hashed_password +"');";
        try {
            DatabaseInterface.dbExecuteUpdate(query);
        } catch (CommunicationsException | SQLIntegrityConstraintViolationException e) {
            throw e;
        } catch (SQLException e) {
            System.out.println("Error in executing the following query: ");
            System.out.println(query);
            System.out.println("Error: " + e);
        }

    }
    public static String getUserHashedPassword(int _id) throws CommunicationsException {
        Map<String , String> dataMap = null;
        String hashed_password = null;
        String query = "SELECT hashed_password FROM users WHERE id = " + _id;
        try {
            dataMap = DatabaseInterface.dbExecuteQuery(query).get(0);
            hashed_password = (String)dataMap.get("hashed_password");
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getUserHashedPassword() in User ");
            System.out.println("Error: " + e);
        }
        return hashed_password;
    }
    public static Map<String , String> getUserData(int _id) throws CommunicationsException {
        String query = "SELECT * FROM users WHERE id = " + _id;
        Map<String , String> dataMap = null;
        try {
            dataMap = DatabaseInterface.dbExecuteQuery(query).get(0);
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getUserData() in User ");
            System.out.println("Error: " + e);
        }
        return dataMap;
    }
    public static List<Map<String , String>> getAllUsersData() throws CommunicationsException {
        List<Map<String , String>> dataMapList = null;
        String query = "SELECT * FROM users";
        try {
            dataMapList = DatabaseInterface.dbExecuteQuery(query);
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getUserData() in User ");
            System.out.println("Error: " + e);
        }
        return dataMapList;
    }
    public static void deleteUser(int _id) {
        try {
        String query = "DELETE FROM users WHERE id = " + _id;
        DatabaseInterface.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error in deleteUser() in User ");
            System.out.println("Error: " + e);
        }
    }
}
