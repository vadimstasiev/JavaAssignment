package com.eva.controller;

import com.eva.App;
import com.eva.model.Booking;
import com.eva.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BookEvent {
    @FXML
    public TextField locationOrPath;
    @FXML
    public TextField title;
    @FXML
    public TextArea description;
    @FXML
    public TextField date;
    @FXML
    public TextField time;
    @FXML
    public TextField placeLimitation;

    Map userData;
    Map eventData;
    public void initData(Map userData, Map eventData) {
        this.userData = userData ;
        this.eventData = eventData;
        locationOrPath.setText(setNotNull((String)eventData.get("location")));
        title.setText(setNotNull((String)eventData.get("title")));
        description.setText(setNotNull((String)eventData.get("description")));
        date.setText(setNotNull((String)eventData.get("date")));
        time.setText(setNotNull((String)eventData.get("time")));
        placeLimitation.setText(setNotNull((String)eventData.get("placeLimitation")));
    }
    public void bookEvent() {
        try {
            String user_id = setNotNull((String) userData.get("id"));
            String uuid = setNotNull((String) eventData.get("uuid"));
            int placeLimitation = Integer.parseInt(setNotNull((String) eventData.get("placeLimitation")));
            int numberOfBookings = Booking.getNumberOfBookings(uuid);
            if(Booking.doesBookingExist(uuid, user_id)){
                App.AlertBox("Error", "You have already booked this event!", "ErrorAlertBox");
            } else {
                System.out.println(numberOfBookings + " " + placeLimitation);
                if(numberOfBookings>=placeLimitation){
                    App.AlertBox("Error", "The event is already full!", "ErrorAlertBox");
                } else {
                    Booking.book(
                            uuid,
                            user_id
                    );
                    App.AlertBox("Success", "Successfully Booked", "SuccessAlertBox");
                }
            }
        } catch (Exception e) {
            App.AlertBox("Error", "Booking Failed!", "ErrorAlertBox");
        }
        close();
    }
    public void deleteBooking() {
        App.DialogReferenceAnswer referenceAnswer = new App.DialogReferenceAnswer();
        App.DialogBox("Confirm", "Are you sure you want to delete this booking?", "DangerDialogBox", referenceAnswer);
        if(referenceAnswer.answer.equals("Yes")) {
            String uuid = setNotNull((String) eventData.get("uuid"));
            String user_id = setNotNull((String) userData.get("id"));
            Booking.deleteBooking(uuid, user_id);
            close();
        }
    }

    private String setNotNull(String str){ return str==null?"":str; }
    @FXML
    VBox window;

    public void close(){
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }
}
