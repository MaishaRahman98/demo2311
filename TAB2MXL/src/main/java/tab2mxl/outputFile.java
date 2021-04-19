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

	public String createFile(String text, int num1, int num2, String songName, String composerName) {
		StringBuilder metaData = new StringBuilder();
		metaData.append("<work-title>"+songName+"</work-title>\n");
		metaData.append("<creator type=\"composer\">"+composerName+"</creator>\n");
		xml += metaData.toString();
		xml += ts.detect(text,num1,num2);
		try {
			File myObj = new File("newfile.txt");
			FileWriter myWriter = new FileWriter("newfile.txt",false);
			myWriter.write(xml);
			myWriter.close();
			ts.resetGlobal();
			return myObj.getName();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
		
	}
}
