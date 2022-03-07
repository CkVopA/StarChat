package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.ClientStart;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerClientView implements Initializable {



    @FXML
    private TextField inputField;

    @FXML
    private TextArea chatList;

    @FXML
    private ListView<String> listContacts;

    private final ObservableList<String> contacts = FXCollections.observableArrayList(
            "Senior","Middle","Junior"
    );

    @FXML
    public void openWindowAddContact() throws IOException {
        ClientStart.windowAddNewCont(new Stage());
    }

    @FXML
    private TextField fieldNewContact;

    @FXML
    public void addNewContact(){
        String nickname = fieldNewContact.getText();
        if (!nickname.isBlank()){
            contacts.add(nickname);
            listContacts.setItems(contacts.sorted());
        }
        fieldNewContact.clear();
    }

    @FXML
    public void sendMessageToChatList(){
        String msg = inputField.getText();
        inputField.clear();
        if (!msg.isBlank()) {
            appendMessage(msg);
        }
    }

    private void appendMessage(String msg) {
 //       try {
 //           out.writeUTF(msg);
 //       }
 //       catch (IOException e) {
 //           e.printStackTrace();
 //       }
        chatList.appendText(msg + "\n");
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
        ClientStart.windowAbout(new Stage());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listContacts.setItems(contacts);


    }
}
