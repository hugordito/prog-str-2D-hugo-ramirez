package com.example.demo.controllers;

import com.example.demo.servicies.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class appController {
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtEdad;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;

    private final ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service = new PersonService();


    @FXML
    public void initialize(){ // se va a ejecutar el inicia, cuando cargue
        //Iniciar listview
        loadFromFile();
        listView.setItems(data);
    }
    @FXML
    public void onAddPerson(){
        try{
            String name= txtName.getText();
            String email= txtEmail.getText();
            String edad = txtEdad.getText();

            service.addPersone(name,email,edad);
            lblMsg.setText("Persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
            loadFromFile();
        } catch (IOException e) {
            lblMsg.setText("huno un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText("huno un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    private void loadFromFile(){
        try{
            List<String> items = service.loadDataList();
            data.setAll(items);
            lblMsg.setText("Datos cargados con normalidad");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

}
