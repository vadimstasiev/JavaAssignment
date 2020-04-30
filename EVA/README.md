[Source](https://github.com/vadimstasiev/JavaFX_Template)

# JavaFX Template
## Install the requirements
1. Download and install the [Java SE Development Kit 14](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) and make sure that it is set as PATH.
2. Download and install the [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).

## Create the Project from Scratch
1. Open the `IntelliJ IDEA` and click on *Create New Project*.
2. Select `Maven` and then for the Project SDK, select the version 14, the one that was just installed.
3. Toggle the option `Create from archetype` and then click on *Add Archetype*.
4. A window should pop up, so fill it with the following details and click OK.
    - GroupId: org.openjfx
    - ArtifactId: javafx-maven-archetypes
    - Version: 0.0.1
5. Make sure that the added archetype is currently selected and click Next.
6. For this next window is where you setup the package name for the project used in this example the settings were:
    - Name: eva
    - Artifact Coordinates
        - GroupId: com.eva
        - ArtifactId: eva
        - Version: 1.0-SNAPSHOT
7. Click Next.
8. In the next window you should see some default properties for our maven build, you want to change the `archetypeArtifactId`, so double-click on it:
    - Name: archetypeArtifactId
    - Value: javafx-archetype-fxml 
9. Click on Add Maven Property ( `+ Button` )
    - Name: javafx-version
    - Value: 14
10. Click Finish

## Setup the Run Configuration
1. Click Add Configuration (top right).
2. Click the `+` icon and select `Maven`.
3. Change the name to `Run`.
4. On the `Comand line:` add `javafx:compile`.
5. Scroll to the bottom where it says `Before Launch`, add a `Run Maven Goal` and on the `Comand line` enter `javafx:run`.
## Open the Existing Project
To open the existing project all that you have to do is open this folder in `IntelliJ IDEA`.