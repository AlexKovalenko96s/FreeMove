package ua.tlz.freeMove.scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class MainMenu {

	@FXML
	Button b_back;
	@FXML
	Button b_close;
	@FXML
	Button b_tyr;
	@FXML
	Button b_eat;
	@FXML
	Button b_live;
	@FXML
	Button b_fun;
	@FXML
	Button b_transport;
	@FXML
	CheckBox cb_eng = new CheckBox();
	@FXML
	CheckBox cb_ua = new CheckBox();
	static boolean ua = false;
	static boolean eng = false;
	
	@FXML
	private void check_ua(ActionEvent check_ua) throws IOException{
		
		Scene check_ua_scene = new Scene(FXMLLoader.load(getClass().getResource("City_menu.fxml")));
		check_ua_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) check_ua.getSource()).getScene().getWindow();
		app_stage.setScene(check_ua_scene);
		app_stage.show();
	}
	@FXML
	private void check_eng(ActionEvent check_eng) throws IOException{
		Scene check_eng_scene = new Scene(FXMLLoader.load(getClass().getResource("City_menu_eng.fxml")));
		check_eng_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) check_eng.getSource()).getScene().getWindow();
		app_stage.setScene(check_eng_scene);
		app_stage.show();
	}
	
	
	@FXML
	private void tyr(ActionEvent event_tyr) throws IOException{

		if(ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu1.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_tyr.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu1_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_tyr.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void eat(ActionEvent event_eat) throws IOException{
		
		if(ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu2.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_eat.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu2_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_eat.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void live(ActionEvent event_live) throws IOException{
		
		if(ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu3.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_live.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu3_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_live.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void fun(ActionEvent event_fun) throws IOException{
		
		if(ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu4.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_fun.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu4_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_fun.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void transport(ActionEvent event_transport) throws IOException{
		
		if(ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu5.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_transport.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu5_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_transport.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void odesa(ActionEvent event_odesa) throws IOException{
		
		if(cb_ua.isSelected()){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_odesa.getSource()).getScene().getWindow();
			ua = true;
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(cb_eng.isSelected()){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("MainMenu_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_odesa.getSource()).getScene().getWindow();
			eng = true;
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void back_on_city(ActionEvent event_back_on_city) throws IOException{
		
		if(ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("City_menu.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back_on_city.getSource()).getScene().getWindow();
			ua = false;
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("City_menu_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back_on_city.getSource()).getScene().getWindow();
			eng = false;
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
		
		if(ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("MainMenu_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
}
