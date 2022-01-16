package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PerfController {

    @FXML
    private TextField inputField;

    @FXML
    private ListView<String> chatList;
    private Stage stage;

    @FXML
    public void sendTxtToChatList(){
        String txtMessage = inputField.getText();
        if (!txtMessage.isBlank()){
            chatList.getItems().add(txtMessage);
        }
        inputField.clear();
    }

    @FXML
    public void clearChatList(){
        chatList.getItems().clear();
    }

    @FXML
    public void exitApp(){
        System.exit(1);
    }

    @FXML
    public void about() throws IOException {
        App.windowAbout(new Stage());
    }
}
