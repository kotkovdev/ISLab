package IntellectualSystem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
    public Pane pane;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("is.fxml"));
        primaryStage.setTitle("Intellectual Systems");
        primaryStage.setScene(new Scene(root, 650, 480));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
