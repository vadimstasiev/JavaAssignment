package com.eva.model;

import com.eva.helpers.DatabaseInterface;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

public class Event {
    public static void updateUser() {
        // update any given property

    }
    public static void createEvent(
           String uuid,
           String location,
           String title,
           String description,
           String date,
           String time,
           Integer placeLimitation
    ) throws CommunicationsException, SQLIntegrityConstraintViolationException {
        String query = "INSERT INTO `events` " +
                "(`uuid`, `location`, `title`, `description`, `date`, `time`, " +
                "`placeLimitation`)" +
                " VALUES " +
                "('" + uuid +
                "', '" + location +
                "', '" + title +
                "', '" + description +
                "', '" + date +
                "', '" + time +
                "', '" + placeLimitation +"');";
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
    public static Map<String , String> getEventData(String uuid) throws CommunicationsException {
        String query = "SELECT * FROM events WHERE uuid = '" + uuid + "'";
        Map<String , String> dataMap = null;
        try {
            dataMap = DatabaseInterface.dbExecuteQuery(query).get(0);
        } catch (CommunicationsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getEventData() in Event ");
            System.out.println("Error: " + e);
        }
        return dataMap;
    }
    public static List<Map<String , String>> getAllEventData() throws CommunicationsException {
        List<Map<String , String>> dataMapList = null;
        String query = "SELECT * FROM events";
        try {
            dataMapList = DatabaseInterface.dbExecuteQuery(query);
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getEventData() in Event ");
            System.out.println("Error: " + e);
        }
        return dataMapList;
    }
    public static void deleteEvent(String uuid) {
        try {
            String query = "DELETE FROM events WHERE uuid = '" + uuid + "'";
            DatabaseInterface.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error in deleteEvent() in Event ");
            System.out.println("Error: " + e);
        }
    }
}
