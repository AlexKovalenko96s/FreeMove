package ua.tlz.freeMove;	

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
		
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("scene/MainMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("scene/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public static void main(String[] args) throws Exception {	
		launch(args);	
	}
}
