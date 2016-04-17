package ua.tlz.freeMove.scene.booking;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	@FXML Button b_close;
	@FXML
	Button reset;
	@FXML
	Button search;
	@FXML
	Label date;
	@FXML
	Label city_out;
	@FXML
	Label city_in;
	@FXML
	Label time_out;
	@FXML
	Label time_in;
	@FXML
	Label seats;
	@FXML
	private ListView<String> listView;
	@FXML
	private ComboBox<String>city_out_search1;
	@FXML
	private ComboBox<String>city_in_search1;
	@FXML
	private DatePicker date_search1;
	static String city_out1 = "";
	static String city_in1 = "";
	ObservableList<String>city_out2;
	ObservableList<String>city_in2;
	ObservableList<String>date2;
	static String s11 = "";
	static String s22 = "";
	static String s33 = "";
	ObservableList<String> movies;
	public static String CO;
	public static String CI;
	public static String D;
	public static String TO;
	public static String TI;
	public static String NUMBER;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Image imageDecline_close = new Image(getClass().getResourceAsStream("../img/Close.png"));
			b_close.setGraphic(new ImageView(imageDecline_close));
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "root", "root");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from train");
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			
			while (myRs.next()) {
				listView.getItems().addAll(myRs.getString("city_out")+" "+"-"+" "+ myRs.getString("city_in"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		city_out2= FXCollections.observableArrayList(
				"Œ‰ÂÒ‡"," Ëø‚","À¸‚≥‚");
		city_in2 = FXCollections.observableArrayList(
				"Œ‰ÂÒ‡"," Ëø‚","À¸‚≥‚","’‡Í≥‚","¡Ó„‡ÚÓÂ");
		date2 = FXCollections.observableArrayList(
				"2016-03-27","2016-03-26","2016-03-25","2016-03-28","2016-03-29");
		city_out_search1.setItems(city_out2);
		city_in_search1.setItems(city_in2);
	}
	
	public void search() throws SQLException{
		
		search.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {

				try {
					String s3 = "1";
					s11 = city_out_search1.getEditor().getText();
					s22 = city_in_search1.getEditor().getText();
					s33 = date_search1.getEditor().getText();
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "root", "root");
					ResultSet myRs = null;
					String s1 = city_out_search1.getValue();
					String s2 = city_in_search1.getValue();
					try{
						s3 = date_search1.getValue().toString();
					}catch(Exception e){}
					
					java.sql.PreparedStatement myStmt;
					
					
					if(city_out2.contains(s1) || city_out2.contains(s11)){
						myStmt = myConn.prepareStatement("select * from train where city_out =? and train=?");
						s1 = s11;
						String t = "1";
						myStmt.setString(1, s1);
						myStmt.setString(2, t);
						
						myRs = myStmt.executeQuery();
						listView.getItems().clear();
						while (myRs.next()) {
							listView.getItems()
									.addAll(myRs.getString("city_out") + " " + "-" + " " + myRs.getString("city_in"));
						}
					}
					
					if(city_in2.contains(s2) || city_in2.contains(s22)){
						myStmt = myConn.prepareStatement("select * from train where city_in=? and train=?");
						s2 = s22;
						String t = "1";
						myStmt.setString(1, s2);
						myStmt.setString(2, t);
						
						myRs = myStmt.executeQuery();
						listView.getItems().clear();
						while (myRs.next()) {
							listView.getItems()
									.addAll(myRs.getString("city_out") + " " + "-" + " " + myRs.getString("city_in"));
						}
					}
					
					if(date2.contains(s3) || date2.contains(s33)){
						myStmt = myConn.prepareStatement("select * from train where date=? and train=?");
						s3 = s33;
						String t = "1";
						myStmt.setString(1, s3);
						myStmt.setString(2, t);
						
						myRs = myStmt.executeQuery();
						listView.getItems().clear();
						while (myRs.next()) {
							listView.getItems()
									.addAll(myRs.getString("city_out") + " " + "-" + " " + myRs.getString("city_in"));
						}
					}
					
					if((date2.contains(s3) || date2.contains(s33)) && (city_out2.contains(s1) || city_out2.contains(s11))){
						myStmt = myConn.prepareStatement("select * from train where date=? and city_out=? and train=?");
						s1 = s11;
						s3 = s33;
						String t = "1";
						myStmt.setString(1, s3);
						myStmt.setString(2, s1);
						myStmt.setString(3, t);
						
						myRs = myStmt.executeQuery();
						listView.getItems().clear();
						while (myRs.next()) {
							listView.getItems()
									.addAll(myRs.getString("city_out") + " " + "-" + " " + myRs.getString("city_in"));
						}
					}
					
					if((date2.contains(s3) || date2.contains(s33))&& (city_in2.contains(s2) || city_in2.contains(s22))){
						myStmt = myConn.prepareStatement("select * from train where date=? and city_in=? and train=?");
						s2 = s22;
						s3 = s33;
						String t = "1";
						myStmt.setString(1, s3);
						myStmt.setString(2, s2);
						myStmt.setString(3, t);
						
						myRs = myStmt.executeQuery();
						listView.getItems().clear();
						while (myRs.next()) {
							listView.getItems()
									.addAll(myRs.getString("city_out") + " " + "-" + " " + myRs.getString("city_in"));
						}
					}
					
					if((city_in2.contains(s2) || city_in2.contains(s22)) && (city_out2.contains(s1) || city_out2.contains(s11))){
						myStmt = myConn.prepareStatement("select * from train where city_in=? and city_out=? and train=?");
						s2 = s22;
						s1 = s11;
						String t = "1";
						myStmt.setString(1, s2);
						myStmt.setString(2, s1);
						myStmt.setString(3, t);
						
						myRs = myStmt.executeQuery();
						listView.getItems().clear();
						while (myRs.next()) {
							listView.getItems()
									.addAll(myRs.getString("city_out") + " " + "-" + " " + myRs.getString("city_in"));
						}
					}
					
					if((date2.contains(s3) || (date2.contains(s33)) && (city_out2.contains(s1) || city_out2.contains(s11)) && (city_in2.contains(s2) || city_in2.contains(s22)))){
						myStmt = myConn.prepareStatement("select * from train where date=? and city_out=? and city_in=? and train=?");
						s1 = s11;
						s2 = s22;
						s3 = s33;
						String t = "1";
						myStmt.setString(1, s3);
						myStmt.setString(2, s1);
						myStmt.setString(3, s2);
						myStmt.setString(4, t);
						
						myRs = myStmt.executeQuery();
						listView.getItems().clear();
						while (myRs.next()) {
							listView.getItems()
									.addAll(myRs.getString("city_out") + " " + "-" + " " + myRs.getString("city_in"));
						}
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		});
	}
	
	public void reset(){
		
		reset.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				
				city_out_search1.setValue(null);
				city_in_search1.setValue(null);
				date_search1.setValue(null);
				listView.getItems().clear();
				city_out_search1.getEditor().setText(null);
				city_in_search1.getEditor().setText(null);
				date_search1.getEditor().setText(null);
				
				try {
					
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "root", "root");
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("select * from train");
					listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
					
					while (myRs.next()) {
						listView.getItems().addAll(myRs.getString("city_out")+" "+"-"+" "+ myRs.getString("city_in"));
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
		});
	}

	public void work() throws SQLException {

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "root", "root");
		ResultSet myRs = null;
		movies = listView.getSelectionModel().getSelectedItems();
	
		for (String m : movies) {
			
			city_out1 = m.substring(0 , m.indexOf("-")-1);
			city_in1 = m.substring(m.indexOf("-")+2);

			java.sql.PreparedStatement myStmt;
			
			myStmt = myConn.prepareStatement("select * from train where city_out =? and city_in=?");	
			myStmt.setString(1, city_out1);
			myStmt.setString(2, city_in1);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				
				date.setText(myRs.getString("date"));
				city_out.setText(myRs.getString("city_out"));
				city_in.setText(myRs.getString("city_in"));
				time_out.setText(myRs.getString("time_out"));
				time_in.setText(myRs.getString("time_in"));
				seats.setText(myRs.getString("seats"));
				
				CO = myRs.getString("city_out");
				CI = myRs.getString("city_in");
				D = myRs.getString("date");
				TO = myRs.getString("time_out");
				TI = myRs.getString("time_in");
				NUMBER = myRs.getString("π");
				
				city_in1 = "";
				city_out1 = "";
			}
		}		
	}
	
	@FXML
	private void close(ActionEvent event_close){
		System.exit(0);
	}
	
	@FXML
	private void back(ActionEvent event_back) throws IOException{
		Scene menu1_ua_scene = new Scene(FXMLLoader.load(getClass().getResource("../Menu5.fxml")));
		menu1_ua_scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
		Stage menu1_ua_stage = (Stage) ((Node) event_back.getSource()).getScene().getWindow();
		menu1_ua_stage.setScene(menu1_ua_scene);
		menu1_ua_stage.show();
	}
	
	public void booking(ActionEvent event) throws IOException {
		Scene booking = new Scene(FXMLLoader.load(getClass().getResource("booking.fxml")));
		booking.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(booking);
		app_stage.show();
	}
}