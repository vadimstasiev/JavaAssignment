module com.eva {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.eva to javafx.fxml;
    exports com.eva;
}