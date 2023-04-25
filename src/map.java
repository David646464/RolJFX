import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class map extends Application {
    final int FILAS = 15;
    final int COLUMNAS = 15;
    final int CASILLA_SIZE = 20;

    int[][] mapa1 = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 2, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 5, 1 },
            { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 4, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
    };

    int fila;
    int columna;
    int numMapa = 0;

    GridPane gridPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mapa");

        gridPane = new GridPane();

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Rectangle r = new Rectangle(CASILLA_SIZE, CASILLA_SIZE, Color.WHITE);
                r.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");

                if (i == fila && j == columna) {
                    r.setFill(Color.BLUE);
                }

                switch (mapa1[i][j]) {
                    case 0:
                        r.setFill(Color.WHITE);
                        break;
                    case 1:
                        r.setFill(Color.BLACK);
                        break;
                    case 2:
                        r.setFill(Color.BLUE);
                        fila = i;
                        columna = j;
                        break;
                    case 3:
                        r.setFill(Color.RED);
                        break;
                    case 4:
                        r.setFill(Color.GREEN);
                        break;
                    case 5:
                        r.setFill(Color.YELLOW);
                        break;
                }

                gridPane.add(r, j, i);
            }
        }

        Label lblEstado = new Label("Usa WASD para mover");

        VBox vbox = new VBox(gridPane, lblEstado);

        Scene scene = new Scene(vbox);

        scene.setOnKeyPressed(e -> mover(e.getCode().getChar().charAt(0)));

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void mover(char ch) {
        switch (ch) {
            case 'W':
                if (fila > 0 && mapa1[fila - 1][columna] != 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);

                    fila--;

                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);

                    // Comprobar si la casilla es 5 para abrir la pestaña de la tienda
                }
                break;
            case 'S':
                if (fila < FILAS - 1 && mapa1[fila + 1][columna] != 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);

                    fila++;

                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
            case 'A':
                if (columna > 0 && mapa1[fila][columna - 1] != 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);

                    columna--;

                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
            case 'D':
                if (columna < COLUMNAS - 1 && mapa1[fila][columna + 1] != 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);

                    columna++;

                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;

                if (mapa1[numMapa][fila][columna] == 3) {
                    mostrarDialogoFin();
                    if (numMapa < mapa1.length - 1) {
                        numMapa++;
                        gridPane = generaGridInicial(mapa1[numMapa]);
                    } else {
                        stage.close();
                    }
                }
        }
    }

    private void mostrarDialogoFin() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Enhorabuena!!");
        dialog.setContentText("Has llegado a la casilla final del mapa!!");
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK"));
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}