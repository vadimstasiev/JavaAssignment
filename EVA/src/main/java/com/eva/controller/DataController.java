package com.eva.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Map;
import java.util.ResourceBundle;

public class DataController implements Initializable {
    public Map dataMap;
    public void initData(Map data) {
        dataMap = data;
        System.out.println("Data Initialized");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
