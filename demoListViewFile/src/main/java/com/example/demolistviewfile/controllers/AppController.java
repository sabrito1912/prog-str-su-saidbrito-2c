package com.example.demolistviewfile.controllers;

import com.example.demolistviewfile.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;
import java.io.IOException;

public class AppController {

    @FXML
    private Label lbMsg;

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAge;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service = new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        loadFromFile();
    }

    @FXML
    public void onReaload(){
        loadFromFile();
    }

    @FXML
    public void onAddPerson(){

        try{

            String name = txtName.getText();
            String email = txtEmail.getText();
            int age = Integer.parseInt(txtAge.getText());

            // Validaciones
            if(age < 0){
                throw new IllegalArgumentException("La edad no puede ser negativa");
            }

            if(age < 18){
                throw new IllegalArgumentException("Solo se aceptan mayores de edad");
            }

            service.addPerson(name, email, age);

            lbMsg.setText("Usuario creado correctamente!");
            lbMsg.setStyle("-fx-text-fill: green");

            txtName.clear();
            txtEmail.clear();
            txtAge.clear();

            loadFromFile();

        } catch (NumberFormatException e){
            lbMsg.setText("La edad debe ser un número válido");
            lbMsg.setStyle("-fx-text-fill: red");

        } catch (IOException e) {
            lbMsg.setText("Error de archivo "+ e.getMessage());
            lbMsg.setStyle("-fx-text-fill: red");

        } catch (IllegalArgumentException e) {
            lbMsg.setText(e.getMessage());
            lbMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try {
            List<String> items = service.loadForListView();
            data.setAll(items);
            lbMsg.setText("Datos cargados correctamente");
            lbMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e) {
            lbMsg.setText("Error "+e.getMessage());
            lbMsg.setStyle("-fx-text-fill: red");
        }
    }
}