package com.eva.controller;

import com.eva.App;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Register {


    @FXML
    public void switchToLogin(ActionEvent actionEvent) throws IOException {
        App.setRoot("Login");
    }
}
