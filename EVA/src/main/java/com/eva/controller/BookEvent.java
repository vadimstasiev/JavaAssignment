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

            if(Booking.doesBookingExist(uuid, user_id)){
                Booking.book(
                        uuid,
                        user_id
                );
                App.AlertBox("Success", "Successfully Booked", "SuccessAlertBox");
            } else {
                App.AlertBox("Error", "You have already booked this event!", "ErrorAlertBox");
            }
        } catch (Exception e) {
            App.AlertBox("Error", "Booking Failed!", "ErrorAlertBox");
        }
        close();
    }
    private String setNotNull(String str){ return str==null?"":str; }

    @FXML
    VBox window;
    public void close(){
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }
}
