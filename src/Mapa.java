import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Mapa extends Application {
    final int CASILLA_SIZE = 30;

    public Mapa() {
    }

    int[][] mapa2 = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 5, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 2, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 4, 1 },
            { 1, 1, 1, 1, 1, 1, 0, 0, 3, 0, 3, 0, 0, 1, 1, 1, 1, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
    };

    int[][] mapa = {
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

    int[][][] mapas = {
            mapa,
            mapa2
    };

    int nummapa = 1;

    int FILAS;
    int COLUMNAS;

    int fila;
    int columna;

    GridPane gridPane;
    Stage stage;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("Mapa");

        gridPane = generaGridInicial(mapas[nummapa]);

        Label lblEstado = new Label("Usa WASD para mover");

        VBox vbox = new VBox(gridPane, lblEstado);

        scene = new Scene(vbox);
        scene.setOnKeyPressed(e -> mover(e.getCode().getChar().charAt(0)));

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane generaGridInicial(int[][] mapa) {
        gridPane = new GridPane();

        FILAS = mapa.length;
        COLUMNAS = mapa[0].length;

        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++) {
                Rectangle r = new Rectangle(CASILLA_SIZE, CASILLA_SIZE, Color.WHITE);
                r.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                if (i == fila && j == columna) {
                    r.setFill(Color.BLUE);
                }
                switch (mapa[i][j]) {
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

        return gridPane;
    }

    private void mover(char ch) {
        switch (ch) {
            case 'W':
                if (fila > 0 && mapas[nummapa][fila - 1][columna] != 1) {
                    if (fila > 0 && mapas[nummapa][fila - 1][columna] != 5) {
                        if (fila > 0 && mapas[nummapa][fila - 1][columna] != 4) {
                            if (fila > 0 && mapas[nummapa][fila - 1][columna] != 3) {
                                Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                                rOld.setFill(Color.WHITE);

                                fila--;

                                Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                                rNew.setFill(Color.BLUE);
                            } else {
                                mostrarEnemigo();
                            }
                        } else {
                            mostrarDialogoFin();
                        }
                    } else {
                        mostrarTienda();
                    }
                }
                break;
            case 'S':
                if (fila > 0 && mapas[nummapa][fila + 1][columna] != 1) {
                    if (fila > 0 && mapas[nummapa][fila + 1][columna] != 5) {
                        if (fila > 0 && mapas[nummapa][fila + 1][columna] != 4) {
                            if (fila > 0 && mapas[nummapa][fila + 1][columna] != 3) {
                                Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                                rOld.setFill(Color.WHITE);

                                fila++;

                                Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                                rNew.setFill(Color.BLUE);
                            } else {
                                mostrarEnemigo();
                            }
                        } else {
                            mostrarDialogoFin();
                        }
                    } else {
                        mostrarTienda();
                    }
                }
                break;
            case 'A':
                if (fila > 0 && mapas[nummapa][fila][columna - 1] != 1) {
                    if (fila > 0 && mapas[nummapa][fila][columna - 1] != 5) {
                        if (fila > 0 && mapas[nummapa][fila][columna - 1] != 4) {
                            if (fila > 0 && mapas[nummapa][fila][columna - 1] != 3) {
                                Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                                rOld.setFill(Color.WHITE);

                                columna--;

                                Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                                rNew.setFill(Color.BLUE);
                            } else {
                                mostrarEnemigo();
                            }
                        } else {
                            mostrarDialogoFin();
                        }
                    } else {
                        mostrarTienda();
                    }
                }
                break;
            case 'D':
                if (fila > 0 && mapas[nummapa][fila][columna + 1] != 1) {
                    if (fila > 0 && mapas[nummapa][fila][columna + 1] != 5) {
                        if (fila > 0 && mapas[nummapa][fila][columna + 1] != 4) {
                            if (fila > 0 && mapas[nummapa][fila][columna + 1] != 3) {
                                Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                                rOld.setFill(Color.WHITE);

                                columna++;

                                Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                                rNew.setFill(Color.BLUE);
                            } else {
                                mostrarEnemigo();
                            }
                        } else {
                            mostrarDialogoFin();
                        }
                    } else {
                        mostrarTienda();
                    }
                }
                break;
        }

        if (mapas[nummapa][fila][columna] == 3) {
            mostrarDialogoFin();

            if (nummapa < mapas.length - 1) {
                nummapa++;

                gridPane = generaGridInicial(mapas[nummapa]);
            } else {
                stage.close();
            }
        }
    }

    private void mostrarDialogoFin() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("¡VICTORIA!");
        dialog.setContentText("¡Has superado el nivel " + (nummapa + 1) + "!");
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK"));
        dialog.showAndWait();
    }

    private void mostrarTienda() {
        AnchorPane root = new AnchorPane();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) scene.getWindow();

        stage.setScene(newScene);
    }

    private void mostrarEnemigo() {
    }

    public static void main(String[] args) {
        launch();
    }
}