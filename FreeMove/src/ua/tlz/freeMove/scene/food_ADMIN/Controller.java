package ua.tlz.freeMove.scene.food_ADMIN;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ua.tlz.freeMove.scene.Controller_subroutine;

public class Controller implements Initializable{

	@FXML
	ComboBox<String> combobox_type;
	@FXML 
	ObservableList<String>type;
	@FXML
	TextField textNAME;
	@FXML
	TextField textADDRESS;
	@FXML
	TextField textNUMBER;
	@FXML
	TextField textWEB;
	@FXML
	TextField intRATING;
	@FXML
	TextField intRATINGK;
	@FXML
	ImageView imv_map;
	String s_map;
	static String t;
	
	public void browse_MAP(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
		fileChooser.addChoosableFileFilter(filter);
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			System.out.println(path);
			String ss = path.substring(path.indexOf("&"));
			s_map = path;
			imv_map.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("res/" + ss)));

		} else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("No Data");
		}
	}

	public void add(ActionEvent e) throws SQLException, FileNotFoundException {
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		java.sql.PreparedStatement myStmt = myConn
				.prepareStatement("insert into food(name,address,number,web,rating,map,type,likes_user) values (?,?,?,?,?,?,?,?)");
		InputStream is_map = new FileInputStream(new File(s_map));
		myStmt.setString(1, textNAME.getText());
		myStmt.setString(2, textADDRESS.getText());
		myStmt.setString(3, textNUMBER.getText());
		myStmt.setString(4, textWEB.getText());
		myStmt.setString(5, intRATING.getText());
		myStmt.setBlob(6, is_map);
		myStmt.setString(7, combobox_type.getEditor().getText());
		myStmt.setString(8, "& ");
		myStmt.executeUpdate();
		System.out.println("Complet!");
	}

	public void see(ActionEvent e) throws SQLException, IOException {

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		String n = textNAME.getText();
		java.sql.PreparedStatement ps = myConn.prepareStatement("select * from must_see where name=?");
		ps.setString(1, n);
		ResultSet myRs = ps.executeQuery();

		Blob img_map;
		byte[] imgData_map = null;
		
		while (myRs.next()) {
			textNAME.setText(myRs.getString("name"));
			textADDRESS.setText(myRs.getString("address"));
			textNUMBER.setText(myRs.getString("number"));
			textWEB.setText(myRs.getString("web"));
			try{
				img_map = myRs.getBlob("map");
				imgData_map = img_map.getBytes(1, (int) img_map.length());
			}catch(Exception ex){}
				
			//String dirName="C:\\Users\\KLUBnyaKprO\\Desktop";
			
			BufferedImage imag_map =ImageIO.read(new ByteArrayInputStream(imgData_map));
			imv_map.setImage(SwingFXUtils.toFXImage(imag_map, null));
			/*
			 * извлекалка на рабочий стол
			 */	
			//ImageIO.write(imag, "jpg", new File(dirName,"&"+myRs.getString("name")+".jpg"));	
			/* 
			 */
			
			System.out.println("complet");
		}
	}
	
	public void back(ActionEvent e) throws IOException{
		Scene Menu1_scene = new Scene(FXMLLoader.load(getClass().getResource("../Menu2.fxml")));
		Menu1_scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
		Stage Menu1_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Menu1_stage.setScene(Menu1_scene);
		Menu1_stage.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try{
			if("fast_food".contains(Controller_subroutine.type_list)){
				combobox_type.getEditor().setText("fast_food");
			}
		}catch(Exception ex){}
		try{
			if("cafe".contains(Controller_subroutine.type_list)){
				combobox_type.getEditor().setText("cafe");
			}
		}catch(Exception ex){}
		try{
			if("restaurants".contains(Controller_subroutine.type_list)){
				combobox_type.getEditor().setText("restaurants");
			}
		}catch(Exception ex){}
		try{
			if("bars".contains(Controller_subroutine.type_list)){
				combobox_type.getEditor().setText("bars");
			}
		}catch(Exception ex){}
		type = FXCollections.observableArrayList(
				"fast_food","cafe","restaurants","bars");
		combobox_type.setItems(type);
	}
}
