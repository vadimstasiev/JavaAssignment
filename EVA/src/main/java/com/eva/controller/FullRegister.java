package com.eva.controller;

import com.eva.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class FullRegister extends DataController {
    public void updateDetails(ActionEvent actionEvent) {
        System.out.println("Full Register Here");
        System.out.println("password: " + dataMap.get("hashed_password"));

    }
}
