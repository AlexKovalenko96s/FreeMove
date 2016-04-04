package ua.tlz.freeMove.scene;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ua.tlz.freeMove.scene.User_experience.User_experience;

public class MainMenu implements Initializable{

	@FXML
	Label l;
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
	@FXML
	public static Label user_name;
	
	@FXML
	private void check_ua(ActionEvent check_ua) throws IOException, SQLException{
		
		Scene check_ua_scene = new Scene(FXMLLoader.load(getClass().getResource("City_menu.fxml")));
		check_ua_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) check_ua.getSource()).getScene().getWindow();
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		java.sql.PreparedStatement myStmt = myConn
				.prepareStatement("update users set language=? where user_name=?");
		String n = "ua";
		myStmt.setString(1, n);
		myStmt.setString(2, Controller_login.login);
		myStmt.executeUpdate();
		app_stage.setScene(check_ua_scene);
		app_stage.show();
	}
	@FXML
	private void check_eng(ActionEvent check_eng) throws IOException, SQLException{
		
		Scene check_eng_scene = new Scene(FXMLLoader.load(getClass().getResource("City_menu_eng.fxml")));
		check_eng_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) check_eng.getSource()).getScene().getWindow();
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		java.sql.PreparedStatement myStmt = myConn
				.prepareStatement("update users set language=? where user_name=?");
		String n = "eng";
		myStmt.setString(1, n);
		myStmt.setString(2, Controller_login.login);
		myStmt.executeUpdate();
		app_stage.setScene(check_eng_scene);
		app_stage.show();
	}
	
	
	@FXML
	private void tyr(ActionEvent event_tyr) throws IOException{

		if(User_experience.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu1.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_tyr.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(User_experience.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu1_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_tyr.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void eat(ActionEvent event_eat) throws IOException{
		
		if(User_experience.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu2.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_eat.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(User_experience.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu2_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_eat.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void live(ActionEvent event_live) throws IOException{
		
		if(User_experience.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu3.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_live.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(User_experience.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu3_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_live.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void fun(ActionEvent event_fun) throws IOException{
		
		if(User_experience.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu4.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_fun.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(User_experience.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu4_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_fun.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void transport(ActionEvent event_transport) throws IOException{
		
		if(User_experience.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("Menu5.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_transport.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(User_experience.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("Menu5_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_transport.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void odesa(ActionEvent event_odesa) throws IOException, SQLException{
		
		if(cb_ua.isSelected() || User_experience.Odesa == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_odesa.getSource()).getScene().getWindow();		
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
			java.sql.PreparedStatement myStmt = myConn
					.prepareStatement("update users set city=? where user_name=?");
			String n = "odesa";
			myStmt.setString(1, n);
			myStmt.setString(2, Controller_login.login);
			myStmt.executeUpdate();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(cb_eng.isSelected()|| User_experience.Odesa == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("MainMenu_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_odesa.getSource()).getScene().getWindow();	
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
			java.sql.PreparedStatement myStmt = myConn
					.prepareStatement("update users set city=? where user_name=?");
			String n = "odesa";
			myStmt.setString(1, n);
			myStmt.setString(2, Controller_login.login);
			myStmt.executeUpdate();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	@FXML
	private void back_on_city(ActionEvent event_back_on_city) throws IOException, SQLException{
		
		if(User_experience.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("City_menu.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back_on_city.getSource()).getScene().getWindow();
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
			java.sql.PreparedStatement myStmt = myConn
					.prepareStatement("update users set city=? where user_name=?");
			String n = "no";
			myStmt.setString(1, n);
			myStmt.setString(2, Controller_login.login);
			user_name.setText(Controller_login.login);
			myStmt.executeUpdate();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(User_experience.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("City_menu_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back_on_city.getSource()).getScene().getWindow();
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
			java.sql.PreparedStatement myStmt = myConn
					.prepareStatement("update users set city=? where user_name=?");
			String n = "no";
			myStmt.setString(1, n);
			myStmt.setString(2, Controller_login.login);
			user_name.setText(Controller_login.login);
			myStmt.executeUpdate();
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
		
		if(User_experience.ua == true){
			Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
			mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene);
			app_stage.show();
		}
		if(User_experience.eng == true){
			Scene mainmenu_scene_eng = new Scene(FXMLLoader.load(getClass().getResource("MainMenu_eng.fxml")));
			mainmenu_scene_eng.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
			app_stage.setScene(mainmenu_scene_eng);
			app_stage.show();
		}
	}
	
	public void login(ActionEvent e) throws IOException{
		Scene login_scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
		login_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(login_scene);
		app_stage.show();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image imageDecline = new Image(getClass().getResourceAsStream("Close.png"));
		b_close.setGraphic(new ImageView(imageDecline));
	}
}
