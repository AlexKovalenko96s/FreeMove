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
	CheckBox cb_ua;
	@FXML
	CheckBox cb_eng;
	
	@FXML
	private void tyr(ActionEvent event_tyr) throws IOException{
		Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu1.fxml")));
		mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) event_tyr.getSource()).getScene().getWindow();
		app_stage.setScene(mainmenu_scene);
		app_stage.show();
	}
	
	@FXML
	private void eat(ActionEvent event_eat) throws IOException{
		Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu2.fxml")));
		mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) event_eat.getSource()).getScene().getWindow();
		app_stage.setScene(mainmenu_scene);
		app_stage.show();
	}
	
	@FXML
	private void live(ActionEvent event_live) throws IOException{
		Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu3.fxml")));
		mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) event_live.getSource()).getScene().getWindow();
		app_stage.setScene(mainmenu_scene);
		app_stage.show();
	}
	
	@FXML
	private void fun(ActionEvent event_fun) throws IOException{
		Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu4.fxml")));
		mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) event_fun.getSource()).getScene().getWindow();
		app_stage.setScene(mainmenu_scene);
		app_stage.show();
	}
	
	@FXML
	private void transport(ActionEvent event_transport) throws IOException{
		Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu5.fxml")));
		mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) event_transport.getSource()).getScene().getWindow();
		app_stage.setScene(mainmenu_scene);
		app_stage.show();
	}
	

	@FXML
	private void close(ActionEvent event_close){
		System.exit(0);
	}
	
	@FXML
	private void back(ActionEvent event_back) throws IOException{
		Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
		mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
		app_stage.setScene(mainmenu_scene);
		app_stage.show();
	}
}
