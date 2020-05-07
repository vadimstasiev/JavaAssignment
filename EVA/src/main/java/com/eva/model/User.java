package com.eva.model;

import com.eva.helpers.DatabaseInterface;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.beans.property.*;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
        String query = "SELECT * FROM users WHERE id = " + _id;
        try {
            ResultSet res = DatabaseInterface.dbExecuteQuery(query);
            while (res.next()) {
                hashed_password = res.getString("hashed_password");
            }
        } catch (CommunicationsException e) {
            throw e;
        } catch (SQLException e) {
            System.out.println("Error in getUserHashedPassword() in User ");
            System.out.println("Error: " + e);
        }
        return hashed_password;
    }
    public static void deleteUser(int _id) throws SQLException {
        DatabaseInterface.getData();
        String query = "DELETE FROM users WHERE id = " + _id;
        DatabaseInterface.dbExecuteUpdate(query);
        DatabaseInterface.getData();
    }
}
