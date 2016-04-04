package ua.tlz.freeMove;	

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ua.tlz.freeMove.scene.Controller_login;
import ua.tlz.freeMove.scene.MainMenu;
import ua.tlz.freeMove.scene.User_experience.User_experience;

public class Main extends Application {
		
	@FXML
	CheckBox cb_eng = new CheckBox();
	@FXML
	CheckBox cb_ua = new CheckBox();
	static Controller_login c_login = new Controller_login();
	
	@Override
	public void start(Stage primaryStage) throws IOException {
				
		if(User_experience.no_language == true && User_experience.no_city == true){
			Parent root = FXMLLoader.load(getClass().getResource("scene/City_menu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("scene/application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setTitle("FreeMove");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("scene/img/ico.png")));
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}

	public static void main(String[] args) throws Exception {	
		launch(args);	
	}
}
