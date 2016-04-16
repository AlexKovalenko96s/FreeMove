package ua.tlz.freeMove.scene.must_see_ADMIN;

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
	TextField textID;
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
	ImageView imv_pic;
	@FXML
	ImageView imv_map;
	String s_pic;
	String s_map;
	static String t;

	public void browse_PIC(ActionEvent e) {
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
			s_pic = path;
			System.out.println(ss);
			imv_pic.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("res/" + ss)));

		} else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("No Data");
		}
	}
	
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
				.prepareStatement("insert into must_see(name,address,number,web,rating,pic,map,type) values (?,?,?,?,?,?,?,?)");
		InputStream is_pic = new FileInputStream(new File(s_pic));
		InputStream is_map = new FileInputStream(new File(s_map));
		myStmt.setString(1, textNAME.getText());
		myStmt.setString(2, textADDRESS.getText());
		myStmt.setString(3, textNUMBER.getText());
		myStmt.setString(4, textWEB.getText());
		myStmt.setString(5, intRATING.getText());
		myStmt.setBlob(6, is_pic);
		myStmt.setBlob(7, is_map);
		myStmt.setString(8, combobox_type.getEditor().getText());
		myStmt.executeUpdate();
		System.out.println("Complet!");
	}

	public void see(ActionEvent e) throws SQLException, IOException {

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		String n = textNAME.getText();
		java.sql.PreparedStatement ps = myConn.prepareStatement("select * from must_see where name=?");
		ps.setString(1, n);
		ResultSet myRs = ps.executeQuery();

		Blob img_pic;
		Blob img_map;
		byte[] imgData_pic = null;
		byte[] imgData_map = null;
		
		while (myRs.next()) {
			textNAME.setText(myRs.getString("name"));
			textADDRESS.setText(myRs.getString("address"));
			textNUMBER.setText(myRs.getString("number"));
			textWEB.setText(myRs.getString("web"));
			img_pic = myRs.getBlob("pic");
			img_map = myRs.getBlob("map");
			imgData_pic = img_pic.getBytes(1, (int) img_pic.length());
			imgData_map = img_map.getBytes(1, (int) img_map.length());
			
			//String dirName="C:\\Users\\KLUBnyaKprO\\Desktop";
			
			BufferedImage imag_pic =ImageIO.read(new ByteArrayInputStream(imgData_pic));
			BufferedImage imag_map =ImageIO.read(new ByteArrayInputStream(imgData_map));
			imv_pic.setImage(SwingFXUtils.toFXImage(imag_pic, null));
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
	
	public void pic(ActionEvent e) throws IOException{
		
		Scene pic_scene = new Scene(FXMLLoader.load(getClass().getResource("PIC.fxml")));
		//pic_scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(pic_scene);
		app_stage.show();
	
	}	
	
	public void back(ActionEvent e) throws IOException{
		Scene Menu1_scene = new Scene(FXMLLoader.load(getClass().getResource("../Menu1.fxml")));
		Menu1_scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
		Stage Menu1_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Menu1_stage.setScene(Menu1_scene);
		Menu1_stage.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try{
			if("must_see".contains(Controller_subroutine.type_list)){
				combobox_type.getEditor().setText("must_see");
			}
		}catch(Exception ex){}
		try{
			if("colorful".contains(Controller_subroutine.type_list)){
				combobox_type.getEditor().setText("colorful");
			}
		}catch(Exception ex){}
		try{
			if("themed".contains(Controller_subroutine.type_list)){
				combobox_type.getEditor().setText("themed");
			}
		}catch(Exception ex){}
		type = FXCollections.observableArrayList(
				"must_see","colorful","themed");
		combobox_type.setItems(type);
	}
}
