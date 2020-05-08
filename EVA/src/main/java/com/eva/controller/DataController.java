package com.eva.controller;

import java.sql.ResultSet;
import java.util.Map;

public class DataController {
    public Map dataMap;
    public void initData(Map data) {
        dataMap = data;
        System.out.println("Data Initialized");
    }
}
