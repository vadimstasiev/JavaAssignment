package com.eva.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertBox {
    @FXML
    VBox window;

    @FXML
    public void close() {
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }

    @FXML
    Label labelMessage;

    public void initData(String message) {
        labelMessage.setText(message);
    }
}
