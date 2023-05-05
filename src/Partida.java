import javafx.application.Application;
import javafx.stage.Stage;

public class Partida extends Application {
    Bienvenida bienvenida = new Bienvenida();
    Personaje personaje;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        bienvenida.start(primaryStage);
        personaje = bienvenida.cp.p;
       
    }
    
    public static void main(String[] args) {
        launch();
        
        
    }
    
}
