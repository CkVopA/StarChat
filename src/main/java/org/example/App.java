package org.example;

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
        scene = new Scene(loadFXML("perf"));
        stage.setScene(scene);
        stage.setTitle("StarChat");
        stage.centerOnScreen();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void windowAbout(Stage stageAbout) throws IOException {
        Scene sceneAbout = new Scene(loadFXML("aboutWindow"));

        stageAbout.setTitle("About APP");
        stageAbout.centerOnScreen();
        stageAbout.show();
    }

    public static void main(String[] args) {
        launch();
    }

}