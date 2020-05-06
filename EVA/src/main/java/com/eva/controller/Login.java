package com.eva.controller;

import com.eva.App;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Login {


    @FXML
    public void switchToRegister(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
}
