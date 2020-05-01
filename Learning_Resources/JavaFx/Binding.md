# Binding Properties
> [Video Tutorial](https://www.youtube.com/watch?v=s8GomyEOA8w) 

[Sample Code](./JavaFx/029_binding)

The prupose of binding properties is, for example, if you have a variable x that was bound to y, then y gets automatically updated if x is changed, i.e:

```java
IntegerPropery x = new SimpleIntegerProperty(3);
IntegerPropery y = new SimpleIntegerProperty();
y.bind(x.multpiply(10)); // y gets automatically updated if x is changed
```
## Binding Properties in JavaFx
> [Video Tutorial](https://www.youtube.com/watch?v=6Zi2L0kHSx4) 

[Sample Code](./JavaFx/030_bindingPropertiesExample)

```java
window = primaryStage;
window.setTitle("thenewboston");

//Input and labels
TextField userInput = new TextField();
userInput.setMaxWidth(200);
Label firstLabel = new Label("Welcome to the site ");
Label secondLabel = new Label();

HBox bottomText = new HBox(firstLabel, secondLabel);
bottomText.setAlignment(Pos.CENTER);
VBox vBox = new VBox(10, userInput, bottomText);
vBox.setAlignment(Pos.CENTER);

//bind 
secondLabel.textProperty().bind(userInput.textProperty());

Scene scene = new Scene(vBox, 300, 200);
window.setScene(scene);
window.show();
```