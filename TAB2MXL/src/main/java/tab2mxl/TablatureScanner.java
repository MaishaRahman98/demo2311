package tab2mxl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TablatureScanner extends StringInstrument {
	String text;
	window win;
	static String header;
	public static int n = 1;
	int co = 0;
 
	public TablatureScanner(String text) {
		this.text = text;
		this.win = win;
		this.header = header;

	}
	public String detect(String text, int num1, int num2){
		int count = 0;
		String output = "";
		String o = "";
		Scanner myReader = new Scanner(text);
		while (myReader.hasNextLine()) {
			String s = myReader.nextLine();
			if (s.charAt(0) == ' ') {
				if (count < 4) {
					count = 0;
				}
				else {
					break;
				}
			} 
			else if (s.contains("|") && s.contains("-")) {
				count += 1;
			}
			else if (!s.contains("|") && !s.contains("-") && s.contains(" ")) {
				count = 0;
			}
			else if (s.contains("BEAT TYPE")) {
				//
			}
		}
		if (count == 4 || count == 5) {
			output = TablatureScanner.callBassClass(text,count,num1,num2);
			//header = TablatureScanner.xmlHeader(count);
			}
		if (count == 6 || count == 7) {
			output = TablatureScanner.callGuitarClass(text,count,num1,num2);
			
		}
		else if (count < 4 || count > 7 && count!= 0) {
            Showtheerror.outputMessage("wrong Instrument");
        }
		else if (count == 0) {
			Showtheerror.outputMessage("Bad input");
		}
//		else {
//			errorMessage.outputMessage("input error");
//		}

		myReader.close();
		return output;
	}

//	public static String xmlHeader(int c) {
//		String h = "";
//		StringBuilder head = new StringBuilder();
//		if (c == 4 || c == 5) {
//			head.append("Bass Guitar");
//		}else {
//			head.append("Guitar");
//		}
//		
//        return head.toString();
//	}
	
	public static String callBassClass(String text,int count, int num1, int num2){
		Scanner myReader = new Scanner(text);
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
		StringBuilder out = new StringBuilder();
		Bass bass;
		ArrayList<String> listOfStrings = new ArrayList<String>();
		int counter = 0;
		out.append(xmlHeader(num1, num2, count));
		ArrayList<Integer> measureForChange = new ArrayList<Integer>();
		ArrayList<Integer> timeSigTops = new ArrayList<Integer>();
		ArrayList<Integer> timeSigBottoms = new ArrayList<Integer>();
//		while (myReader.hasNextLine()) {
//			  counter++;
//			  myReader.nextLine();
//			}
		while (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			String tmp = "";
			String tmp1 = "";
			String tmp2 = "";
			int x = 1;
			if (line.contains("Time signature for measure")) {
				for(int i = 0; i < line.length();i++) {
					if (line.charAt(i) == '*' && Character.isDigit(line.charAt(i+1))) {
						while(line.charAt(i+1)!='*') {
							tmp+=line.charAt(i+1);
							i++;
						}
					}
					if (line.charAt(i) == '/') {
						while(line.charAt(i-x) != ' ' && line.charAt(i) =='/') {
							tmp1 = line.charAt(i-x) + tmp1;
							x++;
						}

						while(line.charAt(i+1) != ' ') {
							tmp2+= line.charAt(i+1);
//							System.out.println(tmp2);
							i++;
						}
	
					}
				}
				measureForChange.add(Integer.parseInt(tmp));
				timeSigTops.add(Integer.parseInt(tmp1));
				timeSigBottoms.add(Integer.parseInt(tmp2));
//				System.out.println(measureForChange);
//				System.out.println(timeSigTops);
//				System.out.println(timeSigBottoms);
				x = 0;
				tmp="";
				tmp1="";
				tmp2="";
				
			}
			if ((line.contains("|") && line.contains("-"))) {
				listOfStrings.add(line);
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
				else if (listOfStrings.size() == count || listOfStrings.size() == count) {
					s1 = (listOfStrings).get(0);
					s2 = (listOfStrings).get(1);
					s3 = (listOfStrings).get(2);
					s4 = (listOfStrings).get(3);
					// fixes no letters in front
					if (s1.charAt(0)=='|' && s2.charAt(0)=='|' && s3.charAt(0)=='|' && s4.charAt(0)=='|') {
						s1 = "G"+s1;
						s2 = "D"+s2;
						s3 = "A"+s3;
						s4 = "E"+s4;
					}
					if(listOfStrings.size() == count) {
							bass = StringInstrument.getBass(s1,s2,s3,s4);
							//out.append(bass.xmlHeader(count));
							out.append((bass.printToXML(measureForChange, timeSigTops,timeSigBottoms, num1, num2, s1, s2, s3, s4, null, null, null)));
					}
					else if(listOfStrings.size() == count) {
						s5 = (listOfStrings).get(4);
						if (s5.charAt(5)=='|') {
							s5 = "B"+s5;
						}
						bass = StringInstrument.getBass(s1,s2,s3,s4,s5);
						out.append(bass.printToXML(measureForChange, timeSigTops,timeSigBottoms, num1, num2, s1, s2, s3, s4, s5, null, null));
						
					}
					listOfStrings.clear();
				}
			}
		}
		out.append(endHeading());
		myReader.close();
		return out.toString();
		
	}

	// guitar scanner
	public static String callGuitarClass(String text,int count, int num1, int num2){
		Scanner myReader1 = new Scanner(text);
		StringBuilder out = new StringBuilder();
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "";
		ArrayList<String> listOfStrings = new ArrayList<String>();
		out.append(xmlHeader(num1, num2, count));
		int timeSigTop = 0;
		int timeSigBottom = 0;
		Guitar guitar;
		ArrayList<Integer> measureForChange = new ArrayList<Integer>();
		ArrayList<Integer> timeSigTops = new ArrayList<Integer>();
		ArrayList<Integer> timeSigBottoms = new ArrayList<Integer>();
		while (myReader1.hasNextLine()) {
			String line = myReader1.nextLine();
			String tmp = "";
			String tmp1 = "";
			String tmp2 = "";
			int x = 1;
			if (line.contains("Time signature for measure")) {
				for(int i = 0; i < line.length();i++) {
					if (line.charAt(i) == '*' && Character.isDigit(line.charAt(i+1))) {
						while(line.charAt(i+1)!='*') {
							tmp+=line.charAt(i+1);
							i++;
						}
					}
					if (line.charAt(i) == '/') {
						while(line.charAt(i-x) != ' ' && line.charAt(i) =='/') {
							tmp1 = line.charAt(i-x) + tmp1;
							x++;
						}

						while(line.charAt(i+1) != ' ') {
							tmp2+= line.charAt(i+1);
//							System.out.println(tmp2);
							i++;
						}
	
					}
				}
				measureForChange.add(Integer.parseInt(tmp));
				timeSigTops.add(Integer.parseInt(tmp1));
				timeSigBottoms.add(Integer.parseInt(tmp2));
//				System.out.println(measureForChange);
//				System.out.println(timeSigTops);
//				System.out.println(timeSigBottoms);
				x = 0;
				tmp="";
				tmp1="";
				tmp2="";
			}
			if (line.contains("|") && line.contains("-")) {
				listOfStrings.add(line);
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
				else if (listOfStrings.size() == count || listOfStrings.size() == 7) {
					s1 = (listOfStrings).get(0);
					s2 = (listOfStrings).get(1);
					s3 = (listOfStrings).get(2);
					s4 = (listOfStrings).get(3);
					s5 = (listOfStrings).get(4);
					s6 = (listOfStrings).get(5);
					if (s1.charAt(0)=='|' && s2.charAt(0)=='|' && s3.charAt(0)=='|' && s4.charAt(0)=='|' && s5.charAt(0)=='|' && s6.charAt(0)=='|') {
						s1 = "E"+s1;
						s2 = "B"+s2;
						s3 = "G"+s3;
						s4 = "D"+s4;
						s5 = "A"+s5;
						s6 = "D"+s6;
					}
					if(listOfStrings.size() == 6) {
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6);
						out.append(guitar.printToXML(measureForChange, timeSigTops, timeSigBottoms, num1, num2, s1, s2, s3, s4, s5, s6, null));
					}
					else if(listOfStrings.size() == 7) {
						s7 = (listOfStrings).get(6);
						if (s7.charAt(5)=='|') {
							s7 = "B"+s7;
						}
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6,s7);
						out.append(guitar.printToXML(measureForChange, timeSigTops, timeSigBottoms,num1, num2, s1, s2, s3, s4, s5, s6, s7));
						
					}
					listOfStrings.clear();
				}
			}
		}
		out.append(endHeading());
		myReader1.close();
		return out.toString();

	}

}