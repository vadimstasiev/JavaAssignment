package com.eva;

import com.eva.controller.AlertBox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        DatabaseInterface connect = new DatabaseInterface();
////        connect.getData();
//        User userObject = new User(connect);
//        Integer id = null;
//        userObject.createUser(
//                3,
//                "Vadim",
//                "Stasiev",
//                "Male",
//                "dsgsdf ",
//                "idk",
//                "bedfordshire",
//                "sdf",
//                "21/03/1998",
//                false,
//                "kjdfgbiufh3wur3hkjb3jwb"
//        );

//        userObject.deleteUser(1);
        scene = new Scene(loadFXML("Login").load());
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }

    private static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("view/" + fxml + ".fxml")
        );
        return fxmlLoader;
    }

    public static void modal(String title, String message, String view) throws IOException {
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