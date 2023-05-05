import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TiendaJFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       BorderPane pantallaInventario = new BorderPane();
      
       Label tituloInventario = new Label("Inventario");

       Button botonInventario = new Button("Inventario");
       Button botonVender = new Button("Vender");
       Button botonComprar = new Button("Comprar");
       Button botonSalirTienda = new Button("Salir");
       VBox botones = new VBox(botonComprar, botonVender, botonInventario, botonSalirTienda);

       GridPane inventario = new GridPane();
       inventario.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));

      
       for (int i =0; i < 7; i++){
        for (int e =0; e < 7; e++){
           
                CheckBox cuadrado = new CheckBox();
                
                
                cuadrado.setSelected(false);
                cuadrado.setPrefSize(40, 40);
                cuadrado.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
                
                inventario.setMargin(cuadrado, new Insets(2, 2, 2, 2));
                inventario.add(cuadrado,i,e);
                
        }
       }
       pantallaInventario.setTop(tituloInventario);
       pantallaInventario.setRight(botones);
       pantallaInventario.setCenter(inventario);
       Scene scene = new Scene(pantallaInventario);
     
     
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }
    public static void main(String[] args) {
        launch();
    }
    
}
