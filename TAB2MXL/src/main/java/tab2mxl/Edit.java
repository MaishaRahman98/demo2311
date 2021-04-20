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
	
	public int measureCount = 0;
	public ArrayList<String> userOrgTab = new ArrayList<String>();
	public int lineCount = 0;
	public int mCountAdder = 0;
	
	public Edit(String fileName){
		this.fileName = fileName.replace(".musicXML",".txt");

	}
	
	public String outputMeasure(String measureNum) {
		StringBuilder measureData = new StringBuilder();
		ArrayList<Integer> measureNumber = new ArrayList<Integer>();
		String num = "";
		for (int i = 0; i < measureNum.length(); i++) {
			if (Character.isDigit(measureNum.charAt(i))) {
				num+= measureNum.charAt(i);
			}
			else {
				measureNumber.add(Integer.parseInt(num));
				num = "";
			}
			
		}
		
		for (int i = 0; i < measureNumber.size(); i++) {
			measureData.append(getOrgTab(measureNumber.get(i))+"\n");
		}
		return measureData.toString();
	}
	
	private String getOrgTab(int measureNum) {
        StringBuffer tablature = new StringBuffer();
        StringBuffer output = new StringBuffer();
        ArrayList<String> listOfStrings = new ArrayList<String>();
        String tab = null;
        String newTab = null;
        int lineCount = 1;
        int lc = 1;
        File dir = new File("./userTablatures/");
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
            if (tab != null)
                 newTab = tab.replace(".txt","");
            else
                 newTab = "null";
            reader = new BufferedReader(new FileReader(dir+"/"+newTab+".txt"));
			String line = reader.readLine();
			this.userOrgTab.clear();
			while (line != null) {
				tablature.append(line+"\n");
				this.userOrgTab.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
         if(window.textArea.getText().contains("***THIS TABLATURE HAS BEEN EDITED***")) {
        	 this.userOrgTab.clear();
        	 Scanner scan = new Scanner(window.textArea.getText());
        	 while (scan.hasNextLine()) {
        		 String line = scan.nextLine();
        		 if (!line.contains("***THIS TABLATURE HAS BEEN EDITED***")) this.userOrgTab.add(line);
        	 }
         }

		Scanner scan = new Scanner(tablature.toString());
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if ((line.contains("|") && line.contains("-"))) {
				listOfStrings.add(line);
				lc += 1;
				
			}
			else{
				if (lineCount <= lc) lineCount = lc;
				lc = 0;
			}
		}
		int x = 0;
		int num = 0;
		int mCount = 1; 
		int line = 0;
		StringBuilder measureTab = new StringBuilder();
		StringBuilder outTab = new StringBuilder();
		
		for (String s: listOfStrings){
//			System.out.println(s);
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '|' && i+1<s.length() && s.charAt(i+1) == '-') {
					num++;
//					System.out.println(num);	
				}
			}
//			System.out.println(lineCount);
			if (x == lineCount) {
				x = 0;
				if (num == 1) mCount+=num;
				if (num > 1) mCount+=1;
			}
			if (mCount == measureNum) {
				outTab.append(s+"\n");
			}
			if (s!= " ") x++;
			line++;
			
			num = 0;
		}
		this.lineCount = lineCount;
		output.append("************MEASURE NUMBER = "+measureNum+"************\n");
		output.append(outTab);
		return output.toString();
	}
	
	public String returnNewTab(String editTab, int topSigNum, int bottomSigNum) {
		ArrayList<String> edits = new ArrayList<String>();
		Scanner scan = new Scanner(editTab);
		String info = "";
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (line.contains("|") && line.contains("-") || line.contains("MEASURE")) {
				info += line+"\n";
			}
			else {
				if (info!="") edits.add(info);
				info = "";
			}
		}
		scan.close();
		StringBuilder output = new StringBuilder();
		output.append("***THIS TABLATURE HAS BEEN EDITED***\n");
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "";
		ArrayList<String> listOfStrings = new ArrayList<String>();
		for (int i = 0; i < this.userOrgTab.size(); i++) {
			if ((this.userOrgTab.get(i).contains("|") && this.userOrgTab.get(i).contains("-"))) {
				listOfStrings.add(this.userOrgTab.get(i));
				if (listOfStrings.size() == this.lineCount) {
					s1 = listOfStrings.get(0);
					s2 = listOfStrings.get(1);
					s3 = listOfStrings.get(2);
					s4 = listOfStrings.get(3);
					if (this.lineCount == 5) {
						s5 = listOfStrings.get(4);
						s6 = null;
						s7 = null;
						s8 = null;
					}
					else if (this.lineCount == 6) {
						s5 = listOfStrings.get(4);
						s6 = listOfStrings.get(5);
						s7 = null;
						s8 = null;
					}
					else if (this.lineCount == 7) {
						s5 = listOfStrings.get(4);
						s6 = listOfStrings.get(5);
						s7 = listOfStrings.get(6);
						s8 = null;
					}
					else if (this.lineCount == 8) {
						s5 = listOfStrings.get(4);
						s6 = listOfStrings.get(5);
						s7 = listOfStrings.get(6);
						s8 = listOfStrings.get(7);
					}
					else {
						s5 = null;
						s6 = null;
						s7 = null;
						s8 = null;
					}
					output.append(changeTablature(topSigNum,bottomSigNum,edits,s1,s2,s3,s4,s5,s6,s7,s8));
					System.out.println(edits);
					listOfStrings.clear();
				}
			}
			else {
				output.append(this.userOrgTab.get(i)+"\n");
			}
		}
		return output.toString();
	}
	
	private String changeTablature(int topSigNum, int bottomSigNum, ArrayList<String> editTab, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		StringBuilder newTab = new StringBuilder();
		String mNum = "";
		
		ArrayList<ArrayList<Character>> orgTabColumns = new ArrayList<ArrayList<Character>>();
		ArrayList<Integer> measureToEdit = new ArrayList<Integer>();
		
		//**************************************************************
		// Go through original tab input to put them into columns
		int max = s1.length();
		if (s2.length() > max) max = s2.length();
		if (s3.length() > max) max = s3.length();
		if (s4.length() > max) max = s4.length();
		if (s5 != null && s5.length() > max) max = s5.length();
		if (s6 != null && s6.length() > max) max = s6.length();
		if (s7 != null && s7.length() > max) max = s7.length();
		if (s8 != null && s8.length() > max) max = s8.length();
		
		for (int i = 0; i < max; i++) {
			ArrayList<Character> column = new ArrayList<Character>();
			if (i >= s1.length()) column.add(' ');
			else column.add(s1.charAt(i));
			
			if (i >= s2.length()) column.add(' ');
			else column.add(s2.charAt(i));
			
			if (i >= s3.length()) column.add(' ');
			else column.add(s3.charAt(i));
			
			if (i >= s4.length()) column.add(' ');
			else column.add(s4.charAt(i));
			
			if (s5 != null && s6 == null && s7 == null && s8 == null) {
				if (i >= s5.length()) column.add(' ');
				else column.add(s5.charAt(i));
			} else if (s5 != null && s6 != null && s7 == null && s8 == null) {
				if (i >= s5.length()) column.add(' ');
				else column.add(s5.charAt(i));
				
				if (i >= s6.length()) column.add(' ');
				else column.add(s6.charAt(i));
			} else if (s5 != null && s6 != null && s7 != null  && s8 == null) {
				if (i >= s5.length()) column.add(' ');
				else column.add(s5.charAt(i));
				
				if (i >= s6.length()) column.add(' ');
				else column.add(s6.charAt(i));
				
				if (i >= s7.length()) column.add(' ');
				else column.add(s7.charAt(i));
			} else if (s5 != null && s6 != null && s7 != null  && s8 != null) {
				if (i >= s5.length()) column.add(' ');
				else column.add(s5.charAt(i));
				
				if (i >= s6.length()) column.add(' ');
				else column.add(s6.charAt(i));
				
				if (i >= s7.length()) column.add(' ');
				else column.add(s7.charAt(i));
				
				if (i >= s8.length()) column.add(' ');
				else column.add(s8.charAt(i));
		}
			orgTabColumns.add(column);
		}
		//************************************************
		//************************************************
		for (int j = 0; j < editTab.size(); j++) {
			Scanner scan = new Scanner(editTab.get(j));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				int mNumber = 0;
				if (line.contains("MEASURE")) {
					for (int i = 0; i < line.length(); i++) {
						if (Character.isDigit(line.charAt(i))) {
							mNum+=line.charAt(i);
							
						}
					}
	
				}
				else {
					if (mNum!="") {
						mNumber = Integer.parseInt(mNum);
					}
					mNum = "";
					if (mNumber!=0) measureToEdit.add(mNumber);
				}
			}
			
			scan.close();
		}
		//************************************************
		ArrayList<ArrayList<Character>> editColumns = new ArrayList<ArrayList<Character>>();
		if (mCountAdder == 0) editColumns = editTabScan(editTab.get(0));
		else if (mCountAdder < editTab.size()) editColumns = editTabScan(editTab.get(mCountAdder));
		//************************************************
		StringBuilder tab = new StringBuilder(); 
		String line1 = "";
		String line2 = "";
		String line3 = "";
		String line4 = "";
		String line5 = "";
		String line6 = "";
		String line7 = "";
		String line8 = "";

		int lc = 0;
		for (int i = 0; i < orgTabColumns.size(); i++) {
			if (orgTabColumns.get(i).contains('|')) {
				lc++;
				if (lc == 1) {
					this.measureCount++;
				}
				if (lc == orgTabColumns.get(i).size()) {
					lc = 0;
				}
			}
			if (mCountAdder < measureToEdit.size() && this.measureCount == measureToEdit.get(mCountAdder)) {
				if (editColumns.size() <= orgTabColumns.size()) {
					line1 += editColumns.get(i).get(0);
					line2 += editColumns.get(i).get(1);
					line3 += editColumns.get(i).get(2);
					line4 += editColumns.get(i).get(3);	
					if (editColumns.get(i).size() == 5) {
						line5 += editColumns.get(i).get(4);	
					}
					if (editColumns.get(i).size() == 6) {
						line6 += editColumns.get(i).get(5);	
					}
					if (editColumns.get(i).size() == 7) {
						line7 += editColumns.get(i).get(6);	
					}
					if (editColumns.get(i).size() == 8) {
						line8 += editColumns.get(i).get(7);	
					}
					if (editColumns.get(i).contains('|') && i!= 1) {
						tab.append("Time signature for measure *"+measureToEdit.get(mCountAdder)+"* is "+topSigNum+"/"+bottomSigNum+" \n");
						mCountAdder++;
						editColumns.clear();
					}
				}
				else {
					while (i < editColumns.size()) {
						line1 += editColumns.get(i).get(0);
						line2 += editColumns.get(i).get(1);
						line3 += editColumns.get(i).get(2);
						line4 += editColumns.get(i).get(3);	
						if (editColumns.get(i).size() == 5) {
							line5 += editColumns.get(i).get(4);	
						}
						if (editColumns.get(i).size() == 6) {
							line6 += editColumns.get(i).get(5);	
						}
						if (editColumns.get(i).size() == 7) {
							line7 += editColumns.get(i).get(6);	
						}
						if (editColumns.get(i).size() == 8) {
							line8 += editColumns.get(i).get(7);	
						}
						if (editColumns.get(i).contains('|') && i!= 1) {
							mCountAdder++;
							editColumns.clear();
						}
						i++;
					}
				}
			}
			else {
				line1 += orgTabColumns.get(i).get(0);
				line2 += orgTabColumns.get(i).get(1);
				line3 += orgTabColumns.get(i).get(2);
				line4 += orgTabColumns.get(i).get(3);	
				if (orgTabColumns.get(i).size() == 5) {
					line5 += orgTabColumns.get(i).get(4);	
				}
				if (orgTabColumns.get(i).size() == 6) {
					line6 += orgTabColumns.get(i).get(5);	
				}
				if (orgTabColumns.get(i).size() == 7) {
					line7 += orgTabColumns.get(i).get(6);	
				}
				if (orgTabColumns.get(i).size() == 8) {
					line8 += orgTabColumns.get(i).get(7);	
				}
			}
			
		}
		//************************************************
		tab.append(line1 +"\n"+ line2 +"\n"+ line3  +"\n"+ line4 +"\n");
		if (line5 != "") tab.append(line5 + "\n");
		if (line6 != "") tab.append(line6 + "\n");
		if (line7 != "") tab.append(line7 + "\n");
		if (line8 != "") tab.append(line8 + "\n");
		newTab.append(tab);
		return newTab.toString();
	}
	
	private ArrayList<ArrayList<Character>> editTabScan(String editTab) {
		String editL1 = "", editL2 = "", editL3 = "", editL4 = "", editL5 = "", editL6 = "", editL7 = "", editL8 = "";
		ArrayList<String> editStringList = new ArrayList<String>();
		ArrayList<ArrayList<Character>> editColumns = new ArrayList<ArrayList<Character>>();
		Scanner scan = new Scanner(editTab);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (!line.contains("MEASURE")) {
				editStringList.add(line);
			}
		}
		
		scan.close();
		
		editL1 = editStringList.get(0);
		editL2 = editStringList.get(1);
		editL3 = editStringList.get(2);
		editL4 = editStringList.get(3);
		if (editStringList.size() == 5) {
			editL5 = editStringList.get(4); 
		}
		if (editStringList.size() == 6) {
			editL5 = editStringList.get(4); 
			editL6 = editStringList.get(5);
		}
		
		if (editStringList.size() == 7) {
			editL5 = editStringList.get(4); 
			editL6 = editStringList.get(5);
			editL7 = editStringList.get(6);
		}
		
		if (editStringList.size() == 8) {
			editL5 = editStringList.get(4); 
			editL6 = editStringList.get(5);
			editL7 = editStringList.get(6);
			editL8 = editStringList.get(7);
		}
		
		int maxOnEdit = editL1.length();
		if (editL2.length() > maxOnEdit) maxOnEdit = editL2.length();
		if (editL3.length() > maxOnEdit) maxOnEdit = editL3.length();
		if (editL4.length() > maxOnEdit) maxOnEdit = editL4.length();
		if (editL5 != null && editL5.length() > maxOnEdit) maxOnEdit = editL5.length();
		if (editL6 != null && editL6.length() > maxOnEdit) maxOnEdit = editL6.length();
		if (editL7 != null && editL7.length() > maxOnEdit) maxOnEdit = editL7.length();
		if (editL8 != null && editL8.length() > maxOnEdit) maxOnEdit = editL8.length();
		// Go through edit tab input to put them into columns
		for (int j = 0; j < maxOnEdit; j++) {
			ArrayList<Character> column = new ArrayList<Character>();
			if (j >= editL1.length()) column.add(' ');
			else column.add(editL1.charAt(j));

			if (j >= editL2.length()) column.add(' ');
			else column.add(editL2.charAt(j));
			
			if (j >= editL3.length()) column.add(' ');
			else column.add(editL3.charAt(j));

			if (j >= editL4.length()) column.add(' ');
			else column.add(editL4.charAt(j));

			if (editL5 != "" && editL6 == "" && editL7 == "" && editL8 == "") {
				if (j >= editL5.length()) column.add(' ');
				else column.add(editL5.charAt(j));
			} else if (editL5 != "" && editL6 != "" && editL7 == "" && editL8 == "") {
				if (j >= editL5.length()) column.add(' ');
				else column.add(editL5.charAt(j));
				
				if (j >= editL6.length()) column.add(' ');
				else column.add(editL6.charAt(j));
			} else if (editL5 != "" && editL6 != "" && editL7 != "" && editL8 == "") {
				if (j >= editL5.length()) column.add(' ');
				else column.add(editL5.charAt(j));
				
				if (j >= editL6.length()) column.add(' ');
				else column.add(editL6.charAt(j));
				
				if (j >= editL7.length()) column.add(' ');
				else column.add(editL7.charAt(j));
			} else if (editL5 != "" && editL6 != "" && editL7 != "" && editL8 != "") {
				if (j >= editL5.length()) column.add(' ');
				else column.add(editL5.charAt(j));
				
				if (j >= editL6.length()) column.add(' ');
				else column.add(editL6.charAt(j));
				
				if (j >= editL7.length()) column.add(' ');
				else column.add(editL7.charAt(j));
				
				if (j >= editL8.length()) column.add(' ');
				else column.add(editL8.charAt(j));
				
		}
			editColumns.add(column);
		}
		return editColumns;
		
	}
	public void resetGlobal() {
//		this.startLine = 0;
//		this.endLine = 0;
	}
	
}