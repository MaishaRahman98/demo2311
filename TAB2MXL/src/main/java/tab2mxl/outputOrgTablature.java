package tab2mxl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class outputOrgTablature {
	public String fileName;

	
	public outputOrgTablature(String fileName){
		this.fileName = fileName.replace(".musicXML",".txt");
	}
	
	public String outputMeasure(int measureNum) {
		StringBuilder measureData = new StringBuilder();
		measureData.append(getOrgTab());
		return measureData.toString();
	}
	
	private String getOrgTab() {
		StringBuffer output = new StringBuffer();
		String tab = null;
		File dir = new File("C:\\Users\\redga\\git\\demo2311\\TAB2MXL\\usersTablatures\\");
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
				output.append(line+"\n");
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

}
