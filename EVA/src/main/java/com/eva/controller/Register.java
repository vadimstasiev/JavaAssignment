package com.eva.controller;


import com.eva.helpers.DatabaseInterface;
import com.eva.helpers.Password;
import com.eva.model.User;
import com.eva.App;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Register {
    // Link to Login
    @FXML
    public void switchToLogin(ActionEvent actionEvent) throws IOException {
        App.setRoot("Login");
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
    private TextField user_id;
    @FXML
    private TextField password;
    @FXML
    private TextField confirm_password;
    @FXML
    public void register(ActionEvent actionEvent) throws IOException {
        int user_id_int = 0;
        hide_error();
        // password validation
        if(password.getText().equals("") || confirm_password.getText().equals("")) {
            show_error("Please enter and confirm your password");
        } else if(!password.getText().equals(confirm_password.getText())) {
            show_error("Please enter the same password on both fields");
        }
        // user ID validation
        if(user_id.getText()=="") {
            show_error("Please enter your user ID");
        } else {
            try {
                // attempt to convert the user_id to int to verify it is an integer
                user_id_int = Integer.parseInt(user_id.getText().trim());
            } catch (Exception error) {
                show_error("Please enter an integer value");
            }
        }
        if(error.getText()=="") {
            try {
                User.createUser(
                        user_id_int,
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        false,
                        Password.encryptPassword(password.toString())
                );
            } catch(Exception error) {
                App.modal("error", "Error connecting to the database.", "AlertBox");
            }
        }
    }
}

