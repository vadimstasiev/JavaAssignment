package com.eva.controller;

import com.eva.App;
import com.eva.helpers.Password;
import com.eva.model.User;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class FullRegister extends DataController {
//    public void updateDetails(ActionEvent actionEvent) {
//        System.out.println("Full Register Here");
//        System.out.println("password: " + dataMap.get("hashed_password"));
//
//    }
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
    public TextField postcode;
    @FXML
    public DatePicker dob;
    public void updateDetails(ActionEvent actionEvent) throws IOException, SQLException {
        hide_error();
        // password validation
        if(first_name.getText().equals("") || last_name.getText().equals("")) {
            show_error("Please enter your first and last name");
        } else if (!(
            gender.getValue().equals("Female") ||
            gender.getValue().equals("Male") ||
            gender.getValue().equals("Other")
        )) {
            show_error("Please select a gender");
        } else if (
            address_line.getText().equals("") ||
            town.getText().equals("") ||
            county.getText().equals("") ||
            postcode.getText().equals("")
        ) {
            show_error("Please enter your full address");
        } else if (dob.getValue()==null) {
            show_error("Please enter your date of birth");
        } else {
            try {
                System.out.println("Fucks up right here");
                System.out.println(dataMap.get("id"));
                System.out.println(dataMap.get("hashed_password"));
                int user_id_int = (Integer) dataMap.get("id");
                User.deleteUser(user_id_int);
                User.createUser(
                        user_id_int,
                        first_name.getText(),
                        last_name.getText(),
                        gender.getValue(),
                        address_line.getText(),
                        town.getText(),
                        county.getText(),
                        postcode.getText(),
                        dob.getValue().toString(),
                        false,
                        (String)dataMap.get("hashed_password")
                );
                App.AlertBox("Success", "You have successfully registered, now please log in.", "SuccessAlertBox");
                App.setRoot("Login");
            } catch (NumberFormatException e){
                App.AlertBox("Error", "Error parsing the user ID.", "ErrorAlertBox");
            } catch(CommunicationsException e) {
                App.AlertBox("Error", "Error connecting to the database.", "ErrorAlertBox");
            } catch(SQLIntegrityConstraintViolationException e) {
                App.AlertBox("Error", "Account already exists.", "ErrorAlertBox");
            }
        }
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

    public void logout(ActionEvent actionEvent) {
        App.newSimpleWindow("Login", "Login");
        close();
    }
    @FXML
    VBox window;
    public void close(){
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }
}
