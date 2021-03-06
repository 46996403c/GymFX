package gymFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Gym Desk, Gimnasios 2.0 (ver0.9)");
        primaryStage.setScene(new Scene(root, 1060, 704));
        primaryStage.getIcons().add(new Image("http://i66.tinypic.com/207qbg7.jpg"));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
