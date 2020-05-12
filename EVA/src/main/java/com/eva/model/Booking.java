package com.eva.model;

import com.eva.helpers.DatabaseInterface;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

public class Booking {
    public static void updateUser() {
        // update any given property

    }
    public static void book(
           String event_fk,
           String user_fk
    ) throws CommunicationsException, SQLIntegrityConstraintViolationException {
        String query = "INSERT INTO `bookings` " +
                "(`event_fk`, `user_fk`)" +
                " VALUES " +
                "('" + event_fk +
                "', '" + user_fk +"');";
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
    public static Map<String , String> getBookingData(String uuid) throws CommunicationsException {
        String query = "SELECT * FROM bookings WHERE event_fk = '" + uuid + "'";
        Map<String , String> dataMap = null;
        try {
            dataMap = DatabaseInterface.dbExecuteQuery(query).get(0);
        } catch (CommunicationsException | IndexOutOfBoundsException e) {
            throw e;
        } catch (Exception e) { }
        return dataMap;
    }
    public static Boolean doesBookingExist(String uuid, String userId) throws CommunicationsException {
        String query = "SELECT * FROM bookings WHERE event_fk = '" + uuid + "' AND user_fk = '" + userId + "'";
        Map<String , String> dataMap;
        try {
            dataMap = DatabaseInterface.dbExecuteQuery(query).get(0);
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            dataMap = null;
        }
        return dataMap==null;
    }
    public static List<Map<String , String>> getBookingDataByUser(Integer user_fk) throws CommunicationsException {
        String query = "SELECT * FROM bookings WHERE user_fk = '" + user_fk + "'";
        List<Map<String , String>> dataMapList = null;
        try {
            dataMapList = DatabaseInterface.dbExecuteQuery(query);
        } catch (CommunicationsException | IndexOutOfBoundsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getEventData() in Event ");
            System.out.println("Error: " + e);
        }
        return dataMapList;
    }
    public static List<Map<String , String>> getAllBookingData() throws CommunicationsException {
        List<Map<String , String>> dataMapList = null;
        String query = "SELECT * FROM bookings";
        try {
            dataMapList = DatabaseInterface.dbExecuteQuery(query);
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error in getAllEventData() in Event ");
            System.out.println("Error: " + e);
        }
        return dataMapList;
    }
    public static void deleteBooking(String event_fk) {
        try {
            String query = "DELETE FROM bookings WHERE event_fk = '" + event_fk + "'";
            DatabaseInterface.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error in deleteEvent() in Event ");
            System.out.println("Error: " + e);
        }
    }
}
