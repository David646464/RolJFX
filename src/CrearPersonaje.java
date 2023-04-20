import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CrearPersonaje extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Creación de personaje");

        // 1. Creación de los objetos del escenario

        // 1.1. Nombre
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Escribe un nombre");

        HBox nombre = new HBox(10, new Label("Nombre"), txtNombre);

        // 1.2. Raza
        ComboBox<Personaje.Raza> cmbRaza = new ComboBox<>();
        cmbRaza.getItems().addAll(Personaje.Raza.values());

        HBox raza = new HBox(new Label("Raza "), cmbRaza);

        // 1.3. Personaje default
        Personaje p = new Personaje("Sin nombre", "HUMANO");

        // 1.4. Atributos (fuerza, agilidad, constitución, HP, XP, nivel)
        Label atributos = new Label("\n" +
                "Atributos del personaje \n" +
                "\tFuerza: " + p.fuerza + "\n" +
                "\tAgilidad: " + p.agilidad + "\n" +
                "\tConstitución: " + p.constitucion + "\n" +
                "\tPuntos de vida: " + p.puntosVida + "\n" +
                "\tPuntos de experiencia: " + p.experiencia + "\n" +
                "\tNivel: " + p.nivel + "\n");

        // 1.5. Submit
        Button crear = new Button("Crear");

        // 1.5.1. Decorar el botón
        crear.setStyle("-fx-color: gray");
        crear.setTextFill(Color.BISQUE);

        // 1.5.2. Accionar el botón
        crear.setOnAction(e -> {
            p.nombre = txtNombre.getText();
            p.raza = cmbRaza.getValue();
            p.mostrar();

            primaryStage.close();
        });

        VBox crea = new VBox(crear);
        crea.setStyle("-fx-alignment: bottom-right");

        // 2. Montaje del escenario
        VBox vBox = new VBox(10, nombre, raza, atributos, crea);
        vBox.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null))); // Fondo
        vBox.setPadding(new Insets(0, 10, 0, 7.5)); // Margen

        primaryStage.setScene(new Scene(vBox, 250, 250));

        // 3. Mostrar el resultado
        primaryStage.show();
    }
}