package com.eva.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.eva.App;
import com.eva.model.User;
import com.jfoenix.controls.JFXButton;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;
import static javafx.scene.paint.Color.WHITE;


public class UserManagement implements Initializable
{
    @FXML
    private TableView<TableRowData> table;
    @FXML
    private TableColumn<TableRowData, String> user_id_col, fullname_col, isOrganizer_col, button_col;
    URL url;
    ResourceBundle rb;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url = url;
        this.rb = rb;
        fabricateRow();
//        this.dataMapList = dataMapList;
        ObservableList<TableRowData> data = FXCollections.observableArrayList();
        try{

            List<Map<String , String>> dataMapList = User.getAllUsersData();
            for(Map dataMap:dataMapList) {
                try {
                    data.add(new TableRowData((String)dataMap.get("id"), ((String)dataMap.get("first_name") + " "+ (String)dataMap.get("last_name")), ((String)dataMap.get("isOrganizer")).equals("0")?"No":"Yes"));
                } catch (Exception e) {
                    System.out.println("Error adding user to table.");
                }
            }
        table.setItems(data);
        } catch (CommunicationsException e) {
            App.AlertBox("Error", "Error connecting to the database.", "ErrorAlertBox");
        }
    }



    private class TableRowData {
        private String user_id;
        private String full_name;
        private String isOrganizer;
        public TableRowData(String user_id, String full_name, String isOrganizer)
        {
            this.user_id = user_id;
            this.full_name = full_name;
            this.isOrganizer = isOrganizer;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getFull_name() {
            return full_name;
        }

        public String getOrganizer() {
            return isOrganizer;
        }
    }

    // https://stackoverflow.com/questions/51047396
    private void fabricateRow() {
        Callback<TableColumn<TableRowData, String>, TableCell<TableRowData, String>> cellFactory0
                = (final TableColumn<TableRowData, String> entry) -> new TableCell<>() {
            Label textLabel = new Label();
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    TableRowData tableRowData = table.getItems().get(getIndex());
                    textLabel.setText(tableRowData.getUser_id());
                    setGraphic(textLabel);
                }
                setText(null);
            }
        };
        user_id_col.setCellFactory(cellFactory0);

        Callback<TableColumn<TableRowData, String>, TableCell<TableRowData, String>> cellFactory1
                = (final TableColumn<TableRowData, String> entry) -> new TableCell<>() {
            Label textLabel = new Label();
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    TableRowData tableRowData = table.getItems().get(getIndex());
                    textLabel.setText(tableRowData.getFull_name());
                    setGraphic(textLabel);
                }
                setText(null);
            }
        };
        fullname_col.setCellFactory(cellFactory1);

        Callback<TableColumn<TableRowData, String>, TableCell<TableRowData, String>> cellFactory2
                = (final TableColumn<TableRowData, String> entry) -> new TableCell<>() {
            Label textLabel = new Label();
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    TableRowData tableRowData = table.getItems().get(getIndex());
                    textLabel.setText(tableRowData.getOrganizer());
                    setGraphic(textLabel);
                }
                setText(null);
            }
        };
        isOrganizer_col.setCellFactory(cellFactory2);

        Callback<TableColumn<TableRowData, String>, TableCell<TableRowData, String>> cellFactory3
                = (TableColumn<TableRowData, String> param) -> new TableCell<>() {
            final JFXButton btn = new JFXButton();
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    int currentIndex = getIndex();
                    TableRowData tableRowData = table.getItems().get(currentIndex);
                    btn.nodeOrientationProperty().setValue(RIGHT_TO_LEFT);
                    btn.setPrefHeight(30);
                    btn.setRipplerFill(WHITE);
                    btn.setTextFill(WHITE);
                    btn.setStyle("-fx-background-color: #473E98;");
                    btn.setText("Edit User Profile");
                    btn.setMinWidth(200);
                    btn.setOnAction(event -> {
                        try{
                            int user_id_int = Integer.parseInt(tableRowData.getUser_id().trim());
                            Map dataMap = User.getUserData(user_id_int);
                            FullRegister controller = null;
                            try {
                                FXMLLoader loader = App.loadFXML("FullRegister");
                                Stage stage = new Stage();
                                stage.setTitle("Update User Details");
                                //Display window and wait for it to be closed before returning
                                stage.setScene(
                                        new Scene(
                                                (Pane) loader.load()
                                        )
                                );
                                controller = loader.<FullRegister>getController();
                                controller.initData(dataMap);
                                controller.setOpenNew(false);
                                stage.showAndWait();
                                initialize(url, rb);
                            } catch (IOException e) {
                                System.out.println("Error Creating Window");
                                System.out.println("Error: "+ e);
                            }

                        } catch (NumberFormatException e){
                            App.AlertBox("Error", "Error parsing the user id.", "ErrorAlertBox");
                        } catch(CommunicationsException e) {
                            App.AlertBox("Error", "Error connecting to the database.", "ErrorAlertBox");
                        }
                    });
                    setGraphic(btn);
                }
            }
        };

        button_col.setCellFactory(cellFactory3);
    }
}




