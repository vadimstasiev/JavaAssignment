package com.eva.controller;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class UserManagement  {

    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colAge;

    private ObservableList<Person> tvObservableList = FXCollections.observableArrayList();


    public void initData(List<Map<String , String>> dataMapList) {
//        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
//        tvData.setItems(tvObservableList);
    }


    @FXML
    private TableView<Person> tvData;
    public class Person {
        private SimpleIntegerProperty id;
        private SimpleStringProperty name;
        private SimpleIntegerProperty age;

        public Person(int id, String name, int age)  {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.age = new SimpleIntegerProperty(age);
        }

        public int getId() {
            return id.get();
        }

        public void setId(int ID) {
            this.id.set(ID);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String nme) {
            this.name.set(nme);
        }

        public int getAge() {
            return age.get();
        }

        public void setAge(int age) {
            this.age.set(age);
        }

        @Override
        public String toString() {
            return "id: " + id.get() + " - " + "name: " + name.get()+ "age: "+ age.get();
        }

    }
}