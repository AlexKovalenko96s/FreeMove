package ua.tlz.freeMove;	

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ua.tlz.freeMove.regedit.AddReg;
import ua.tlz.freeMove.regedit.DelReg;
import ua.tlz.freeMove.regedit.Error;
import ua.tlz.freeMove.scene.MainMenu;

public class Main extends Application {
		
	@FXML
	CheckBox cb_eng = new CheckBox();
	@FXML
	CheckBox cb_ua = new CheckBox();
	static Error er = new Error();
	static AddReg ar = new AddReg();
	static DelReg dr = new DelReg();
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	
		main_start();
		er.proverkaM();
		
		if(Error.start != true){
			
			if(Error.odessa == true && Error.ua == true ){
				start();
				Parent root = FXMLLoader.load(getClass().getResource("scene/MainMenu.fxml"));
				Scene scene = new Scene(root);
				MainMenu.ua= true;
				scene.getStylesheets().add(getClass().getResource("scene/application.css").toExternalForm());
				primaryStage.initStyle(StageStyle.UNDECORATED);
				primaryStage.setTitle("FreeMove");
				primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("scene/img/ico.png")));
			    primaryStage.setScene(scene);
			    primaryStage.show();	
			}
			
			if(Error.odessa == true && Error.eng == true){
				start();
				Parent root = FXMLLoader.load(getClass().getResource("scene/MainMenu_eng.fxml"));
				Scene scene = new Scene(root);
				MainMenu.eng= true;
				scene.getStylesheets().add(getClass().getResource("scene/application.css").toExternalForm());
				primaryStage.initStyle(StageStyle.UNDECORATED);
				primaryStage.setTitle("FreeMove");
				primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("scene/img/ico.png")));
				primaryStage.setScene(scene);
			    primaryStage.show();	
			}
			
			if(Error.eng != true && Error.ua != true){
				start();
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
		else{
			JOptionPane.showMessageDialog(null, "Program allready start!");
			delstart();
		}
	}
	

	public static void main(String[] args) throws Exception {	
		launch(args);	
	}
	
	public static void start() {
		String addres = "HKEY_CURRENT_USER\\Software\\FreeMove";
		String name = "START";
		String value = "now";
		ar.run(addres, name, value);
	}
	
	public static void main_start() {
		String addres = "HKEY_CURRENT_USER\\Software\\FreeMove";
		String name = "main";
		String value = "now";
		ar.run(addres, name, value);
	}
	
	public static void delstart() {
		String addres = "HKEY_CURRENT_USER\\Software\\FreeMove";
		String name = "START";
		dr.run(addres, name);
	}
}
