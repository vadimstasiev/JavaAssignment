package com.eva.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    }
    private String setNotNull(String str){ return str==null?"":str; }
}
