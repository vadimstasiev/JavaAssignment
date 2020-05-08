package com.eva.controller;

import com.eva.App;
import com.eva.helpers.Password;
import com.eva.model.User;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class FullRegister extends DataController {

    public void updateDetails(ActionEvent actionEvent) {
        System.out.println("Full Register Here");
        System.out.println("password: " + dataMap.get("hashed_password"));

    }
    @FXML
    public TextField first_name;
    @FXML
    public TextField last_name;
    @FXML
    public ChoiceBox<String> gender;
    @FXML
    public TextField address_line;
    @FXML
    public TextField town;
    @FXML
    public TextField county;
    @FXML
    public TextField dob;
//    public void updateDetails1(ActionEvent actionEvent) throws IOException, SQLException {
//        int user_id_int = 0;
//        hide_error();
//        // password validation
//        if(password.getText().equals("") || confirm_password.getText().equals("")) {
//            show_error("Please enter and confirm your password");
//        } else if(!password.getText().equals(confirm_password.getText())) {
//            show_error("Please enter the same password on both fields");
//        }
//        // user ID validation
//        if(user_id.getText()=="") {
//            show_error("Please enter your user ID");
//        } else {
//            try {
//                // attempt to convert the user_id to int to verify it is an integer
//                user_id_int = Integer.parseInt(user_id.getText().trim());
//            } catch (Exception error) {
//                show_error("Please enter an integer value");
//            }
//        }
//        if(error.getText()=="") {
//            try {
//                User.createUser(
//                        user_id_int,
//                        "",
//                        "",
//                        "",
//                        "",
//                        "",
//                        "",
//                        "",
//                        "",
//                        false,
//                        Password.encryptPassword(password.getText())
//                );
//                App.AlertBox("Success", "You have successfully registered, now please log in.", "SuccessAlertBox");
//                App.setRoot("Login");
//            } catch(CommunicationsException e) {
//                App.AlertBox("Error", "Error connecting to the database.", "ErrorAlertBox");
//            } catch(SQLIntegrityConstraintViolationException e) {
//                App.AlertBox("Error", "Account already exists.", "ErrorAlertBox");
//            }
//        }
//    }
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
}
