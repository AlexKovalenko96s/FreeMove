package ua.tlz.freeMove.scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainRozv {

	@FXML
	Button b_back;
	@FXML
	Button b_back_in;
	@FXML
	Button b_close;
	@FXML
	Button b_rozv;
	@FXML
	Button b_art;
	
	MainMenu mm = new MainMenu();
	
	@FXML
	private void rozv(ActionEvent event_rozv) throws IOException{
		if(MainMenu.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu_fun.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_rozv.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(MainMenu.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu_fun_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_rozv.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void art(ActionEvent event_art) throws IOException{
		if(MainMenu.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu_art.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_art.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(MainMenu.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu_art_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_art.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void close(ActionEvent event_close){
		if(MainMenu.ua == true){
			MainMenu.delstart();
			System.exit(0);
		}
		if(MainMenu.eng == true){
			MainMenu.delstart();
			System.exit(0);
		}
	}
	
	@FXML
	private void back(ActionEvent event_back) throws IOException{
		if(MainMenu.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(MainMenu.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("MainMenu_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void backin(ActionEvent event_back_in) throws IOException{
		if(MainMenu.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu4.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back_in.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(MainMenu.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu4_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back_in.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
}
