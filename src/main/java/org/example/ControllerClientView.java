package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerClientView implements Initializable {

    private final String HOST = "localhost";
    private final int SERVER_PORT = 8180;

    private DataInputStream in;
    private DataOutputStream out;

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
        try {

            out.writeUTF(msg);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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

        try {
            Socket socketClient = new Socket(HOST, SERVER_PORT);
            in = new DataInputStream(socketClient.getInputStream());
            out = new DataOutputStream(socketClient.getOutputStream());

            Thread thread1 = new Thread(()->{
               while (true){
                   try {
                       String msg = in.readUTF();
                       if (!msg.isBlank()){
                           chatList.appendText(msg);
                       }
                   }
                   catch (IOException e){
                       e.printStackTrace();
                   }
               }
            });
            thread1.start();
        } catch (IOException e) {
            throw new RuntimeException("Lost connection to server!");
        }
    }
}
