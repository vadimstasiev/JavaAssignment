package com.eva.model;

import com.eva.helpers.DatabaseInterface;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

public class Booking {
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
    public static Boolean doesBookingExist(String event_fk, String user_fk) throws CommunicationsException {
        String query = "SELECT * FROM bookings WHERE event_fk = '" + event_fk + "' AND user_fk = '" + user_fk + "'";
        Map<String , String> dataMap;
        try {
            dataMap = DatabaseInterface.dbExecuteQuery(query).get(0);
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            dataMap = null;
        }
        return !(dataMap==null);
    }
    public static Integer getNumberOfBookings(String event_fk) throws CommunicationsException {
        String query = "SELECT * FROM bookings WHERE event_fk = '" + event_fk + "'";
        List<Map<String , String>> dataMapList;
        int length;
        try {
            length = DatabaseInterface.dbExecuteQuery(query).size();
        } catch (CommunicationsException e) {
            throw e;
        } catch (Exception e) {
            length = 0;
        }
        return length;
    }
    public static void deleteBooking(String event_fk, String user_fk) {
        try {
            String query = "DELETE FROM bookings WHERE event_fk = '" + event_fk + "' AND user_fk = '" + user_fk + "'";
            DatabaseInterface.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error in deleteEvent() in Event ");
            System.out.println("Error: " + e);
        }
    }
}
