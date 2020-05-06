package com.eva.model;

import com.eva.helpers.DatabaseInterface;
import javafx.beans.property.*;

public class User {
    private final DatabaseInterface databaseInterface;

    public User(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }
    public void updateUser() {
        // update any given property

    }
    public void createUser(Integer id,
                           String first_name,
                           String last_name,
                           String gender,
                           String address_line,
                           String town,
                           String county,
                           String postcode,
                           String dob,
                           Boolean isOrganizer,
                           String hashed_password) {
        databaseInterface.getData();
        try{
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
            databaseInterface.dbExecuteUpdate(query);
        } catch (Exception error) {
        }
        databaseInterface.getData();
    }
    public void deleteUser(int _id) {
        databaseInterface.getData();
        String query = "DELETE FROM users WHERE id = " + _id;
        databaseInterface.dbExecuteUpdate(query);
        databaseInterface.getData();
    }
}
