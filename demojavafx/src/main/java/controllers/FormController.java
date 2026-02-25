package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FormController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtEdad;
    @FXML
    private Label lblResultado;

    @FXML
    public void onValidate(ActionEvent event) {

        String nombre = txtNombre.getText() == null ? "" : txtNombre.getText().trim();
        String correo = txtCorreo.getText() == null ? "" : txtCorreo.getText().trim();

        String edad = txtEdad.getText() == null ? "" : txtEdad.getText().trim();

        List<String> errores = new ArrayList<>();

        if (nombre.isEmpty() || nombre.length() < 3) {
            errores.add("El nombre es muy corto. ");
        }


        if (correo.isEmpty() || !correo.contains("@") || !correo.contains(".")) {
            errores.add("Correo inválido. ");
        }


        try {
            int edadValida = Integer.parseInt(edad);
            if (edadValida < 0 || edadValida > 120) {
                errores.add("Edad fuera de rango (0-120). ");
            }
        } catch (NumberFormatException e) {
            errores.add("La edad debe ser un número. ");
        }


        if (errores.isEmpty()) {
            lblResultado.setText("¡Datos validados con éxito!");
            lblResultado.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        } else {
            // Unimos los errores con un salto de línea o espacio
            StringBuilder mensajeError = new StringBuilder();
            for (String err : errores) {
                mensajeError.append(err);
            }
            lblResultado.setText(mensajeError.toString());
            lblResultado.setStyle("-fx-text-fill: red;");
        }
    }
}