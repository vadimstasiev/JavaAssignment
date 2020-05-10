package com.eva.controller;

import com.eva.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DialogBox {
    @FXML
    VBox window;

    @FXML
    public void close() {
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }

    @FXML
    Label labelMessage;

    private App.DialogReferenceAnswer answerReference;
    public void initData(String message, App.DialogReferenceAnswer reference) {
        answerReference = reference;
        labelMessage.setText(message);
    }

    public void setYes() {
        answerReference.answer = "Yes";
        close();
    }

    public void setNo() {
        answerReference.answer = "No";
        close();
    }
}
