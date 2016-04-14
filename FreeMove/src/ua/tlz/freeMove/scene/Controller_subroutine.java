package ua.tlz.freeMove.scene;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

public class Controller_subroutine implements Initializable{
	
	@FXML Button b_close;
	@FXML Button must_see;
	@FXML Button colorful;
	@FXML Button themed;
	public static String type_list;
	
	public void must_see(ActionEvent e) throws IOException, SQLException{

		
//		if("null".equals(Controller_login.login) && "null".equals(Controller_login.password)){
//			Scene must_see_ua = new Scene(FXMLLoader.load(getClass().getResource("must_see/list.fxml")));
//			must_see_ua.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			Stage app_stage_must_see_ua = (Stage) ((Node) e.getSource()).getScene().getWindow();
//			app_stage_must_see_ua.setScene(must_see_ua);
//			app_stage_must_see_ua.show();
//		}
//		
		
		if("Admin".equals(Controller_login.login) && "admin".equals(Controller_login.password)){
			Scene must_see_ua = new Scene(FXMLLoader.load(getClass().getResource("must_see_ADMIN/Main.fxml")));
			//must_see_ua.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage_must_see_ua = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage_must_see_ua.setScene(must_see_ua);
			app_stage_must_see_ua.show();
		}
		
		else {
			if(must_see.isHover()){
				type_list = "must_see";
			}
			if(colorful.isHover()){
				type_list = "colorful";
			}
			if(themed.isHover()){
				type_list = "themed";
			}
			Scene must_see_ua = new Scene(FXMLLoader.load(getClass().getResource("must_see/list.fxml")));
			must_see_ua.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage_must_see_ua = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage_must_see_ua.setScene(must_see_ua);
			app_stage_must_see_ua.show();
		}
	}
	
	@FXML
	private void close(ActionEvent event_close){
		System.exit(0);
	}
	
	@FXML
	private void back(ActionEvent event_back) throws IOException{
		Scene menu1_ua_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
		menu1_ua_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage menu1_ua_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
		menu1_ua_stage.setScene(menu1_ua_scene);
		menu1_ua_stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image imageDecline_close = new Image(getClass().getResourceAsStream("img/Close.png"));
		b_close.setGraphic(new ImageView(imageDecline_close));
	}
}
