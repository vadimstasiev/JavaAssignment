/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eva.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.eva.App;
import com.eva.model.User;
import com.jfoenix.controls.JFXButton;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home extends DataController {

    @FXML
    public Label full_name;
    public Label id_number;
    public Label userType;
    public JFXButton adminAccess1;
    public JFXButton adminAccess2;
    public VBox sidePanelContainer;
    public JFXButton organizerAccess1;
    public JFXButton organizerAccess2;

    @FXML
    private VBox pnl_scroll;


    public void initData(Map data) {
        super.initData(data); // dataMap = data
        full_name.setText(dataMap.get("first_name") + " " +  dataMap.get("last_name"));
        id_number.setText("User ID: " +  dataMap.get("id"));
        loadSimpleView("DefaultModular");
        try {
            if(setNotNull((String) dataMap.get("isAdmin")).equals("1")) {
                userType.setText("Admin");
            } else {
                sidePanelContainer.getChildren().remove(adminAccess1);
                sidePanelContainer.getChildren().remove(adminAccess2);
                if(setNotNull((String) dataMap.get("isOrganizer")).equals("0")) {
                    sidePanelContainer.getChildren().remove(organizerAccess1);
                    sidePanelContainer.getChildren().remove(organizerAccess2);
                }
            }
        } catch (Exception e) {

        }
    }

    private void loadSimpleView(String view)
    {
        pnl_scroll.getChildren().clear();
        try {
            FXMLLoader loader = App.loadFXML(view);
            Node node = (Node) loader.load();
            pnl_scroll.getChildren().add(node);
        } catch (IOException e) {
            App.AlertBox("Error", "Error loading view.", "ErrorAlertBox");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadDataView(String view)
    {
        pnl_scroll.getChildren().clear();
        try {
            FXMLLoader loader = App.loadFXML(view);
            Node node = (Node) loader.load();
            pnl_scroll.getChildren().add(node);
            DataController controller = loader.<DataController>getController();
            controller.initData(dataMap);
        } catch (IOException e) {
            App.AlertBox("Error", "Error loading view.", "ErrorAlertBox");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void editProfile() {
        loadDataView("FullRegisterModular");
    }

    public void addEvent() {
        loadDataView("EventModular");
    }

    public void searchEvents() { loadDataView("SearchEvents"); }

    public void BookedEvents() { loadDataView("BookedEvents"); }

    public void ManageEvents() { loadDataView("ManageEvents"); }

    public void AdminEvents() { loadDataView("AdminEvents"); }

    public void openUserManagement() {
        loadSimpleView("UserManagementModular");
    }

    @FXML
    AnchorPane window;

    public void close(){
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }

    public void logout() {
        App.newSimpleWindow("Login", "Login");
        close();
    }

    private String setNotNull(String str){ return str==null?"":str; }
}
