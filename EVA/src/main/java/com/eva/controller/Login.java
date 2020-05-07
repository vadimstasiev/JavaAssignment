package com.eva.controller;

import com.eva.App;
import java.io.IOException;

import com.eva.helpers.DatabaseInterface;
import com.eva.helpers.Password;
import com.eva.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    public void switchToRegister(ActionEvent actionEvent) throws IOException {
        App.setRoot("Register");
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
    public void login(ActionEvent actionEvent) throws IOException {
        int user_id_int = 0;
        hide_error();
        // user ID validation
        if(user_id.getText()=="") {
            show_error("Please enter your user ID");
        } else {
            try {
                // attempt to convert the user_id to int to verify it is an integer
                try {
                    user_id_int = Integer.parseInt(user_id.getText().trim());
                } catch (Exception e){
                    show_error("Please enter an integer value");
                    throw e;
                }
                // password validation
                try {
                    if(password.getText().equals("")) {
                        show_error("Please enter your password");
                    } else {
                        if (Password.checkPassword(password.toString(), User.getUserHashedPassword(user_id_int))) {
                            App.modal("Temporary log in replacement", "Log in replacement. But you're logged in, good job!", "SuccessAlertBox");
                        } else {
                            show_error("Wrong Password!");
                        }
                    }
                } catch (Exception e) {
                    App.modal("error", "Error connecting to the database.", "ErrorAlertBox");
                }

            } catch (Exception e) {
            }
        }


    }
}
