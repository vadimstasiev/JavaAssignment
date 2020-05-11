package com.eva.controller;

import com.eva.App;
import com.eva.model.Event;
import com.eva.model.User;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EventRegister extends DataController {
    @FXML
    public TextField locationOrPath;
    @FXML
    public TextField title;
    @FXML
    public TextArea description;
    @FXML
    public DatePicker date;
    @FXML
    public TextField time;
    @FXML
    public TextField placeLimitation;
    private boolean openNew = true;

    Map dataMap;
    Map eventMap;

    @Override
    public void initData(Map userData) {
        Map<String,String> eventMap = new HashMap<>();
        initData(userData, eventMap);
    }

    public void initData(Map userData, Map eventData) {
        dataMap = userData ;
        eventMap = eventData;
        locationOrPath.setText(setNotNull((String) eventMap.get("location")));
        title.setText(setNotNull((String)eventMap.get("title")));
        description.setText(setNotNull((String)eventMap.get("description")));
        placeLimitation.setText(setNotNull((String)eventMap.get("placeLimitation")));
        try {
            LocalDate dateLocalDate = LocalDate.parse(setNotNull((String)eventMap.get("date")));
            date.setValue(dateLocalDate);
        } catch (Exception e) { }
    }

    private String setNotNull(String str){
        return str==null?"":str;
    }

    public void setOpenNew(boolean openNew) {
        this.openNew = openNew;
    }

    public void createOrUpdateEvent() {
        hide_error();
        if(title.getText().equals("")  || title.getText().equals("") || description.getText().equals("")) {
            show_error("Please enter the location, name and description of your event");
        } else if (date.getValue()==null) {
            show_error("Please enter the date of your event");
        } else if(time.getText().equals("")) {
            show_error("Please enter the time of the event");
        } else if(placeLimitation.getText().equals("")){
            show_error("Please enter the maximum people allowed at the event");
        }  else {
            try {
                String uuidStr = setNotNull((String) eventMap.get("uuid"));
                try { // check to see if event exists to update it
                    Map eventMapTemp = Event.getEventData(uuidStr);
                    eventMap = eventMapTemp!=null?eventMapTemp:eventMap;    // checks before assigning a null pointer
                    uuidStr = setNotNull((String) eventMap.get("uuid"));
                } catch (Exception e) {}
                uuidStr =  uuidStr.equals("")? UUID.randomUUID().toString():uuidStr;
                int placeLimitationInt = Integer.parseInt(placeLimitation.getText());
                Event.deleteEvent(uuidStr);
                Event.createEvent(
                        uuidStr,
                        locationOrPath.getText(),
                        title.getText(),
                        description.getText(),
                        date.getValue().toString(),
                        time.getText(),
                        placeLimitationInt
                        // Foreign key linked to user // TODO
                );
                App.AlertBox("Success", "You have successfully created an event!", "SuccessAlertBox");
                if(openNew){
                    try {
                        int user_id_int = Integer.parseInt(dataMap.get("id").toString());
                        dataMap = User.getUserData(user_id_int);
                        App.newDataWindow("Home","Home", dataMap);
                        close();
                    } catch (NumberFormatException e) {
                        show_error("Error parsing user id");
                    }
                }
            } catch (NumberFormatException e){
                show_error("Please enter a number for the maximum people allowed.");
            } catch(CommunicationsException e) {
                App.AlertBox("Error", "Error connecting to the database.", "ErrorAlertBox");
            } catch(SQLIntegrityConstraintViolationException e) {
                App.AlertBox("Error", "Error updating account already exists.", "ErrorAlertBox");
            }
        }
    }
    @FXML
    private Label error;
    private void show_error(String message) {
        error.setText(message);
        error.setOpacity(1);
    }
    private void hide_error() {
        error.setOpacity(0);
        error.setText("");
    }

    @FXML
    VBox window;
    public void close(){
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }
    public void deleteEvent() {
        App.DialogReferenceAnswer referenceAnswer = new App.DialogReferenceAnswer();
        App.DialogBox("Confirm", "Are you sure you want to delete this event?", "DangerDialogBox", referenceAnswer);
        if(referenceAnswer.answer.equals("Yes")){
            Event.deleteEvent((String)eventMap.get("id"));
        }
    }
}
