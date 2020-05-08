module com.eva {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires jbcrypt;
    requires com.jfoenix;

    opens com.eva to javafx.fxml;
    exports com.eva;
	opens com.eva.controller to javafx.fxml;
    exports com.eva.controller;
}