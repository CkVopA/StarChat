package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ControllerAddNewCont {

    @FXML
    private Button buttonAddContact;

    @FXML
    private TextField fieldNewContact;


    @FXML
    public void addNewContact(){
        String nickname = fieldNewContact.getText();
        ArrayList<String> contactsAdd = new ArrayList<>();
        contactsAdd.add(nickname);
        fieldNewContact.clear();
        System.out.println(contactsAdd);
    }
}
