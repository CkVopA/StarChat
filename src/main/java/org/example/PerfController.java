package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PerfController {

    @FXML
    private TextField inputField;

    @FXML
    private TextArea chatList;

    @FXML
    private ListView<String> listContacts;
@FXML
    public ListView<String> getListContacts() {
        return listContacts;
    }

    ObservableList<String> contacts = FXCollections.observableArrayList(
            "Senior","Middle","Junior");
    @FXML
    void initialize (){
    listContacts.setItems(contacts);
    }

    @FXML
    public void openWindowAddContact() throws IOException {
        App.windowAddNewCont(new Stage());
    }

    @FXML
    public void sendTxtToChatList(){
        String txtMessage = inputField.getText();
        if (!txtMessage.isBlank()){
            chatList.appendText(txtMessage + "\n");
        }
        inputField.clear();
    }

    @FXML
    public void clearChatList(){
        chatList.clear();
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
