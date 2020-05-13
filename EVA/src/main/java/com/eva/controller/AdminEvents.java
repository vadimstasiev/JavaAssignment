package com.eva.controller;

import com.eva.App;
import com.eva.model.Booking;
import com.eva.model.Event;
import com.eva.model.User;
import com.jfoenix.controls.JFXButton;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;
import static javafx.scene.paint.Color.WHITE;


public class AdminEvents extends DataController implements Initializable
{   // the user "dataMap" from DataController is not available when the initialize starts, only after the view has loaded
    @FXML
    private TableView<TableRowData> table;
    @FXML
    private TableColumn<TableRowData, String> name_col, location_col, date_col, placeLimitation_col, button1_col;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fabricateRow();
    }

    public void initData(Map data){
        super.initData(data);
        triggerSearch();
    }

    List<Map<String , String>> eventMapList;

    public void initData(String name, String location){

        ObservableList<TableRowData> data = FXCollections.observableArrayList();
        try{
            eventMapList = Event.getAllEventData();
            String user_id = setNotNull((String) dataMap.get("id"));
            for(Map eventMap:eventMapList) {
                try {
                    String user_fk = setNotNull((String) eventMap.get("user_fk"));
                    String uuid = setNotNull((String) eventMap.get("uuid"));
                    Boolean isBooked = (Booking.doesBookingExist(uuid, user_id));
                    data.add(new TableRowData(
                            user_fk,
                            setNotNull((String)eventMap.get("uuid")),
                            setNotNull((String)eventMap.get("title")),
                            setNotNull((String)eventMap.get("location")),
                            setNotNull((String)eventMap.get("date")),
                            setNotNull((String)eventMap.get("placeLimitation")),
                            isBooked)
                    );
                } catch (Exception e) {
                    System.out.println("Error adding events to table.");
                }
            }
            FilteredList<TableRowData> filteredData = new FilteredList<>(data, p -> p.getName().contains(name) && p.getLocation().contains(location));
            table.setItems(filteredData);
        } catch (CommunicationsException e) {
            App.AlertBox("Error", "Error connecting to the database.", "ErrorAlertBox");
        }
    }


    private class TableRowData {
        private String userID;
        private String uuid;
        private String name;
        private String location;
        private String date;
        private String placeLimitation;
        private Boolean isBooked;

        public TableRowData(String userID, String uuid, String name, String location, String date, String placeLimitation, Boolean isBooked)
        {
            this.userID = userID;
            this.uuid = uuid;
            this.name = name;
            this.location = location;
            this.date = date;
            this.placeLimitation = placeLimitation;
            this.isBooked = isBooked;
        }

        public String getUserID() {
            return userID;
        }

        public String getUUID() {
            return uuid;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public String getDate() {
            return date;
        }

        public String getPlaceLimitation() {
            return placeLimitation;
        }

        public Boolean getIsBooked() {
            return isBooked;
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
                    textLabel.setText(tableRowData.getName());
                    setGraphic(textLabel);
                }
                setText(null);
            }
        };
        name_col.setCellFactory(cellFactory0);

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
                    textLabel.setText(tableRowData.getLocation());
                    setGraphic(textLabel);
                }
                setText(null);
            }
        };
        location_col.setCellFactory(cellFactory1);

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
                    textLabel.setText(tableRowData.getDate());
                    setGraphic(textLabel);
                }
                setText(null);
            }
        };
        date_col.setCellFactory(cellFactory2);

        Callback<TableColumn<TableRowData, String>, TableCell<TableRowData, String>> cellFactory3
                = (final TableColumn<TableRowData, String> entry) -> new TableCell<>() {
            Label textLabel = new Label();
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    TableRowData tableRowData = table.getItems().get(getIndex());
                    textLabel.setText(tableRowData.getPlaceLimitation());
                    setGraphic(textLabel);
                }
                setText(null);
            }
        };
        placeLimitation_col.setCellFactory(cellFactory3);

        Callback<TableColumn<TableRowData, String>, TableCell<TableRowData, String>> cellFactory4
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
                    btn.setMinWidth(150);
                    btn.setText("Manage Event");
                    btn.setStyle("-fx-background-color: #473E98;");
                    btn.setOnAction(event -> {
                        try{
                            int user_id_int = Integer.parseInt(setNotNull((String)dataMap.get("id")));
                            Map dataMap = User.getUserData(user_id_int);
                            try {

                                FXMLLoader loader = App.loadFXML("UpdateEvent");
                                Stage stage = new Stage();
                                stage.setTitle("Edit Event");
                                //Display window and wait for it to be closed before returning
                                stage.setScene(
                                        new Scene(
                                                (Pane) loader.load()
                                        )
                                );
                                EventRegister controller = loader.<EventRegister>getController();
                                Map eventMap = null;
                                for(Map eventMapTemp:eventMapList) {
                                    if(setNotNull((String)eventMapTemp.get("uuid"))==tableRowData.getUUID()) {
                                        eventMap = eventMapTemp;
                                        break;
                                    }
                                }
                                assert eventMap != null;
                                controller.initData(dataMap, eventMap);
                                controller.setOpenNew(false);
                                stage.showAndWait();
                                triggerSearch();
                            } catch (Exception e) {
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

        button1_col.setCellFactory(cellFactory4);
    }

    @FXML
    public TextField searchByName;
    public TextField searchByLocation;
    public void triggerSearch() {
        initData(searchByName.getText(), searchByLocation.getText());
    }

    private String setNotNull(String str){
        return str==null?"":str;
    }
}




