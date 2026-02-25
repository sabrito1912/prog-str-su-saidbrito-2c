package controllers; // Cambiado para que coincida con la carpeta física real

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("¡Bienvenido a la aplicación JavaFX!");
    }
}