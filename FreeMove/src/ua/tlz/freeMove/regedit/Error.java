package ua.tlz.freeMove.regedit;

import com.sun.deploy.association.utility.WinRegistryWrapper;

public class Error {
	
	public static Boolean odessa=false;
	public static Boolean ua=false;
	public static Boolean eng=false;
	public static Boolean start=false;
	String proverka;
	
	public void proverkaM(){
		String[] keys= WinRegistryWrapper.WinRegGetValues(WinRegistryWrapper.HKEY_CURRENT_USER,"Software\\FreeMove",100);
        for(int i=0; i < keys.length; i++){
        	proverka=keys[i]; 
        	 if(proverka.equals("START")){
             	start=true;
             }
            if(proverka.equals("odessa")){
            	odessa=true;
            }
            if(proverka.equals("uaa")){
            	ua=true;
            }
            if(proverka.equals("engl")){
            	eng=true;
            }
        }
	}
}
