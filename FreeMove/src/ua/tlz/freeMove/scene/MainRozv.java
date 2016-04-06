package ua.tlz.freeMove.scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainRozv implements Initializable{

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
	
	@FXML
	private void rozv(ActionEvent event_rozv) throws IOException{
		if(Controller_login.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu_fun.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_rozv.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(Controller_login.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu_fun_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_rozv.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void art(ActionEvent event_art) throws IOException{
		if(Controller_login.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu_art.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_art.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(Controller_login.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu_art_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_art.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void close(ActionEvent event_close){
		System.exit(0);
	}
	
	@FXML
	private void back(ActionEvent event_back) throws IOException{
		if(Controller_login.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(Controller_login.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("MainMenu_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void backin(ActionEvent event_back_in) throws IOException{
		if(Controller_login.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu4.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back_in.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(Controller_login.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu4_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back_in.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image imageDecline = new Image(getClass().getResourceAsStream("img/Close.png"));
		b_close.setGraphic(new ImageView(imageDecline));
	}
}
