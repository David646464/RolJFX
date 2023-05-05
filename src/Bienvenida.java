import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bienvenida extends Application {
    CrearPersonaje cp = new CrearPersonaje();
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Juego de rol");

        // Texto de bienvenida
        Label txtBienvenida = new Label("Bienvenido");

        VBox bienvenida = new VBox(txtBienvenida);
        bienvenida.setStyle("-fx-alignment: center");

        // Texto explicación
        Label txtExplicacion = new Label(
                "Este juego está realizado en conjunto por: \n\tAnxo Quintana\n\tDavid Sánchez");

        // Texto gracias
        Label txtGracias = new Label("¡Gracias por probarlo! <3");

        VBox gracias = new VBox(txtGracias);
        gracias.setStyle("-fx-alignment: center");

        // Botón de crear personaje
        Button btnCrearPersonaje = new Button("Crear personaje");
        btnCrearPersonaje.setStyle("-fx-color: #ededb7");

        // Ir a la pantalla de creación de personaje
        btnCrearPersonaje.setOnMouseClicked(e -> {
            

            try {
                cp.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        VBox crearPersonaje = new VBox(btnCrearPersonaje);
        crearPersonaje.setStyle("-fx-alignment: center");

        // Decorar VBox
        VBox vBox = new VBox(15, bienvenida, txtExplicacion, gracias, crearPersonaje);
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        vBox.setPadding(new Insets(10, 0, 0, 7.5));

        // Escenario
        Scene scene = new Scene(vBox, 300, 270);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}