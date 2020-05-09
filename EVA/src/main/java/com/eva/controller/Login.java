package com.eva.controller;

import com.eva.App;
import java.io.IOException;
import java.util.Map;

import com.eva.helpers.Password;
import com.eva.model.User;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login {

    @FXML
    public void switchToRegister(ActionEvent actionEvent) throws IOException {
        App.newSimpleWindow("Register", "Register");
        close();
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
                // throws NumberFormatException
                user_id_int = Integer.parseInt(user_id.getText().trim());
                // password validation

                if(password.getText().equals("")) {
                    show_error("Please enter your password");
                } else {
                    String hashed_password = User.getUserHashedPassword(user_id_int);
                    if (hashed_password=="") {
                        show_error("Account Does Not Exist");
                    } else {
                        if (Password.checkPassword(password.getText(), hashed_password)) {
                            // launch FullRegister
                            Map dataMap = User.getUserData(user_id_int);
                            System.out.println("dataMap.get(first_name).toString()");
                            System.out.println(dataMap.get("first_name").toString());
                            if(dataMap.get("first_name").toString().equals("")&&dataMap.get("last_name").toString().equals("")) { // checks if is fully registered
                                App.newDataWindow("Complete Register","FullRegister", dataMap);
                            } else {
                                App.AlertBox("Temporary Main menu replacement", "You're fully registered, good job!", "SuccessAlertBox");
                            }
                            close();
                        } else {
                            show_error("Wrong Password!");
                        }
                    }
                }
            } catch (NumberFormatException e){
                show_error("Please enter an integer value");
            } catch(CommunicationsException e) {
                App.AlertBox("Error", "Error connecting to the database.", "ErrorAlertBox");
            }
        }


    }
    @FXML
    VBox window;
    public void close(){
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }
}
