package com.eva.controller;

import java.sql.ResultSet;

public class DataController {
    public ResultSet myData;
    public void initData(ResultSet data) {
        myData = data;
        System.out.println("Data Initialized");
    }
}
