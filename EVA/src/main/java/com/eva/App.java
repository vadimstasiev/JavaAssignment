package com.eva;

import com.eva.controller.AlertBox;

import com.eva.controller.DataController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Map;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        newSimpleWindow("Login", "Login");
    }

    private static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("view/" + fxml + ".fxml")
        );
        return fxmlLoader;
    }

    public static void newSimpleWindow(String title, String view) {
        try {
            FXMLLoader loader = loadFXML(view);
            Stage stage = new Stage();
            stage.setTitle(title);
            //Display window and wait for it to be closed before returning
            stage.setScene(
                    new Scene(
                            (Pane) loader.load()
                    )
            );
            stage.show();
        } catch (IOException e) {
            System.out.println("Error Creating Simple Window");
            System.out.println("Error: "+ e);
        }
    }

    public static void newDataWindow(String title, String view, Map dataMap) {
        try {
            FXMLLoader loader = loadFXML(view);
            Stage stage = new Stage();
            stage.setTitle(title);
            //Display window and wait for it to be closed before returning
            stage.setScene(
                    new Scene(
                            (Pane) loader.load()
                    )
            );
            DataController controller = loader.<DataController>getController();

            controller.initData(dataMap);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error Creating Data Window");
            System.out.println("Error: "+ e);
        }
    }

        // TODO: must rename this later
    public static void AlertBox(String title, String message, String view) throws IOException {
        FXMLLoader loader = loadFXML(view);
        Stage modalStage = new Stage();
        //Block events to other windows
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle(title);
        //Display window and wait for it to be closed before returning
        modalStage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );
        AlertBox controller = loader.<AlertBox>getController();
        controller.initData(message);
        modalStage.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }

}