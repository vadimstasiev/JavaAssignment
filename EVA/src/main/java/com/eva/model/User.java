package com.eva.model;

import com.eva.helpers.DatabaseInterface;
import javafx.beans.property.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public static void updateUser() {
        // update any given property

    }
    public static void createUser(Integer id,
                           String first_name,
                           String last_name,
                           String gender,
                           String address_line,
                           String town,
                           String county,
                           String postcode,
                           String dob,
                           Boolean isOrganizer,
                           String hashed_password) throws SQLException {
        DatabaseInterface.getData();
            String query = "INSERT INTO `users` " +
                    "(`id`, `first_name`, `last_name`, `gender`, `address_line`, `town`, `county`, `postcode`, `dob`, `isOrganizer`, `hashed_password`)" +
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
            System.out.println(query);
        DatabaseInterface.dbExecuteUpdate(query);
        DatabaseInterface.getData();
    }
    public static String getUserHashedPassword(int _id) {
        String hashed_password = "";
        DatabaseInterface.getData();
        String query = "SELECT * FROM users WHERE id = " + _id;
        try {
            ResultSet res = DatabaseInterface.dbExecuteQuery(query);
            while(res.next()){
                hashed_password = res.getString("hashed_password");
            }
        } catch (Exception error) {}
        DatabaseInterface.getData();
        return hashed_password;
    }
    public static void deleteUser(int _id) {
        DatabaseInterface.getData();
        String query = "DELETE FROM users WHERE id = " + _id;
        try {
            DatabaseInterface.dbExecuteUpdate(query);
        } catch (Exception error) {}
        DatabaseInterface.getData();
    }
}
