package tab2mxl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit {
	public String fileName;

	
	public Edit(String fileName){
		this.fileName = fileName.replace(".musicXML",".txt");
	}
	
	public String outputMeasure(int measureNum) {
		StringBuilder measureData = new StringBuilder();
		measureData.append(getOrgTab(measureNum));
		return measureData.toString();
	}
	
	private String getOrgTab(int measureNum) {
		StringBuffer tablature = new StringBuffer();
		StringBuffer output = new StringBuffer();
		ArrayList<String> listOfStrings = new ArrayList<String>();
		String tab = null;
		int lineCount = 1;
		File dir = new File("userTablatures/");
		FilenameFilter filter = new FilenameFilter() { 
			public boolean accept (File dir, String name) { 
				return name.equals(fileName); } 
			}; 
		String[] children = dir.list(filter);
		for (int i = 0; i<children.length ;i++) {
			tab = children[i];
			}
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(dir+"\\"+tab));
			
			String line = reader.readLine();
			
			while (line != null) {
				tablature.append(line+"\n");
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner scan = new Scanner(tablature.toString());
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if ((line.contains("|") && line.contains("-"))) {
				listOfStrings.add(line);
				lineCount += 1;
			}
			else if (line.contains(" ")) {
				lineCount = 0;
			}
		}
		int x = 0;
		int num = 0;
		int mCount = 1; 
		int line = 0;
		StringBuilder measureTab = new StringBuilder();
		StringBuilder outTab = new StringBuilder();
		for (String s: listOfStrings){
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '|') {
					if (i != 1) {
						num++;
					}
				}
			}
			
			if (x == lineCount) {
				x = 0;
				mCount+=num;
			}
			num = 0;
			
			if (mCount == measureNum) {
				outTab.append(s+"\n");
			}
			x++;
		}
		output.append("--------------------MEASURE NUMBER ="+measureNum+"--------------------\n");
		output.append(outTab);
		return output.toString();
	}
	
	public static String returnNewTab(String origTab, String editTab) {
		return null;
	}
	
}
