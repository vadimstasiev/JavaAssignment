>[Video Tutorial](https://www.youtube.com/watch?v=BY-4ONH0DFE)
# JavaFx Properties
[Sample Code](./JavaFx/028_properties)

The purpose of having these properties is to be able to add listeners to these variables.

```java
public class Person {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Returns the StringProperty object
    public StringProperty firstNameProperty() {
        return firstName;
    }

    //Return the firstName value (ie. "Bucky")
    public String getFirstName() {
        return firstName.get();
    }

    //Set the firstName value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }


}
```
Here we are adding a listener to the `firstNameProperty`, in this case we got an anonymous function that gets executed everytime that `firstNameProperty` changes.
```java
bucky.firstNameProperty().addListener( (v, oldValue, newValue) -> {
    System.out.println("Name changed to " + newValue);
    System.out.println("firstNameProperty(): " + bucky.firstNameProperty());
    System.out.println("getFirstName(): " + bucky.getFirstName());
});
```
In this case the value is set to be changed when you click on the `Submit` button.
```java
button = new Button("Submit");
button.setOnAction(e -> bucky.setFirstName("Porky"));
```