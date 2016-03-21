package ua.tlz.freeMove.regedit;

public class AddReg {

	public void run(String addres, String name, String value) {

		String s = "cmd /C " + "reg add " + addres + " /v " + name + " /t REG_SZ /d " + "\"" + value + "\"";
		try {
			Runtime.getRuntime().exec(s);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
