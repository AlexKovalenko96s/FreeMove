package ua.tlz.freeMove.scene.free_time;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class Controller_list implements Initializable {
	static String mm = "";
	@FXML ListView<String>listView;
	@FXML Label l_company;
	@FXML Label l_address;
	@FXML Label l_number;
	@FXML Label l_web;
	Scene s;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "root", "root");
			ResultSet myRes = null;
			java.sql.PreparedStatement myStat;
			myStat = myCon.prepareStatement("select * from active where Type = ?");
			myStat.setString(1, Controller_main.type);
			myRes = myStat.executeQuery();
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			while (myRes.next()) {
				listView.getItems().addAll(myRes.getString("Company"));
			}
		} catch (SQLException e) {
		}
		
	}
	
	public void information() throws SQLException {
		Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "root", "root");
		ResultSet myRes = null;
		ObservableList<String>moving;
		moving = listView.getSelectionModel().getSelectedItems();
		for(String m : moving){
			mm = m;
			java.sql.PreparedStatement myStat;
			myStat = myCon.prepareStatement("select * from active where Company = ?");
			myStat.setString(1, m);
			myRes = myStat.executeQuery();
			while (myRes.next()){
				l_company.setText(myRes.getString("Company"));
				l_address.setText(myRes.getString("Address"));
				l_number.setText(myRes.getString("Number"));
				l_web.setText(myRes.getString("Web"));
			}
			
		}
	}


	public void back(ActionEvent e) throws IOException {
		
		if(Controller_main.back.equals("Roller")){
			s = new Scene(FXMLLoader.load(getClass().getResource("Roller.fxml")));
		}
		if(Controller_main.back.equals("Water")){
			s = new Scene(FXMLLoader.load(getClass().getResource("Water.fxml")));
		}
		if(Controller_main.back.equals("High")){
			s = new Scene(FXMLLoader.load(getClass().getResource("High.fxml")));
		}
		if(Controller_main.back.equals("Gaming")){
			s = new Scene(FXMLLoader.load(getClass().getResource("Gaming.fxml")));
		}
		//s.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(s);
		app_stage.show();

	}
	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}
	
}
