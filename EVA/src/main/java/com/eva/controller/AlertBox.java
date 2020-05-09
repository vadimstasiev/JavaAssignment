package com.eva.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertBox {
    @FXML
    JFXButton closeButton;

    @FXML
    public void switchToLogin(ActionEvent actionEvent) throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    Label labelMessage;

    public void initData(String message) {
        labelMessage.setText(message);
    }
}
