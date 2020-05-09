/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eva.controller;


import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.eva.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author oXCToo
 */
public class HomeController extends DataController {

    @FXML
    public Label full_name;
    public Label id_number;

    @FXML
    private VBox pnl_scroll;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }

    public void initData(Map data) {
        super.initData(data); // dataMap = data
        System.out.println((String)dataMap.get("hashed_password"));
        full_name.setText(((String) dataMap.get("first_name")) + " " + ((String) dataMap.get("last_name")));
        id_number.setText("User ID: " + ((String) dataMap.get("id")));
        refreshNodes();
    }
    
    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        try {
            System.out.println((String)dataMap.get("hashed_password"));
            Node node = (Node) App.loadFXML("Item").load();
            pnl_scroll.getChildren().add(node);

        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
            App.AlertBox("Error", "Error loading view.", "ErrorAlertBox");
        }
    }

    public void editProfile() {
        App.newDataWindow("Update User Details", "FullRegister", dataMap);
        close();
    }

    @FXML
    AnchorPane window;
    public void close(){
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }
}
