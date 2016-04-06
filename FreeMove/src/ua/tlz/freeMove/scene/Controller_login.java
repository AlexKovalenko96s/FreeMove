package ua.tlz.freeMove.scene;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ua.tlz.freeMove.scene.User_experience.User_experience;

public class Controller_login {

	@FXML TextField textLOGIN;
	@FXML PasswordField textPASSWORD;
	@FXML Label uncorrect;
	public static boolean ua = true;
	public static boolean eng = false;
	public static String login;
	
	public void log_in(ActionEvent e) throws SQLException, IOException{
		
	Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		
		login = textLOGIN.getText();
		java.sql.PreparedStatement myStmt;
		myStmt = myConn.prepareStatement("select * from users where user_name = ? and password = ? ");
		myStmt.setString(1, textLOGIN.getText());
		myStmt.setString(2, textPASSWORD.getText());
		ResultSet result = myStmt.executeQuery();
		
		if(result.next()){
			
			User_experience.check();
			
			
			if(User_experience.eng == true && User_experience.Odesa == true ){
				Scene mainmenu_eng_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu_eng.fxml")));
				mainmenu_eng_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				ua = false;
				eng = true;
				app_stage.setScene(mainmenu_eng_scene);
				app_stage.show();

			}
			
			if(User_experience.ua == true && User_experience.Odesa == true ){
				Scene mainmenu_scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
				mainmenu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				eng = false;
				ua = true;
				app_stage.setScene(mainmenu_scene);
				app_stage.show();
			}
			
			if((User_experience.ua == true || User_experience.no_language == true) && User_experience.no_city == true ){
				Scene city_menu_scene = new Scene(FXMLLoader.load(getClass().getResource("City_menu.fxml")));
				city_menu_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				eng = false;
				ua = true;
				app_stage.setScene(city_menu_scene);
				app_stage.show();
			}
			
			if(User_experience.eng == true && User_experience.no_city == true){
				Scene city_menu_eng_scene = new Scene(FXMLLoader.load(getClass().getResource("City_menu_eng.fxml")));
				city_menu_eng_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				ua = false;
				eng = true;
				app_stage.setScene(city_menu_eng_scene);
				app_stage.show();		
			}			
		}			
		else{
			uncorrect.setText("Uncorrect Login or Password!");
		}
	}
	
	public void sign_up(ActionEvent e) throws IOException{
		Scene sign_up_scene = new Scene(FXMLLoader.load(getClass().getResource("SignUP.fxml")));
		sign_up_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(sign_up_scene);
		app_stage.show();
	}
}
