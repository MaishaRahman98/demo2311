package tab2mxl;

import java.awt.Window;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class outputFile {
	window win;
	String xml = "";
	TablatureScanner ts = new TablatureScanner(xml);

	public outputFile(window win) {
		this.win = win;

	}

	public String createFile(String text) {
		xml = ts.detect(text);
		try {
			File myObj = new File("newfile.txt");
			FileWriter myWriter = new FileWriter("newfile.txt");
			myWriter.write(xml);
			myWriter.close();
			ts.resetGlobal();
			System.out.println("file made");
			return myObj.getName();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
		
	}
}
