package sample;

// Importurile necesare:
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Aplicatia principala si locatia fisierului FXML:
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ATM System");
        primaryStage.setScene(new Scene(root, 1400, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
