package tab2mxl;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

public class Functioncallfile {

	window win;
	String filename;
	String fileaddress;
	public Functioncallfile(window win) {
		this.win = win;
		
	}
	public void newfile() {
		win.textArea.setText("");
		win.frame.setTitle("New");
	}
	public void open() {
		FileDialog fileopen = new FileDialog(win.frame, "Open a txt file", FileDialog.LOAD);
		fileopen.setVisible(true);
		
		if(fileopen.getFile()!=null) {
			filename = fileopen.getFile();
			fileaddress = fileopen.getDirectory();
			win.frame.setTitle(filename);
		}
		try {
			BufferedReader firstbf = new BufferedReader(new FileReader(fileaddress + filename));
			win.textArea.setText("");
			String newtext = null;
			while ((newtext = firstbf.readLine())!=null) {
				win.textArea.append(newtext+"\n");
			}
			firstbf.close();
		}catch(Exception e) {
			System.out.println("File isn't open correctly");
		}
	}

}
