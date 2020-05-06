package com.eva;

import com.eva.helpers.DatabaseInterface;
import com.eva.model.User;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        scene = new Scene(loadFXML("Login"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}