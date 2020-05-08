package com.eva.controller;

import com.eva.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertBox {
    @FXML
    Button closeButton;

    @FXML
    public void switchToLogin(ActionEvent actionEvent) throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    Label errorLabel;

    public void initData(String message) {
        errorLabel.setText(message);
    }
}
