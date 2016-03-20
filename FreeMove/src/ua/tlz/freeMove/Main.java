package ua.tlz.freeMove;	

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Main extends Application {
		
	@FXML
	CheckBox cb_eng = new CheckBox();
	@FXML
	CheckBox cb_ua = new CheckBox();
//	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	
		Parent root = FXMLLoader.load(getClass().getResource("scene/City_menu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("scene/application.css").toExternalForm());
	    primaryStage.setScene(scene);
	    primaryStage.show();		
		
	}

	public static void main(String[] args) throws Exception {	
		launch(args);	
	}
}
