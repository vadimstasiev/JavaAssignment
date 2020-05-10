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
import java.time.LocalDate;
import java.util.Map;

public class FullRegister extends DataController {
    public void initData(Map data) {
        super.initData(data); // dataMap = data
        first_name.setText((String)dataMap.get("first_name"));
        last_name.setText((String)dataMap.get("last_name"));
        gender.setValue((String)dataMap.get("gender"));
        address_line.setText((String)dataMap.get("address_line"));
        town.setText((String)dataMap.get("town"));
        county.setText((String)dataMap.get("county"));
        postcode.setText((String)dataMap.get("postcode"));
        try {
            LocalDate date = LocalDate.parse((String)dataMap.get("dob"));
            dob.setValue(date);
        } catch (Exception e) { }
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
                System.out.println(dataMap.get("id"));
                System.out.println(dataMap.get("hashed_password"));
                int user_id_int = Integer.parseInt(dataMap.get("id").toString());
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
                dataMap = User.getUserData(user_id_int);
                App.newDataWindow("Home","Home", dataMap);
                close();
            } catch (NumberFormatException e){
                App.AlertBox("Error", "Error parsing the user ID.", "ErrorAlertBox");
            } catch(CommunicationsException e) {
                App.AlertBox("Error", "Error connecting to the database.", "ErrorAlertBox");
            } catch(SQLIntegrityConstraintViolationException e) {
                App.AlertBox("Error", "Error updating account already exists.", "ErrorAlertBox");
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

    public void logout() {
        App.newSimpleWindow("Login", "Login");
        close();
    }
    @FXML
    VBox window;
    public void close(){
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }
    public void deleteProfile() {
        App.DialogReferenceAnswer referenceAnswer = new App.DialogReferenceAnswer();
        App.DialogBox("Confirm", "Are you sure you want to delete your account?", "DangerDialogBox", referenceAnswer);
        if(referenceAnswer.answer.equals("Yes")){
            int user_id_int = 0;
            try {
                user_id_int = Integer.parseInt(dataMap.get("id").toString());
            } catch (NumberFormatException e){
                App.AlertBox("Error", "Error parsing the user ID.", "ErrorAlertBox");
            }
            User.deleteUser(user_id_int);
            logout();
        }
    }
}
