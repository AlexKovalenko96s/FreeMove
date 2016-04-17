package ua.tlz.freeMove.scene.User_experience;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.tlz.freeMove.scene.Controller_login;

public class User_experience {
	
	public static boolean ua = false;
	public static boolean eng = false;
	public static boolean no_language = true;
	public static boolean Odesa = false;
	public static boolean Kyiv = false;
	public static boolean Lviv = false;
	public static boolean no_city = true;
	
	public static void check() throws SQLException{
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		
		try{
			java.sql.PreparedStatement myRs_city = myConn.prepareStatement("select city from users where user_name=?");
			myRs_city.setString(1, Controller_login.login );
			
			ResultSet myRs_myRs_city = myRs_city.executeQuery();
			
			while (myRs_myRs_city.next()) {
				if(myRs_myRs_city.getString("city").equals("odesa")){
					Odesa = true;
					no_city = false;
				}
				if(myRs_myRs_city.getString("city").equals("kyiv")){
					Kyiv = true;
					no_city = false;
				}
				if(myRs_myRs_city.getString("city").equals("lviv")){
					Lviv = true;
					no_city = false;
				}
				if(myRs_myRs_city.getString("city").equals("no")){
					no_city = true;
				}
			}
		}catch(Exception ex){}
	
		try{
			java.sql.PreparedStatement myRs_language = myConn.prepareStatement("select language from users where user_name=?");
			myRs_language.setString(1, Controller_login.login );
			
			ResultSet myRs_myRs_language = myRs_language.executeQuery();
			
			while (myRs_myRs_language.next()) {
				if(myRs_myRs_language.getString("language").equals("ua")){
					ua = true;
					no_language = false;
				}
				if(myRs_myRs_language.getString("language").equals("eng")){
					eng = true;
					no_language = false;
				}
				if(myRs_myRs_language.getString("language").equals("no")){
					no_language = true;
				}
			}
		}catch(Exception ex){}	
	}
}
