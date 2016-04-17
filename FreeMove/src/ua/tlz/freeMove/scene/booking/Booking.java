package ua.tlz.freeMove.scene.booking;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Booking implements Initializable{

	
	int s = 0;
	@FXML Pane p1;
	@FXML Pane p2;
	@FXML Pane p3;
	@FXML ComboBox<String> vag_vubor;
	@FXML ObservableList<String>vagonu;
	@FXML ObservableList<String>city_out;
	@FXML ObservableList<String>city_in;
	@FXML CheckBox c1;
	@FXML CheckBox c2;
	@FXML CheckBox c3;
	@FXML CheckBox c4;
	@FXML CheckBox c5;
	@FXML CheckBox c6;
	@FXML CheckBox c7;
	@FXML CheckBox c8;
	@FXML CheckBox c9;
	@FXML CheckBox c10;
	@FXML CheckBox c11;
	@FXML CheckBox c12;
	@FXML Label vag_number;
	@FXML Label how_many;
	@FXML Label how_much;
	@FXML Button b_close;
	String vagon_number;
	static String v;
	static String N;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Image imageDecline_close = new Image(getClass().getResourceAsStream("../img/Close.png"));
		b_close.setGraphic(new ImageView(imageDecline_close));
		vagonu = FXCollections.observableArrayList(
				"Вагон 1","Вагон 2","Вагон 3");
		city_out= FXCollections.observableArrayList(
				"Одеса","Київ","Львів");
		city_in = FXCollections.observableArrayList(
				"Одеса","Київ","Львів","Харків","Богатое");
		vag_vubor.setItems(vagonu);
		
		Connection myConn;
		
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "root", "root");
			
			if(vagonu.contains(v)){	
				java.sql.PreparedStatement myStmt;
				myStmt = myConn.prepareStatement("select * from seats where vagon = ? and city_out=? and city_in=? and date=?");
				myStmt.setString(1, N);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.D);
				ResultSet myRs = myStmt.executeQuery();
				
				while (myRs.next()) {
					if(myRs.getString("mesto").equals("1")){
						c1.setDisable(true);
					}
					if(myRs.getString("mesto").equals("2")){
						c2.setDisable(true);
					}
					if(myRs.getString("mesto").equals("3")){
						c3.setDisable(true);
					}
					if(myRs.getString("mesto").equals("4")){
						c4.setDisable(true);
					}
					if(myRs.getString("mesto").equals("5")){
						c5.setDisable(true);
					}
					if(myRs.getString("mesto").equals("6")){
						c6.setDisable(true);
					}
					if(myRs.getString("mesto").equals("7")){
						c7.setDisable(true);
					}
					if(myRs.getString("mesto").equals("8")){
						c8.setDisable(true);
					}
					if(myRs.getString("mesto").equals("9")){
						c9.setDisable(true);
					}
					if(myRs.getString("mesto").equals("10")){
						c10.setDisable(true);
					}
					if(myRs.getString("mesto").equals("11")){
						c11.setDisable(true);
					}
					if(myRs.getString("mesto").equals("12")){
						c12.setDisable(true);
					}
				}		
			}
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void vagonu (ActionEvent e) throws IOException{
		v = vag_vubor.getEditor().getText();
		N = v.substring(v.indexOf("н")+2);
		vag_number.setText(v);
		if("Вагон 1".equals(v)){
			Scene booking = new Scene(FXMLLoader.load(getClass().getResource("booking.fxml")));
			booking.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage.setScene(booking);
			app_stage.show();
		}
		if("Вагон 2".equals(v)){
			Scene booking = new Scene(FXMLLoader.load(getClass().getResource("vagon2.fxml")));
			booking.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage.setScene(booking);
			app_stage.show();
		}
		if("Вагон 3".equals(v)){
			Scene booking = new Scene(FXMLLoader.load(getClass().getResource("vagon3.fxml")));
			booking.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage.setScene(booking);
			app_stage.show();
			
		}
	}
	
	
	public void reset(ActionEvent e){
		c1.setSelected(false);
		c2.setSelected(false);
		c3.setSelected(false);
		c4.setSelected(false);
		c5.setSelected(false);
		c6.setSelected(false);
		c7.setSelected(false);
		c8.setSelected(false);
		c9.setSelected(false);
		c10.setSelected(false);
		c11.setSelected(false);
		c12.setSelected(false);
	}
	
	public void poschotat (ActionEvent e) throws SQLException{
		java.sql.PreparedStatement myStmt;
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "root", "root");
		if (vagonu.contains(v)) {
			if (c1.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "1");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c1.setDisable(true);
			}
			if (c2.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "2");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c2.setDisable(true);
			}
			if (c3.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "3");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c3.setDisable(true);
			}
			if (c4.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "4");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c4.setDisable(true);
			}
			if (c5.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "5");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c5.setDisable(true);
			}
			if (c6.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "6");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c6.setDisable(true);
			}
			if (c7.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "7");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c7.setDisable(true);
			}
			if (c8.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "8");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c8.setDisable(true);
			}
			if (c9.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "9");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c9.setDisable(true);
			}
			if (c10.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "10");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c10.setDisable(true);
			}
			if (c11.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "11");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c11.setDisable(true);
			}
			if (c12.isSelected() == true) {
				myStmt = myConn.prepareStatement("insert into seats (date,city_out,city_in,time_out,time_in,vagon, mesto, №) values (?,?,?,?,?,?,?,?)");
				myStmt.setString(1, Controller.D);
				myStmt.setString(2, Controller.CO);
				myStmt.setString(3, Controller.CI);
				myStmt.setString(4, Controller.TO);
				myStmt.setString(5, Controller.TI);
				myStmt.setString(6, N);
				myStmt.setString(7, "12");
				myStmt.setString(8, Controller.NUMBER);
				myStmt.executeUpdate();
				c12.setDisable(true);
			}
		}
		reset(null);
	}
	
	public void proverka(){
		if(c1.isSelected()==true){
			s++;
		}
		if(c2.isSelected()==true){
			s++;
		}
		if(c3.isSelected()==true){
			s++;
		}
		if(c4.isSelected()==true){
			s++;
		}
		if(c5.isSelected()==true){
			s++;
		}
		if(c6.isSelected()==true){
			s++;
		}
		if(c7.isSelected()==true){
			s++;
		}
		if(c8.isSelected()==true){
			s++;
		}
		if(c9.isSelected()==true){
			s++;
		}
		if(c10.isSelected()==true){
			s++;
		}
		if(c11.isSelected()==true){
			s++;
		}
		if(c12.isSelected()==true){
			s++;
		}
		how_many.setText(Integer.toString(s)+" місць обранно.");
		how_much.setText(Integer.toString(s * 50)+"грн.");
		s = 0;
	}
	
	@FXML
	private void close(ActionEvent event_close){
		System.exit(0);
	}
	
	@FXML
	private void back(ActionEvent event_back) throws IOException{
		Scene menu1_ua_scene = new Scene(FXMLLoader.load(getClass().getResource("main_booking.fxml")));
		menu1_ua_scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
		Stage menu1_ua_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
		menu1_ua_stage.setScene(menu1_ua_scene);
		menu1_ua_stage.show();
	}
}