> [Video Tutorial](https://www.youtube.com/watch?v=K7BOH-Ll8_g)
# Introduction to FXML
- [Source Code](../JavaFx/031_fxml)

In the `start` function, it's going to kick off the `FXML` file with the following line:
```java
Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
```

The `FXML` is like the HTML of the GUI application, it represents the view. The `FXML` file represents all of the layout and design that the user sees.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml"
      fx:controller="sample.Controller">
    
    <Label text="I love bacon"/>
    <Button text="Submit"/>
    
</VBox>
```
##### Note: The `*` from `<?import javafx.scene.control.*?>` means that you want to import everything from inside `control`.

You may notice that the VBox has a `Controller`, this is file that will contain all the logic for the given component. 

# Controllers
Every single `FXML` file can only have 1 controller.
> [Video Tutorial](https://www.youtube.com/watch?v=LMdjhuYSrqg)
## How to access a given element from the `FXML` file?
- [Source Code](../JavaFx/032_fxml)

```xml
<VBox prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml"
      fx:controller="sample.Controller">
    
    <Label text="I love bacon"/>
    <Button text="Submit" fx:id="button" onAction="#handleButtonClick"/>
    
</VBox>
```

```java
public class Controller {
    // in the fxml file the button variable is identified by having the same name
    // fx:id="button"
    public Button button;

    public void handleButtonClick() {
        System.out.println("This method has executed");
        button.setText("Stop clicking me!");
    }

}
```
> [Video Tutorial](https://www.youtube.com/watch?v=RojHZhj3UQA)
# Initializing and Binding
- [Source Code](../JavaFx/033_fxml)
## Initializer

An initializer is for whenever you want to run code after the view (`FXML`) loads, for instance, this is a good place to load some user data from the database.

```java
public class Controller implements Initializable {

    @Override
    // this method is called as soon as the view is loaded
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...")
    }

}
```
## Binding
As an example, the goal here will be to bind the text of one label to another. All you have to do is use `${firstLabel.text}` for the text of the label that you want to bind to `firstLabel`.

```xml
<Label text="I love bacon" fx:id="firstLabel"/>
<Label text="${firstLabel.text}" fx:id="secondLabel"/>
```
# Passing Parameters Directly From the Caller to the Controller

[Info Source](https://stackoverflow.com/questions/14187963/passing-parameters-javafx-fxml)

Pass custom data to an FXML controller by retrieving the controller from the FXML loader instance and calling a method on the controller to initialize it with the required data values.