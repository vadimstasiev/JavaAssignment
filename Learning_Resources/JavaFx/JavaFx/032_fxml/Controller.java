package sample;

import javafx.fxml.control.*;

public class Controller {
    // in the fxml file the button variable is identified by having the same name
    // fx:id="button"
    public Button button;

    public void handleButtonClick() {
        System.out.println("This method has executed");
        button.setText("Stop clicking me!");
    }

}