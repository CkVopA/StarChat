package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.models.Network;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ClientStart extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("clientView"));
        stage.setScene(scene);
        stage.setTitle("StarChat");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

        Network network = new Network();
        network.connect();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientStart.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void windowAbout(Stage stageAbout) throws IOException {
        Scene sceneAbout = new Scene(loadFXML("aboutWindow"));
        stageAbout.setScene(sceneAbout);
        stageAbout.setTitle("About APP");
        stageAbout.centerOnScreen();
        stageAbout.show();
    }

    public static void windowAddNewCont(Stage stAddCont) throws IOException {
        Scene sceneAddCont = new Scene(loadFXML("addNewCont"));
        stAddCont.setScene(sceneAddCont);
        stAddCont.setResizable(false);
        stAddCont.setTitle("Добавление нового контакта");
        stAddCont.show();
    }

    public static void main(String[] args) {
        launch();
    }
}