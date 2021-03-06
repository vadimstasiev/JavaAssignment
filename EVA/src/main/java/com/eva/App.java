package com.eva;

import com.eva.controller.AlertBox;

import com.eva.controller.DataController;
import com.eva.controller.DialogBox;
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

    public static FXMLLoader loadFXML(String fxml) {
        FXMLLoader fxmlLoader = null;
        try {
            fxmlLoader = new FXMLLoader(
                App.class.getResource("view/" + fxml + ".fxml")
            );
        } catch (Exception e) {
            System.out.println("Error loading FXML");
            System.out.println("Error: " + e);
        }
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

    public static DataController newDataWindow(String title, String view, Map dataMap) {
        DataController controller = null;
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
            controller = loader.<DataController>getController();

            controller.initData(dataMap);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error Creating Data Window");
            System.out.println("Error: "+ e);
        }
        return controller;
    }

    public static void AlertBox(String title, String message, String view) {
        FXMLLoader loader = loadFXML(view);
        Stage modalStage = new Stage();
        //Block events to other windows
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle(title);
        //Display window and wait for it to be closed before returning
        try {
            modalStage.setScene(
                    new Scene(
                            (Pane) loader.load()
                    )
            );
        } catch (IOException e) {
            System.out.println("Error Creating Scene");
            System.out.println("Error: "+ e);
        }
        AlertBox controller = loader.<AlertBox>getController();
        controller.initData(message);
        modalStage.showAndWait();
    }
    public static class DialogReferenceAnswer {
        public String answer = "";
    }

    public static void DialogBox(String title, String message, String view, DialogReferenceAnswer reference) {
        FXMLLoader loader = loadFXML(view);
        Stage modalStage = new Stage();
        //Block events to other windows
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle(title);
        //Display window and wait for it to be closed before returning
        try {
            modalStage.setScene(
                    new Scene(
                            (Pane) loader.load()
                    )
            );
        } catch (IOException e) {
            System.out.println("Error Creating Scene");
            System.out.println("Error: "+ e);
        }
        DialogBox controller = loader.<DialogBox>getController();
        controller.initData(message, reference);
        modalStage.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }

}